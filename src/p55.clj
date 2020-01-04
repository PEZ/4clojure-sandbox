(ns p55)

(comment
  (#(into {} (for [[k v] (group-by identity %)] [k (count v)]))
   [1 1 2 3 2 1 1])
  
  ((fn [s]
     (->> s
          (sort-by identity)
          (partition-by identity)
          (mapcat (fn [i] [(first i) (count i)]))
          (apply hash-map)))
   [1 1 2 3 2 1 1]))
