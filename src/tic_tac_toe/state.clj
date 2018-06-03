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


(defn update-state! [x y]
  (if @current-player
    (swap! state-of-game update-in [(translate-coordinates x y)] + 1)
    (swap! state-of-game update-in [(translate-coordinates x y)] + 2)))

(defn index-in-bounds? [x-coordinate y-coordinate]
  (and (> x-coordinate -1) (< x-coordinate 3) (> y-coordinate -1) (< y-coordinate 3)))

(defn get-state-at [x-coordinate y-coordinate]
  (if (index-in-bounds? x-coordinate y-coordinate)
    (get @state-of-game (translate-coordinates x-coordinate y-coordinate))
    nil))

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
