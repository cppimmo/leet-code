(ns problem-0144
  (:use [clojure.test :only [deftest is testing]]))

(declare preorder-traversal) ; Forward declare

(deftest preorder-traversal-test
  (testing "Three test cases."
    (is (set= (preorder-traversal '(1 (nil (2 (3 nil))))) [1 2 3]))
    ))

(defn preorder-traversal [root]
  (loop [current root
         elems (first root)]
    (if (nil? current)
      elems
      (do
        (recur ))))
  )
