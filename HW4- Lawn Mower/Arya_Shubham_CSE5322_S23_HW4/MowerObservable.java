// package com.concretepage;
import java.util.Observable;

// Obserable
class MowerObservable extends Observable {
    void moved(Controller controller) {
        // notify observer when advances a square
        //set change
        setChanged();
        //notify observers for change
        notifyObservers(controller);
    }
}
