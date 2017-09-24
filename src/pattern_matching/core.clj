(ns pattern-matching.core
  (gen-class)
  (:require [clojure.core.match :refer [match]]))

(defn my-map [a-coll a-f]
  (loop [coll a-coll
         f a-f
         acc []]
    (match [coll]
           [([] :seq)] acc
           [([x & xs] :seq)] (recur xs f (conj acc (f x))))))

(defn my-map-lazy [coll f]
  (match [coll]
         [([] :seq)] []
         [([x & xs] :seq)] (lazy-seq (cons (f x) (my-map-lazy xs f)))))

(defn ten-fold [n]
  (* n 10))

(defn infinite-ten-fold []
  (my-map-lazy (range) ten-fold))

(defn -main
  [& args]
  (println [(my-map [1 2 3] ten-fold)
            (take 10 (my-map-lazy (range) inc))
            (take 10 (infinite-ten-fold))]))
