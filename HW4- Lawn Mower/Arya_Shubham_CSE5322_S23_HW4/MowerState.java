// defines methods for each transition in the state machine and implements it as return self.
public class MowerState {
    MowerState startMowing(MowerContext context){return this;}
    MowerState stopMowing(MowerContext context){return this;}
    MowerState mow(MowerContext context){return this;}
}