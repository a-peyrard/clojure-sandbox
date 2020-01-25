(ns sandbox.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]
            [clojure.tools.logging :as log]))

(defn hello-handler
  "Hello world basic handler"
  []
  (log/info "hello has been requested \uD83D\uDE0A")
  (response "world"))

(defroutes handlers
           (GET "/hello" [] (hello-handler))
           (route/not-found {:status 404}))

(def app handlers)
