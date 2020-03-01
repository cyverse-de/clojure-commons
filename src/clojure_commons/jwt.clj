(ns clojure-commons.jwt
  (:use [clojure.java.io :only [file]]
        [medley.core :only [remove-vals]]
        [slingshot.slingshot :only [try+]])
  (:require [buddy.core.keys :as keys]
            [buddy.sign.jwt :as jwt]
            [clj-time.core :as time]
            [clojure.string :as string]
            [clojure-commons.exception-util :as cx-util]))

(defn build-default-assertion
  [validity-window-end {:keys [user email given-name family-name common-name]}]
  (let [now (time/now)]
    (remove-vals nil?
                 {:sub         user
                  :exp         (time/plus now (time/seconds validity-window-end))
                  :iat         now
                  :email       email
                  :given_name  given-name
                  :family_name family-name
                  :name        common-name})))

(defn generator
  ([opts]
     (generator build-default-assertion opts))
  ([assertion-builder {:keys [validity-window-end private-key-path private-key-password alg]}]
     (let [private-key (keys/private-key private-key-path private-key-password)]
       (fn [user]
         (jwt/sign (assertion-builder validity-window-end user)
                   private-key
                   {:alg alg})))))

(defn- list-keys
  [accepted-keys-dir]
  (when-not (string/blank? accepted-keys-dir)
    (map str (filter #(.isFile %) (.listFiles (file accepted-keys-dir))))))

(defn- load-public-keys
  [public-key-path accepted-keys-dir]
  (for [path (cons public-key-path (list-keys accepted-keys-dir))]
    (keys/public-key path)))

(defn- check-key
  [key alg assertion]
  (try+
   (jwt/unsign assertion key {:alg alg})
   (catch [:cause :signature] _ nil)))

(defn- unsign-assertion
  [accepted-keys alg assertion]
  (or (first (remove nil? (map #(check-key % alg assertion) accepted-keys)))
      (throw (ex-info "Untrusted JWT signature."
                      {:type :validation :cause :signature}))))

(defn validator
  [{:keys [public-key-path accepted-keys-dir alg]}]
  (let [accepted-keys (load-public-keys public-key-path accepted-keys-dir)]
    (partial unsign-assertion accepted-keys alg)))

(defn- check-jwk
  [jwk assertion]
  (check-key (keys/jwk->public-key jwk) (:alg jwk) assertion))

(defn jwk-validate
  "Validates a JWT assertion against a set of JWKs (JSON web keys). JSON web keys are intended to be retrieved
   from an identity provider endpoint, so they may change without our knowledge. For this reason, we're not
   going to attempt to memoize the parsed keys like we do for keys stored on the filesystem."
  [jwks assertion]
  (or (first (remove nil? (map #(check-jwk % assertion) jwks)))
      (throw (ex-info "Untrusted JWT signature."
                      {:type :validation :cause :signature}))))

(defn user-from-default-assertion
  [jwt]
  {:user        (:sub jwt)
   :email       (:email jwt)
   :given-name  (:given_name jwt)
   :family-name (:family_name jwt)
   :common-name (:name jwt)})
