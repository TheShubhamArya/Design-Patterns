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
    public int squareSize = 50;
    public int[] previousTile = new int[]{-1, -1};
    public int currentRow = 0, currentCol = 0;
    public int rows = 5, cols = 5;
    public Timer timer;

    MowerObservable observable = new MowerObservable();
    LawnObserver lawnArea = new LawnObserver();

    public Controller(int rows, int cols, GUI gui) {
        A = new boolean[rows][cols];
        this.gui = gui;
        context = new MowerContext();
        timer = new Timer(500, this);
        observable.addObserver(lawnArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            timerTimedOut();
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j]) {
                    g.setColor(MOWER_COLOR);
                } else {
                    g.setColor(GRASS_COLOR);
                }
                g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }
        g.setColor(GRASS_COLOR);
        g.fillRect(currentCol * squareSize, currentRow * squareSize, squareSize - 1, squareSize - 1);
    }

    public void startButtonAction() {
        if (!isLawnMowed()) {
            timer.start();
            context.startMowing();
        } 
    }

    public void stopButtonAction() {
        context.stopMowing();
        timer.stop();
    }

    private void timerTimedOut() {
        if (isLawnMowed()) {
            observable.moved(this);
            context.stopMowing();
        } else {
            A[currentRow][currentCol] = true;
            observable.moved(this);
            context.mow();
        }
        updateMowerPosition();
    }

    private void updateMowerPosition() {
        int prevCol = currentCol;
        int prevRow = currentRow;
        if (currentCol == cols - 1 && previousTile[1] != currentCol) { //same last column, next row
            currentRow = currentRow + 1;
        } else if (currentCol == 0 && currentRow % 2 == 1) { // same first column, next row
            currentRow = currentRow + 1;
        } else if ((previousTile[1] == currentCol && currentCol == cols - 1) || (currentRow % 2 != 0)) { //last column, but next row or move right if row is even number
            currentCol = currentCol - 1;
        } else if ((previousTile[1] == currentCol && currentCol == 0) || (currentRow % 2 == 0)) { // first column, next row or move left if row is odd numbered
            currentCol = currentCol + 1;
        } 
        previousTile = new int[]{prevRow, prevCol};
    }

    private Boolean isLawnMowed(){ 
        if (currentCol >= rows || currentRow >= cols) {
            return true;
        }
        return false;
    }
}
