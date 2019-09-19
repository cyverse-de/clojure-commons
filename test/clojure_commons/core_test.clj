(ns clojure-commons.core-test
  (:use [clojure.test]
        [clojure-commons.core]))

(deftest unique-by-with-empty-sequence
  (is (empty? (unique-by :id [])))
  (is (empty? (unique-by identity [])))
  (is (empty? (unique-by (partial + 1) []))))

(defn test-unique-by [f s expected]
  (is (= (sort-by f (unique-by f s))
         (sort-by f expected))))

(deftest unique-by-keyword
  (test-unique-by :foo
                  [{:foo 1 :bar 2} {:foo 2 :bar 2} {:foo 1 :bar 3}]
                  [{:foo 1 :bar 3} {:foo 2 :bar 2}])
  (test-unique-by :bar
                  [{:foo 1 :bar 1} {:foo 2} {:foo 3} {:foo 4 :bar 4}]
                  [{:foo 3} {:foo 1 :bar 1} {:foo 4 :bar 4}]))

(deftest unique-by-fn
  (test-unique-by (fn [n] (mod n 3))
                  [1 3 4 5 7]
                  [3 7 5])
  (test-unique-by (fn [n] (* n n))
                  [1 3 5 7 9]
                  [1 3 5 7 9])
  (test-unique-by count
                  ["foo" "bar" "baz" "quux" "bang" "blargh"]
                  ["baz" "bang" "blargh"]))
