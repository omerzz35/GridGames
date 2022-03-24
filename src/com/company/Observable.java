package com.company;

public interface Observable {
    /**
     * @param observer - observer
     * add observer to observers
     */
    void addObserver(Observer observer);

    /**
     * @param observer - observer
     * remove observer from observers
     */
    void removeObserver(Observer observer);

    /**
     * notify all observers
     */
    void notifyObservers();

    /**
     * @param boardString
     * change the Value
     */
    void changeValue(Piece[][] boardString);
}
