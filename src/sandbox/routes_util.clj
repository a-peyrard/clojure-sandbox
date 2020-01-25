(ns sandbox.routes-util
  (:require [clojure.tools.logging :as log]))

(defn wrap-response-time
  "Logs duration of the request treatment"
  [handler]
  (fn [request]
    (let [response (handler request)]
      (log/debug "we are in the wrapper...")
      response)))