package com.company;

public interface Observable {
    void notifyObservers();
    void changeValue(Piece[][] boardString);
}
