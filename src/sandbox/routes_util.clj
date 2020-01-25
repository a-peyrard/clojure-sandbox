(ns sandbox.routes-util
  (:require [clojure.tools.logging :as log])
  (:require [clojure.string :as str])
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn now-nano
  "Get the current nano time"
  []
  (System/nanoTime))

(defn elapsed-time
  "Get the elapsed time between two nano times"
  [start end]
  (float (/ (- end start) 1000000)))

(defn format-method
  "format the method name (GET is more readable than :get)"
  [method]
  (-> method
      (name)
      (str/upper-case)))

(defn wrap-response-time
  "Logs duration of the request treatment"
  [handler]
  (fn [request]
    (let [{method       :request-method
           uri          :uri
           query-string :query-string} request
          start-time (now-nano)
          response (handler request)]
      (log/debug (format
                   "%s %s%s response status %s computed in %.2fms"
                   (format-method method)
                   uri
                   (if-not (nil? query-string) query-string "")
                   (:status response)
                   (elapsed-time start-time (now-nano))))
      response)))