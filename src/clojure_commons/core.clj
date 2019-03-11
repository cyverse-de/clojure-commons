(ns clojure-commons.core
  "General-purpose Clojure functions."
  (:use [medley.core :only [remove-vals]]))

(defn remove-nil-values
  "Removes entries containing nil values from a map."
  [m]
  (assert (map? m) "the argument to remove-nil-values must be a map")
  (remove-vals nil? m))

;; Taken from https://clojuredocs.org/clojure.core/when-let#example-5797f908e4b0bafd3e2a04bb
(defmacro when-let*
  ([bindings & body]
   (if (seq bindings)
     `(when-let [~(first bindings) ~(second bindings)]
        (when-let* ~(drop 2 bindings) ~@body))
     `(do ~@body))))
