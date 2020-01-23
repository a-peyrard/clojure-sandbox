(ns sandbox.core
  (:gen-class))

(defn add [x y]
  (println "adding" x "+" y)
  (+ x y))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "1 + 2 =" (add 1 2))
  (println "Hello, World!"))
