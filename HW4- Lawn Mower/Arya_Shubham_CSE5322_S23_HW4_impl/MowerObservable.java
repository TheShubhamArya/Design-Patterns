// Observer patter is used here. The Observable class is created here that looks observers for any change.
import java.util.Observable;

// Observable
class MowerObservable extends Observable {
    void mow(Controller controller) {
        // notify observer when advances a square
        //set change
        setChanged();
        //notify observers for change
        notifyObservers(controller);
    }
}
