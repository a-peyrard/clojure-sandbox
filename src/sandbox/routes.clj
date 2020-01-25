(ns sandbox.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]))

(defn hello-handler
  "Hello world basic handler"
  []
  (response "world"))

(defroutes handlers
           (GET "/hello" [] (hello-handler))
           (route/not-found {:status 404}))

(def app handlers)
