(ns clojure-commons.json-test
  (:require [clojure.test :refer [deftest is]]
            [clojure-commons.json :refer [body->json string->json]])
  (:import [java.io StringReader]))

(def ^:private test-json "{\"foo\":\"bar\"}")

(defn- test-json-stream
  []
  (StringReader. test-json))

(deftest string->json-test
  (is (= {:foo "bar"} (string->json test-json))
      "string->json with one argument")
  (is (= {:foo "bar"} (string->json test-json true))
      "string->json with two arguments and keywordization enabled")
  (is (= {"foo" "bar"} (string->json test-json false))
      "string->json with two arguments and keywordization disabled"))

(deftest body->json-test
  (is (= {:foo "bar"} (body->json (test-json-stream)))
      "body->json with one argument")
  (is (= {:foo "bar"} (body->json (test-json-stream) true))
      "body->json with one argument and keywordization enabled")
  (is (= {"foo" "bar"} (body->json (test-json-stream) false))
      "body->json with one argument and keywordization disabled"))
