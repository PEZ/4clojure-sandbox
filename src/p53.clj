(ns p53)

(comment
  (->> [1 0 1 2 3 0 4 5]
       (partition 2 1)
       (filter (partial apply <=)))

  (map (fn [input]
         (let [length-groups (->> input
                                  (partition 2 1)
                                  (partition-by (partial apply <))
                                  (filter #(apply < (first %)))
                                  (group-by count))]
           (if-not (empty? length-groups)
             (->> (get length-groups (apply max (keys length-groups)))
                  first
                  (#(concat (first %) (map second (rest %)))))
             '())))
       [[1 0 1 2 3 0 4 5]
        [5 6 1 3 2 7]
        [2 3 3 4 5]
        [7 6 5 4]])
  )