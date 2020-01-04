(ns p56)

(comment
  ((fn [s]
     (loop [d []
            r s]
       (if r
         (recur (if (some #{(first r)} d) d (conj d (first r))) (not-empty (rest r)))
         d)))
   [1 2 1 3 1 2 4])
  
  (some #{1} [1 2 1 3 1 2 4]))

