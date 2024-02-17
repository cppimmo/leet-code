(ns problem-0014)

(defn longest-common-prefix [strs]
  (letfn [(common-prefix [a b]
            (apply str (take-while #(= (first a) %) b)))]
    (if (empty? strs)
      ""
      (reduce common-prefix strs))))
