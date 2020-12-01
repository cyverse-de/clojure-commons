(ns clojure-commons.config-test
  (:use [clojure.test])
  (:require [clojure-commons.test-configs :as tc])
  (:import [java.util Properties]))

(defn check-configs []
  (is (= "bar" (tc/foo)))
  (is (= "quux" (tc/baz)))
  (is (resolve 'clojure-commons.test-configs/enabled-string))
  (is (= "Ni!" (tc/enabled-string)))
  (is (resolve 'clojure-commons.test-configs/disabled-string))
  (is (nil? (tc/disabled-string)))
  (is (= "blarg" (tc/defined-optional-string)))
  (is (= "" (tc/undefined-optional-string)))
  (is (= "The foo is in the bar." (tc/undefined-optional-string-with-default)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-string))
  (is (= "" (tc/enabled-optional-string)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-string-with-default))
  (is (= "This is an enabled optional string." (tc/enabled-optional-string-with-default)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-string))
  (is (nil? (tc/disabled-optional-string)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-string-with-default))
  (is (nil? (tc/disabled-optional-string-with-default)))
  (is (= ["foo" "bar" "baz"] (tc/required-vector)))
  (is (resolve 'clojure-commons.test-configs/enabled-vector))
  (is (= ["z'bang" "zoom" "boing"] (tc/enabled-vector)))
  (is (resolve 'clojure-commons.test-configs/disabled-vector))
  (is (nil? (tc/disabled-vector)))
  (is (= ["baz" "bar" "foo"] (tc/defined-optional-vector)))
  (is (= [] (tc/undefined-optional-vector)))
  (is (= (mapv str (range 5)) (tc/undefined-optional-vector-with-default)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-vector))
  (is (= [] (tc/enabled-optional-vector)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-vector-with-default))
  (is (= (mapv str (range 10)) (tc/enabled-optional-vector-with-default)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-vector))
  (is (nil? (tc/disabled-optional-vector)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-vector-with-default))
  (is (nil? (tc/disabled-optional-vector-with-default)))
  (is (= 27 (tc/required-int)))
  (is (resolve 'clojure-commons.test-configs/enabled-int))
  (is (= 4 (tc/enabled-int)))
  (is (resolve 'clojure-commons.test-configs/disabled-int))
  (is (nil? (tc/disabled-int)))
  (is (= 53 (tc/defined-optional-int)))
  (is (zero? (tc/undefined-optional-int)))
  (is (= 42 (tc/undefined-optional-int-with-default)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-int))
  (is (zero? (tc/enabled-optional-int)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-int-with-default))
  (is (= 55 (tc/enabled-optional-int-with-default)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-int))
  (is (nil? (tc/disabled-optional-int)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-int-with-default))
  (is (nil? (tc/disabled-optional-int-with-default)))
  (is (= 72 (tc/required-long)))
  (is (resolve 'clojure-commons.test-configs/enabled-long))
  (is (= 97 (tc/enabled-long)))
  (is (resolve 'clojure-commons.test-configs/disabled-long))
  (is (nil? (tc/disabled-long)))
  (is (= 35 (tc/defined-optional-long)))
  (is (zero? (tc/undefined-optional-long)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-long))
  (is (zero? (tc/enabled-optional-long)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-long-with-default))
  (is (= 99 (tc/enabled-optional-long-with-default)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-long))
  (is (nil? (tc/disabled-optional-long)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-long-with-default))
  (is (nil? (tc/disabled-optional-long-with-default)))
  (is (true? (tc/required-boolean)))
  (is (resolve 'clojure-commons.test-configs/enabled-boolean))
  (is (true? (tc/enabled-boolean)))
  (is (resolve 'clojure-commons.test-configs/disabled-boolean))
  (is (nil? (tc/disabled-boolean)))
  (is (true? (tc/defined-optional-boolean)))
  (is (false? (tc/undefined-optional-boolean)))
  (is (true? (tc/undefined-optional-boolean-with-default)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-boolean))
  (is (false? (tc/enabled-optional-boolean)))
  (is (resolve 'clojure-commons.test-configs/enabled-optional-boolean-with-default))
  (is (true? (tc/enabled-optional-boolean-with-default)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-boolean))
  (is (nil? (tc/disabled-optional-boolean)))
  (is (resolve 'clojure-commons.test-configs/disabled-optional-boolean-with-default))
  (is (nil? (tc/disabled-optional-boolean-with-default)))
  (is (resolve 'clojure-commons.test-configs/multiple-enabled-flags))
  (is (= "multiple-enabled-flags" (tc/multiple-enabled-flags)))
  (is (resolve 'clojure-commons.test-configs/mixed-feature-flags))
  (is (= "mixed-feature-flags" (tc/mixed-feature-flags)))
  (is (resolve 'clojure-commons.test-configs/multiple-disabled-flags))
  (is (nil? (tc/multiple-disabled-flags)))
  (is (tc/configs-defined?))
  (is (tc/configs-valid?)))

(deftest configs-from-map
  (require 'clojure-commons.test-configs :reload)
  (tc/load-from-map
   {"enabled-flag"             "true"
    "disabled-flag"            "false"
    "foo"                      "bar"
    "baz"                      "quux"
    "enabled-string"           "Ni!"
    "defined-optional-string"  "blarg"
    "required-vector"          "foo, bar, baz"
    "enabled-vector"           "z'bang, zoom, boing"
    "defined-optional-vector"  "baz, bar, foo"
    "required-int"             "27"
    "enabled-int"              "4"
    "defined-optional-int"     "53"
    "required-long"            "72"
    "enabled-long"             "97"
    "defined-optional-long"    "35"
    "required-boolean"         "true"
    "enabled-boolean"          "true"
    "defined-optional-boolean" "true"})
  (check-configs))

(deftest configs-from-file
  (require 'clojure-commons.test-configs :reload)
  (tc/load-from-file "test-resources/config.properties")
  (check-configs))

(deftest missing-required-config
  (require 'clojure-commons.test-configs :reload)
  (tc/load-from-map {})
  (is (not (tc/configs-valid?))))
