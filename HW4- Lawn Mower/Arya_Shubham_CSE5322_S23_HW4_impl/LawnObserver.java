// Observer pattern is used here that observes the observable and updates when notifyObserver(this) is called.
import java.util.Observer;
import java.awt.Graphics2D;
import java.util.Observable;

class LawnObserver implements Observer {

    @Override
    public void update(Observable obj, Object arg) {
        Controller controller = (Controller)arg;
        Graphics2D g = (Graphics2D) controller.gui.getGraphics();
        controller.cutGrass(g);
    }

}