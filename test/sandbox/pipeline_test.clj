(ns sandbox.pipeline-test
  (:require [clojure.test :refer :all]))

(defn add [x y]
  (+ x y))

(defn doto-pipeline [x]
  (doto x
    (add 2)
    (add 3)))

(defn arrow-pipeline [x]
  (-> x
      (add 2)
      (add 3)))

(deftest doto-pipeline-test
  (testing "it should return the initial parameter"
    (is (= (doto-pipeline 4) 4))))

(deftest arrow-pipeline-test
  (testing "it should transmit last result to next function"
    (is (= (arrow-pipeline 4) 9))))
