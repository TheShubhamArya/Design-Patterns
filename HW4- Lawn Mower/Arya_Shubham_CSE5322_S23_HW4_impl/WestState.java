public class WestState extends MowerState {

    @Override
    public MowerState moveLeft(MowerContext context) {
        context.column -= 1;
        return context.westState;
    }
    
    @Override
    public MowerState turnLeft(MowerContext context) {
        return context.southWestState;
    }
}