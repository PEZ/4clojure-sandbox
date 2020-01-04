(ns p53)

(comment
  (->> [1 0 1 2 3 0 4 5]
       (partition 2 1)
       (filter (partial apply <=)))

  (map (fn [s]
         (let [lg (not-empty (->> s
                                  (partition 2 1)
                                  (partition-by (partial apply <))
                                  (filter #(apply < (first %)))
                                  (group-by count)))]
           (if lg
             (->> (get lg (apply max (keys lg)))
                  first
                  (#(concat (first %) (map second (rest %)))))
             '())))
       [[1 0 1 2 3 0 4 5]
        [5 6 1 3 2 7]
        [2 3 3 4 5]
        [7 6 5 4]])
  )

(comment
  
  (fn [s]
    (let [lg (not-empty (->> s
                             (partition 2 1)
                             (partition-by (partial apply <))
                             (filter #(apply < (first %)))
                             (group-by count)))]
      (if lg
        (->> (get lg (apply max (keys lg)))
             first
             (#(concat (first %) (map second (rest %)))))
        '())))

  (fn [input]
    (let [grouped-by-length (not-empty (->> input
                                            (partition 2 1)
                                            (partition-by (partial apply <))
                                            (filter #(apply < (first %)))
                                            (group-by count)))]
      (if grouped-by-length
        (as-> grouped-by-length $
          (get $ (apply max (keys $)))
          (first $)
          (concat (first $) (map second (rest $))))
        '())))

  (fn [input]
    (-> (some->> input
                 (partition 2 1)
                 (partition-by (partial apply <))
                 (filter #(apply < (first %)))
                 not-empty
                 (group-by count)
                 (#(get % (apply max (keys %))))
                 first
                 (#(concat (first %) (map second (rest %)))))))

  (fn [input]
    (-> (some->> input
                 (partition 2 1)
                 (partition-by (partial apply <))
                 (filter #(apply < (first %)))
                 not-empty
                 (group-by count))
        (as-> $ (get $ (apply max (keys $)))
          (first $)
          (concat (first $) (map second (rest $))))))

  (fn [input]
    (let [lg (not-empty (->> input
                             (partition 2 1)
                             (partition-by (partial apply <))
                             (filter #(apply < (first %)))
                             (group-by count)))]
      (if lg
        (as-> (get lg (apply max (keys lg))) v
          (first v)
          (concat (first v) (map second (rest v))))
        '()))))