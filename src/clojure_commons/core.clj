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

(defn unique-by
  "Returns a list of items in a sequence for which a function returns unique values. For example, to return a list
   of maps in a list with a unique :id field, you could run (unique-by :id map-list)."
  [f s]
  (vals (into {} (map (juxt f identity) s))))
