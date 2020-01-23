(ns sandbox.repl-sandbox
  (:gen-class))

(defn add [x y]
  (println "adding" x "+" y)
  (+ x y))

(add 1 2)
