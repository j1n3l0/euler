(ns euler.test.core
  (:use [euler.core] :reload)
  (:use [clojure.test]))

(deftest test-problem-001
  (is (= 23 (problem-001 10))
      "solution to (problem-001 10) should be 23"))

(deftest test-problem-002
  (is (= 10 (problem-002 10))
      "solution to (problem-002 10) should be 10"))
