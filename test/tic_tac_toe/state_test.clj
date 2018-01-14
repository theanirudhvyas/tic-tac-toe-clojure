(ns tic-tac-toe.state-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.state :as state]))

(defn reset-state-value []
  (reset! state/state-of-game [[false false false] [false false false] [false false false]]))

(deftest update-state-test
  (testing "set an unset state when coordinates are passed"
    (let [x-coordinate 1
          y-coordinate 2
          expected-state [[false false false] [false false true] [false false false]]]
      (reset-state-value)
      (state/update-state! x-coordinate y-coordinate)
      (is (= @state/state-of-game expected-state )))))

(deftest update-state-possible?-test
  (testing "updating is not possible if values are out of range"
    (reset-state-value)
    (is (and (= (state/update-state-possible? -1 3) false)
             (= (state/update-state-possible? -1 -1) false)
             (= (state/update-state-possible? 1 3) false)
             (= (state/update-state-possible? 2 1) true)
             (= (state/update-state-possible? 0 0) true))))
  (testing "updating is not possible if values are already set"
    (reset! state/state-of-game [[true false true] [true true true] [false true false]])
    (is (and (= (state/update-state-possible? 0 0) false)
             (= (state/update-state-possible? 0 1) true)
             (= (state/update-state-possible? 1 1) false)
             (= (state/update-state-possible? 2 0) true)))))

(deftest get-state-at-test
  (testing "gets the value of the state at given coordinates"
    (with-redefs [state/state-of-game (atom [[false false false] [false false true] [false false false]])]
      (is (and (= (state/get-state-at 1 2) true)
               (= (state/get-state-at 1 1) false))))))

(deftest index-in-bounds-test
  (testing "returns true if index in bounds"
    (is (= (state/index-in-bounds? 1 2) true)))
  (testing "returns false if index out of bounds"
    (is (= (state/index-in-bounds? 12 3) false))))