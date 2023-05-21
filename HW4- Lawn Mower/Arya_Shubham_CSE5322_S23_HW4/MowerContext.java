// This class represents the object that possesses the state dependent behavior. It provides client interface and 
// defines operations for each transition in the state machine. In page 336 of OOSE by David C Kung, this class refers
// the "Subject" class
public class MowerContext{

    public MowerState currentState;
    public MowerState startState;
    public MowerState stopState;

    public MowerContext() {
        this.startState = new StartState();
        this.stopState = new StopState();
        this.currentState = stopState;
    }

    public void startMowing() {
        currentState = currentState.startMowing(this);
    }

    public void stopMowing() {
        currentState = currentState.stopMowing(this);
    }

    public void mow() {
        currentState = currentState.mow(this);
    }
    
}
