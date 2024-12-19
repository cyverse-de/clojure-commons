(ns clojure-commons.template-test
  (:require [clojure-commons.template :refer [render]]
            [clojure.test :refer [deftest is testing]]))

(deftest test-render
  (let [cases [{:desc     "base case"
                :fmt      "This is a {{foo}} of the {{bar}}."
                :vals     {:foo "test" :bar "Emergency Broadcast System"}
                :expected "This is a test of the Emergency Broadcast System."}
               {:desc     "empty format string"
                :fmt      ""
                :vals     {:another "test"}
                :expected ""}
               {:desc     "missing key"
                :fmt      "This is a {{foo}} of the {{bar}}."
                :vals     {:foo "test"}
                :expected "This is a test of the {{bar}}."}
               {:desc     "empty template string"
                :fmt      "This is a {{foo}} of the {{}}."
                :vals     {:foo "test"}
                :expected "This is a test of the {{}}."}
               {:desc     "number and UUID values"
                :fmt      "This is test {{foo}} for UUID {{bar}}."
                :vals     {:foo 5 :bar (parse-uuid "feedface-cafe-b0ba-feed-facedeadbeaf")}
                :expected "This is test 5 for UUID feedface-cafe-b0ba-feed-facedeadbeaf."}]]
    (doseq [{:keys [desc fmt vals expected]} cases]
      (testing desc
        (is (= expected (render fmt vals)))))))
