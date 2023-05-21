public class EastState extends MowerState {

    @Override
    public MowerState moveRight(MowerContext context) {
        context.column += 1;
        return context.eastState;
    }
    
    @Override
    public MowerState turnRight(MowerContext context) {
        return context.southEastState;
    }
}
