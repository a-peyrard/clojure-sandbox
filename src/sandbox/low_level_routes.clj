(ns sandbox.low-level-routes)

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

;; => (use 'ring.adapter.jetty)
;; => (use 'sandbox.low-level-routes)
;; => (run-jetty handler {:port 3000})