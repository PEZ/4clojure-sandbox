(ns p54)

(comment
  (#(loop [r %2
           p []]
      (if (>= (count r) %1)
        (recur (drop %1 r) (conj p (take %1 r)))
        p))

   3 (range 9))

  (fn [c r]
    (loop [r r
           p []]
      (if (>= (count r) c)
        (recur (drop c r) (conj p (take c r)))
        p))))

