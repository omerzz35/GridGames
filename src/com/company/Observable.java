package com.company;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void changeValue(Piece[][] boardString);
}
