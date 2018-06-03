(ns tic-tac-toe.state)

(def state-of-game (atom [0 0 0 0 0 0 0 0 0]))

(def current-player (atom true))

(defn- translate-coordinates [x-coordinate y-coordinate]
  (+ (* 3 x-coordinate) y-coordinate))

(defn- get-marker [value]
  (cond
    (= value 1) "X"
    (= value 2) "O"
    :else " "))


(defn update-state!
  ([x y]
   (update-state! (translate-coordinates x y)))
  ([position]
   (if @current-player
     (swap! state-of-game update-in [position] + 1)
     (swap! state-of-game update-in [position] + 2))))

(defn index-in-bounds? [x-coordinate y-coordinate]
  (and (> x-coordinate -1) (< x-coordinate 3) (> y-coordinate -1) (< y-coordinate 3)))

(defn get-state-at
  ([x-coordinate y-coordinate]
   (get-state-at @state-of-game x-coordinate y-coordinate))
  ([board x-coordinate y-coordinate]
   (if (index-in-bounds? x-coordinate y-coordinate)
     (get board (translate-coordinates x-coordinate y-coordinate))
     nil)))

(defn update-state-possible? [x-coordinate y-coordinate]
  (if (index-in-bounds? x-coordinate y-coordinate)
    (= (get-state-at x-coordinate y-coordinate) 0)
    false))

(defn display-state []
  (println "-------------")
  (println (str "| " (get-marker (@state-of-game 0)) " | " (get-marker(@state-of-game 1)) " | " (get-marker (@state-of-game 2)) " |"))
  (println "-------------")
  (println (str "| " (get-marker (@state-of-game 3)) " | " (get-marker (@state-of-game 4)) " | " (get-marker (@state-of-game 5)) " |"))
  (println "-------------")
  (println (str "| " (get-marker (@state-of-game 6)) " | " (get-marker (@state-of-game 7)) " | " (get-marker (@state-of-game 8)) " |"))
  (println "-------------"))

(defn toggle-player []
  (swap! current-player not))

(defn available-positions
  ([]
   (available-positions @state-of-game))
  ([board]
   (let [available-pos []]
     (flatten
      (map #(if (= (get board %) 0)
              (conj available-pos %)
              available-pos)
           (range 9))))))

(defn turn-player-2? []
  (if (@current-player)
    false
    true))
