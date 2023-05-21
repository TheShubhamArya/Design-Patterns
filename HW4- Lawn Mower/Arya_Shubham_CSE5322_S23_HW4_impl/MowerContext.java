// This class represents the object that possesses the state dependent behavior. It provides client interface and 
// defines operations for each transition in the state machine. In page 336 of OOSE by David C Kung, this class refers
// the "Subject" class
public class MowerContext{

    public int column = 0;
    public int row = 0;

    public MowerState eastState;
    public MowerState westState;
    public MowerState southEastState;
    public MowerState southWestState;
    public MowerState currentState;

    public MowerContext() {
        this.eastState = new EastState();
        this.westState = new WestState();
        this.southEastState = new SouthEastState();
        this.southWestState = new SouthWestState();
        this.currentState = eastState;
    }

    private void moveRight() {
        currentState = currentState.moveRight(this);
    }

    private void moveLeft() {
        currentState = currentState.moveLeft(this);
    }

    private void turnRight() {
        currentState = currentState.turnRight(this);
    }

    private void turnLeft() {
        currentState = currentState.turnLeft(this);
    }

    private void moveDown() {
        currentState = currentState.moveDown(this);
    }

    public void move(int cols) {
        if (currentState instanceof EastState) {
            if (column == cols - 1) {
                turnRight();
                moveDown();
            } else {
                moveRight();
            }
        } else if (currentState instanceof WestState) {
            if (column == 0) {
                turnLeft();
                moveDown();
            } else {
                moveLeft();
            }
        }
    }
    
}
