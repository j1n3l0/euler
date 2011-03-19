(ns euler.test.core
  (:use [euler.core] :reload)
  (:use [clojure.test]))

(deftest test-problem-001
  (is (= 23 (problem-001 10))
      "solution to (problem-001 10) should be 23"))

(deftest test-problem-002
  (is (= 10 (problem-002 10))
      "solution to (problem-002 10) should be 10"))

(deftest test-problem-003
  (is (= 29 (problem-003 13195))
      "solution to (problem-003 13195) should be 29"))

(deftest test-problem-005
  (is (= 2520 (problem-005 10))
      "solution to (problem-005 10) should be 2520"))

(deftest test-problem-006
  (is (= 2640 (problem-006 10))
      "solution to (problem-006 10) should be 2640"))
