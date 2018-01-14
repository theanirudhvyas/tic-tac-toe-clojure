(ns tic-tac-toe.user-interface
  (:require [tic-tac-toe.state :as state]
            [tic-tac-toe.domain-logic :refer [winning-state?]]
            [clojure.string :as str]))

(defn split-by-whitespace [string]
  (str/split string #"\s+"))

(defn take-user-input []
  (into [] (map #(Integer/parseInt %) (split-by-whitespace (read-line)))))

(defn process []
  (loop [input (take-user-input)]
    (when-not (winning-state?)
      (let [x-coordinate (input 0)
            y-coordinate (input 1)]
        (if (state/update-state-possible? x-coordinate y-coordinate)
          (do (state/update-state! x-coordinate y-coordinate)
              (state/display-state)
              (state/toggle-player))
          (println "input value invalid, retry!")))
      (recur (take-user-input))))
  )