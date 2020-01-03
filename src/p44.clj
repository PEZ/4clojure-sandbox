(ns p44)



(comment
  (
   (fn [r c]
     (let [l (count c)]
       (map #(nth c (mod (+ r %1) l)) (range l))))
   2 '(1 2 3 4 5)
   )
  )