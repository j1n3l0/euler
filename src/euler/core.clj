(ns euler.core)

;; Utility vars and functions ...

(def fib
  (lazy-cat [0 1] (map + fib (rest fib))))

;; Solutions ...

(defn problem-001
  "Solution to Euler problem 001"
  [n]
  (apply + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range n))))

(defn problem-002
  "Solution to Euler problem 002"
  [n]
  (reduce + (filter even? (take-while #(< % n) fib))))
