// Controller pattern is used here to take responsibility away from GUI.
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller implements ActionListener {
    private final Color GRASS_COLOR = new Color(0, 102, 0);
    private final Color MOWER_COLOR = new Color(0, 180, 0);
    public boolean[][] A;
    public GUI gui;
    public MowerContext context;
    public int rows, cols;
    public Timer timer;

    MowerObservable mower = new MowerObservable();
    LawnObserver lawnArea = new LawnObserver();

    public Controller(GUI gui) {
        this.rows = gui.rows;
        this.cols = gui.cols;
        A = new boolean[rows][cols];
        this.gui = gui;
        context = new MowerContext();
        timer = new Timer(500, this);
        // lawn area is added as an observer to the mow observable
        mower.addObserver(lawnArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            timerTimedOut();
        }
    }

    public void cutGrass(Graphics2D g) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j]) {
                    g.setColor(MOWER_COLOR);
                } else {
                    g.setColor(GRASS_COLOR);
                }
                g.fillRect(j * 50, i * 50, 50, 50);
            }
        }
    }

    public void startButtonAction() {
        if (!isLawnMowed()) {
            timer.start();
        }
    }

    public void stopButtonAction() {
        timer.stop();
    }

    private void timerTimedOut() {
        if (!isLawnMowed()) {
            A[context.row][context.column] = true;
        }
        mower.mow(this);
        context.move(cols);
    }

    private Boolean isLawnMowed(){ 
        if (context.column >= rows || context.row >= cols) {
            timer.stop();
            return true;
        }
        return false;
    }
}
