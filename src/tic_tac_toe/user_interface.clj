(ns tic-tac-toe.user-interface
  (:require [tic-tac-toe.state :as state]
            [tic-tac-toe.domain-logic :refer [winning-state?]]
            [clojure.string :as str]
            [tic-tac-toe.minimax :as ai]))

(defn split-by-whitespace [string]
  (str/split string #"\s+"))

(defn take-user-input []
  (try
    (into [] (map #(Integer/parseInt %) (split-by-whitespace (read-line))))
    (catch Exception e
      (println "Error, retry! Entry should be integers seperated by spaces")
      [-1 -1])))

(defn process []
  (loop [input (take-user-input)]
    (when-not (winning-state?)
      (let [x-coordinate (input 0)
            y-coordinate (input 1)]
        (if (state/update-state-possible? x-coordinate y-coordinate)
          (do (state/update-state! x-coordinate y-coordinate)
              (state/toggle-player)
              (state/update-state! (ai/select-random-position))
              (state/display-state)
              (state/toggle-player))
          (println "input value invalid, retry!")))
      (recur (take-user-input))))
  (if @state/current-player
    (println "Player 1 wins!!")
    (println "Computer wins!!")))
