// This class represents the concrete state of Stop state which inherits the MowerState. The implementation does the work
// for transition and returns the destination state. From the OOSE book by David C Kung, this class would be S0/S1.
public class StopState extends MowerState {
    @Override
    public MowerState startMowing(MowerContext context) {
        return context.startState;
    }
}
