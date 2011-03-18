(ns euler.core
  (:use [clojure.contrib.lazy-seqs :only [fibs]]))

;; Utility vars and functions ...
(defn- sq [n] (* n n))

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
  (- (sq (reduce + (range (inc n)))) (reduce + (map sq (range (inc n))))))
