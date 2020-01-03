(ns p46)

; Write a higher-order function which flips the order of the arguments of an input function.

(fn [f] #(f %2 %1))
