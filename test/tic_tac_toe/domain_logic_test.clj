(ns tic-tac-toe.domain-logic-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.domain-logic :as domain-logic]
            [tic-tac-toe.state :as state]))

(deftest winning-state?-test
  (testing "it is a winning situation if state is one of the 8 winning states"
    (with-redefs [state/state-of-game (atom [1 1 1 0 0 0 0 0 0])]
      (is (= (domain-logic/winning-state?) true))))
  (testing "it is not a winning situation if state is not in one of the 8 winning states"
    (with-redefs [state/state-of-game (atom [0 1 1 0 0 0 0 0 0])]
      (is (= (domain-logic/winning-state?) false)))))
