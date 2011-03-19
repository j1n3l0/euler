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

(deftest test-problem-004
  (is (= 9009 (problem-004 (range 99 0 -1)))
      "solution to (problem-004 (range 99 0 -1)) should be 9009"))

(deftest test-problem-005
  (is (= 2520 (problem-005 10))
      "solution to (problem-005 10) should be 2520"))

(deftest test-problem-006
  (is (= 2640 (problem-006 10))
      "solution to (problem-006 10) should be 2640"))

(deftest test-problem-007
  (is (= 13 (problem-007 6))
      "solution to (problem-007 6) should be 13"))

(deftest test-problem-008
  (is (= 15120 (problem-008 123456789))
      "solution to (problem-008 123456789) should be 15120"))

(deftest test-problem-009
  (is (= 60 (problem-009 12))
      "solution to (problem-009 12) should be 60"))

(deftest test-problem-010
  (is (= 17 (problem-010 10))
      "solution to (problem-010 10) should be 17"))

(deftest test-problem-016
  (is (= 7 (problem-016 10))
      "solution to (problem-016 10) should be 7"))
