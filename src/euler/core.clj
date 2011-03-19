(ns euler.core
  (:use [clojure.contrib.lazy-seqs :only [fibs primes]])
  (:use [clojure.contrib.math :only [floor lcm sqrt]])
  (:use [clojure.contrib.generic.math-functions :only [sqr]]))

;; Utility vars and functions ...
(defn- digits
  "Return the digits of n as a list"
  [n]
  (map #(- (int %) (int \0)) (seq (str n))))

(defn- palindrome?
  "Tests if n is palindromic"
  [n]
  (= (digits n) (reverse (digits n))))

;; Solutions ...

(defn problem-001
  "Solution to Euler problem 001"
  [n]
  (reduce + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range n))))

(defn problem-002
  "Solution to Euler problem 002"
  [n]
  (reduce + (filter even? (take-while #(< % n) (fibs)))))

(defn problem-003
  "Solution to Euler problem 003"
  [n]
  (last (filter #(zero? (mod n %)) (take-while #(< % (int (floor (sqrt n)))) primes))))

(defn problem-004
  "Solution to Euler problem 004"
  [coll]
  (last (sort (filter palindrome? (for [x coll y coll] (* x y))))))

(defn problem-005
  "Solution to Euler problem 005"
  [n]
  (reduce lcm (range 1 (inc n))))

(defn problem-006
  "Solution to Euler problem 006"
  [n]
  (- (sqr (reduce + (range (inc n)))) (reduce + (map sqr (range (inc n))))))

(defn problem-007
  "Solution to Euler problem 007"
  [n]
  (nth primes (dec n)))

(defn problem-010
  "Solution to Euler problem 010"
  [n]
  (reduce + (take-while #(< % n) primes)))
