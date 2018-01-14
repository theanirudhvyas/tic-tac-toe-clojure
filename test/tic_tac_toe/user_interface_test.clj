(ns tic-tac-toe.user-interface-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.user-interface :as user-interface]))

(deftest split-by-whitespace-test
  (testing "splits a string across spaces"
    (is (= (user-interface/split-by-whitespace "a b c d") '("a" "b" "c" "d")))))

(deftest take-user-input-test
  (testing "takes user input and converts into integer vector"
    (with-redefs [read-line (constantly "1 2 3")]
      (is (= (user-interface/take-user-input) [1 2 3])))))