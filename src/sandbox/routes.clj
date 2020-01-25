(ns sandbox.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response]]))

(defn hello-handler
  "Hello world basic handler"
  []
  (response {:body "world"}))

(defroutes handlers
           (GET "/hello" [] (hello-handler))
           (route/not-found (response {:body "Not Found"})))

(def app handlers)
