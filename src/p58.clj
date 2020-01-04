(ns p58)

(comment
  (((fn c
      ;Cheating by looking at clojure.core/comp =)
      ([] identity)
      ([f] f)
      ([f g]
       (fn [& args]
         (f (apply g args))))
      ([f g & fs]
       (apply c (c f g) fs)))
    rest reverse) [1 2 3 4]))
