
(ns app.vm (:require [clojure.string :as string] [app.config :refer [dev?]]))

(defn get-view-model [store] store)

(defn on-action [d! op param options view-model]
  (when dev? (println "Action" op param (pr-str options)))
  (case op (do (println "Unknown op:" op))))
