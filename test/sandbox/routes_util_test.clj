(ns sandbox.routes-util-test
  (:require [clojure.test :refer :all])
  (:require [sandbox.routes-util :refer [format-method elapsed-time]]))

(deftest format-method-test
  (testing "it should upper case the keyword method"
    (is (= "GET" (format-method (keyword 'get))))))

(deftest elapsed-time-test
  (testing "it should get the difference in millis between two nano time"
    (is (= 5.0 (elapsed-time 1000000 6000000)))))
