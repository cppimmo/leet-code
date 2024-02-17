(ns problem-0001
  (:use [clojure.test :only [is]]))

(declare two-sum)

(do
  (is (= (two-sum [2 7 11 15] 9) [0 1]))
  (is (= (two-sum [3 2 4] 6) [1 2]))
  (is (= (two-sum [3 3] 6) [0 1])))

(defn two-sum [nums target]
  (loop [idx 0
         elems (hash-map)]
    (let [curr-elem (nth nums idx)
          complement (- target curr-elem)]
      (if (contains? elems complement)
        (get elems complement)
        (recur (inc idx) (assoc elems curr-elem idx))))))
