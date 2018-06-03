(ns tic-tac-toe.state)

(def state-of-game (atom [0 0 0 0 0 0 0 0 0]))

(def current-player (atom true))

(defn translate-coordinates [x-coordinate y-coordinate]
  (+ (* 3 x-coordinate) y-coordinate))

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
  (doseq [row @state-of-game]
    (do
      (println "-------------")
      (print "| ")
      (doseq [col row]
          (do
            (cond
              (= col 1) (print (str "X" " | "))
              (= col 2) (print (str "O" " | "))
              :else (print (str " " " | ")))))
      (print "\n")))
  (println "-------------"))


(defn toggle-player []
  (swap! current-player not))
