// defines methods for each transition in the state machine and implements it as return self.
public class MowerState {
    MowerState moveRight(MowerContext context){return this;}
    MowerState moveLeft(MowerContext context){return this;}
    MowerState turnRight(MowerContext context){return this;}
    MowerState turnLeft(MowerContext context){return this;}
    MowerState moveDown(MowerContext context){return this;}
}