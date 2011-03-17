(ns euler.core)

(defn problem-001
  "Solution to Euler problem 001"
  [n]
  (apply + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range n))))
