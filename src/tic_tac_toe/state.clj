(ns tic-tac-toe.state)

(def state-of-game (atom [[false false false] [false false false] [false false false]]))

(defn update-state! [x y]
    (swap! state-of-game update-in [x y] not))

(defn index-in-bounds? [x-coordinate y-coordinate]
  (and (> x-coordinate -1) (< x-coordinate 3) (> y-coordinate -1) (< y-coordinate 3)))

(defn update-state-possible? [x-coordinate y-coordinate]
  (if (index-in-bounds? x-coordinate y-coordinate)
    (= ((@state-of-game x-coordinate) y-coordinate) false)
    false))

(defn display-state []
  (doseq [row @state-of-game]
    (do
      (println "-------------")
      (print "| ")
      (doseq [col row]
          (do
            (if (true? col)
              (print (str "X" " | "))
              (print (str " " " | ")))))
      (print "\n")))
  (println "-------------"))

(defn get-state-at [x-coordinate y-coordinate]
  (if index-in-bounds?
    ((@state-of-game x-coordinate) y-coordinate)
    nil))