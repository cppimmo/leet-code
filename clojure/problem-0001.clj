(ns problem-0001
  (:use [clojure.test :only [is]]))

(declare two-sum) ; Forward declare

(do ; 3 test cases
  (is (= (two-sum [2 7 11 15] 9) [0 1]))
  (is (= (two-sum [3 2 4] 6) [1 2]))
  (is (= (two-sum [3 3] 6) [0 1])))

(defn two-sum [nums target]
  (loop [idx     0
         indexes (->> nums     ; Indexes map contains k: num, v: index
                      (map-indexed (fn [& args] (vec (reverse args))))
                      (reduce merge {}))]
    (if (>= idx (count nums))
      nil ; No summation of two elements equals target
      (let [elem (nth nums idx), complement (- target elem)]
        (if (and (contains? indexes complement)
                 ; Ensure the same element is not considered
                 ; lazy eval ensures calling get here isn't a no no
                 (not= idx (get indexes complement)))
          [idx (get indexes complement)] ; Return result
          (recur (inc idx) indexes)))))) ; Continue search
