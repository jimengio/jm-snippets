
(ns app.vm
  (:require [clojure.string :as string]
            [app.config :refer [dev?]]
            ["copy-text-to-clipboard" :as copy!]))

(defn get-view-model [store]
  (let [lines (string/split (or (:snippet store) "") "\n")]
    (assoc store :code (js/JSON.stringify (clj->js lines) nil 2))))

(defn on-action [d! op param options view-model]
  (when dev? (println "Action" op param (pr-str options)))
  (case op
    :input (d! :input (:value options))
    :copy (copy! (:code view-model))
    (do (println "Unknown op:" op))))
