(ns tic-tac-toe.domain-logic
  (:require [tic-tac-toe.state :refer [get-state-at state-of-game]]))

(defn winning-state?
  ([]
   (winning-state? @state-of-game))
  ([board]
   (or (and (= (get-state-at board 0 0) 1) (= (get-state-at board 1 1) 1) (= (get-state-at board 2 2) 1))
       (and (= (get-state-at board 0 0) 1) (= (get-state-at board 0 1) 1) (= (get-state-at board 0 2) 1))
       (and (= (get-state-at board 0 0) 1) (= (get-state-at board 1 0) 1) (= (get-state-at board 2 0) 1))
       (and (= (get-state-at board 0 2) 1) (= (get-state-at board 1 1) 1) (= (get-state-at board 2 0) 1))
       (and (= (get-state-at board 1 0) 1) (= (get-state-at board 1 1) 1) (= (get-state-at board 1 2) 1))
       (and (= (get-state-at board 0 1) 1) (= (get-state-at board 1 1) 1) (= (get-state-at board 2 1) 1))
       (and (= (get-state-at board 2 0) 1) (= (get-state-at board 2 1) 1) (= (get-state-at board 2 2) 1))
       (and (= (get-state-at board 0 2) 1) (= (get-state-at board 1 2) 1) (= (get-state-at board 2 2) 1))
       (and (= (get-state-at board 0 0) 2) (= (get-state-at board 1 1) 2) (= (get-state-at board 2 2) 2))
       (and (= (get-state-at board 0 0) 2) (= (get-state-at board 0 1) 2) (= (get-state-at board 0 2) 2))
       (and (= (get-state-at board 0 0) 2) (= (get-state-at board 1 0) 2) (= (get-state-at board 2 0) 2))
       (and (= (get-state-at board 0 2) 2) (= (get-state-at board 1 1) 2) (= (get-state-at board 2 0) 2))
       (and (= (get-state-at board 1 0) 2) (= (get-state-at board 1 1) 2) (= (get-state-at board 1 2) 2))
       (and (= (get-state-at board 0 1) 2) (= (get-state-at board 1 1) 2) (= (get-state-at board 2 1) 2))
       (and (= (get-state-at board 2 0) 2) (= (get-state-at board 2 1) 2) (= (get-state-at board 2 2) 2))
       (and (= (get-state-at board 0 2) 2) (= (get-state-at board 1 2) 2) (= (get-state-at board 2 2) 2)))))
