(ns euler.core
  (:use [clojure.math.numeric-tower :only (floor lcm sqrt)]))

;; Utility vars ...

(def thousand-digit-number
  (str "73167176531330624919225119674426574742355349194934"
       "96983520312774506326239578318016984801869478851843"
       "85861560789112949495459501737958331952853208805511"
       "12540698747158523863050715693290963295227443043557"
       "66896648950445244523161731856403098711121722383113"
       "62229893423380308135336276614282806444486645238749"
       "30358907296290491560440772390713810515859307960866"
       "70172427121883998797908792274921901699720888093776"
       "65727333001053367881220235421809751254540594752243"
       "52584907711670556013604839586446706324415722155397"
       "53697817977846174064955149290862569321978468622482"
       "83972241375657056057490261407972968652414535100474"
       "82166370484403199890008895243450658541227588666881"
       "16427171479924442928230863465674813919123162824586"
       "17866458359124566529476545682848912883142607690042"
       "24219022671055626321111109370544217506941658960408"
       "07198403850962455444362981230987879927244284909188"
       "84580156166097919133875499200524063689912560717606"
       "05886116467109405077541002256983155200055935729725"
       "71636269561882670428252483600823257530420752963450"))

;; Utility functions ...

;; See https://github.com/richhickey/clojure-contrib/blob/
;; 78ee9b3e64c5ac6082fb223fc79292175e8e4f0c/src/main/clojure/
;; clojure/contrib/lazy_seqs.clj#L66 for source
(def primes "Lazy sequence of all the prime numbers."
  (concat
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
          (fn primes-from [n [f & r]]
            (if (some #(zero? (rem n %))
                      (take-while #(<= (* % %) n) primes))
              (recur (+ n f) r)
              (lazy-seq (cons n (primes-from (+ n f) r)))))
          wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2
                        6 4 6 8 4 2 4 2 4 8 6 4 6 2 4 6
                        2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(defn- fibs
  "Returns a lazy sequence of all the Fibonacci numbers."
  []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn- digits
  "Return the digits of n as a list"
  [n]
  (map #(- (int %) (int \0)) (seq (str n))))

(defn- factorial
  "Return the factorial of n"
  [n]
  (reduce * (range 1 (inc n))))

(defn- palindrome?
  "Tests if n is palindromic"
  [n]
  (= (digits n) (reverse (digits n))))

(defn- power
  "Raise n to the power p"
  [n p]
  (reduce * (repeat p n)))

(defn- sqr [n] (* n n))

(defn- pythagorean-triple?
  "Test if [a b c] are a pythagorean triple"
  [a b c]
  (= (+ (sqr a) (sqr b)) (sqr c)))

(def collatz-next
  (memoize
   (fn [n] (when (< 1 n) (if (even? n) (/ n 2) (+ 1 (* n 3)))))))

(defn- collatz-sequence [x]
  (take-while (comp not nil?) (iterate collatz-next x)))

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
  (apply max (filter palindrome? (for [x coll y coll :when (>= x y)] (* x y)))))

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

(defn problem-008
  "Solution to Euler problem 008"
  [n]
  (apply max (map #(reduce * %) (partition 5 1 (digits n)))))

(defn problem-009
  "Solution to Euler problem 009"
  [n]
  (reduce * (first (filter #(apply pythagorean-triple? %)
                           (for [a (range 1 (/ n 3))
                                 b (range (inc a) (/ (- n a) 2))]
                             [a b (- n a b)])))))

(defn problem-010
  "Solution to Euler problem 010"
  [n]
  (reduce + (take-while #(< % n) primes)))

(defn problem-014
  "Solution to Euler problem 014"
  [n]
  (first (keys (apply max-key (comp val first)
         (map #(hash-map % (count (collatz-sequence %))) (range 1 n))))))

(defn problem-016
  "Solution to Euler problem 016"
  [n]
  (reduce + (digits (power 2 n))))

(defn problem-020
  "Solution to Euler problem 020"
  [n]
  (reduce + (digits (factorial n))))
