// This class represents the concrete state of Start state which inherits the MowerState. The implementation does the work
// for transition and returns the destination state. From the OOSE book by David C Kung, this class would be S0/S1.
public class StartState extends MowerState {

    @Override
    public MowerState stopMowing(MowerContext context) {
        return context.stopState;
    }
    
    @Override
    public MowerState mow(MowerContext context) {
        return context.startState;
    }
}
