(ns p34)

(comment
  (
   (fn r
     ([f t] (r f t []))
     ([f t s] (if (< f t) (lazy-seq (r (inc f) t (conj s f))) s)))
   1 4
   )
  
  )