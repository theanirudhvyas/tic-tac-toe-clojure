(ns tic-tac-toe.minimax
  (:require [tic-tac-toe.state :as state]
            [tic-tac-toe.domain-logic :as domain-logic]))

(defn most-optimal-solution [board]
  )


(defn select-random-position []
  (let [available-positions (state/available-positions)]
    (if (not-empty available-positions)
      (rand-nth available-positions)
      0)))

(defn update-board [board position]
  (if (state/turn-player-2?)
    (update-in board [position] + 2)
    (update-in board [position] + 1)))

(defn calculate-score [board position computer-turn?]
  (let [new-board (update-board board position)]
    (if (domain-logic/winning-state? new-board)
      [position 10]
      [position 0])))

(def board [2 2 0 1 0 0 1 0 0])

(defn select-winning-position
  ([]
    (select-winning-position @state/state-of-game))
  ([board]
   (let [available-positions (state/available-positions board)
         scores              (map #(calculate-score board % true) available-positions)]
     (get (last (sort-by second scores)) 0))))