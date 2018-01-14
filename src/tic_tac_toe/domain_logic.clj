(ns tic-tac-toe.domain-logic
  (:require [tic-tac-toe.state :refer [get-state-at]]))

(defn winning-state? []
  (or (and (get-state-at 0 0) (get-state-at 1 1) (get-state-at 2 2))
      (and (get-state-at 0 0) (get-state-at 0 1) (get-state-at 0 2))
      (and (get-state-at 0 0) (get-state-at 1 0) (get-state-at 2 0))
      (and (get-state-at 0 2) (get-state-at 1 1) (get-state-at 2 0))
      (and (get-state-at 1 0) (get-state-at 1 1) (get-state-at 1 2))
      (and (get-state-at 0 1) (get-state-at 1 1) (get-state-at 2 1))
      (and (get-state-at 2 0) (get-state-at 2 1) (get-state-at 2 2))
      (and (get-state-at 0 2) (get-state-at 1 2) (get-state-at 2 2))))
