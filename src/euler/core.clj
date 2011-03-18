(ns euler.core
  (:use [clojure.contrib.lazy-seqs :only [fibs]]))

;; Utility vars and functions ...

;; Solutions ...

(defn problem-001
  "Solution to Euler problem 001"
  [n]
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range n))))

(defn problem-002
  "Solution to Euler problem 002"
  [n]
  (reduce + (filter even? (take-while #(< % n) (fibs)))))
