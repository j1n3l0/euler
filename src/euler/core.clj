(ns euler.core
  (:use [clojure.contrib.lazy-seqs :only [fibs]])
  (:use [clojure.contrib.generic.math-functions :only [sqr]]))

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

(defn problem-006
  "Solution to Euler problem 006"
  [n]
  (- (sqr (reduce + (range (inc n)))) (reduce + (map sqr (range (inc n))))))
