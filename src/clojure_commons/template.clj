(ns clojure-commons.template
  (:require [clojure.string :as string]))

(defn render
  "Takes a format string and a map of interpolation values to substitute into the string."
  [fmt m]
  (string/replace fmt #"\{\{([^\}]+)\}\}" (fn [[orig k]] (str (get m (keyword k) orig)))))
