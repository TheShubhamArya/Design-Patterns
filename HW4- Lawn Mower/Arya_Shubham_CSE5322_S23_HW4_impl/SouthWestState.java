public class SouthWestState extends MowerState {

    @Override
    public MowerState moveDown(MowerContext context) {
        context.row += 1;
        return context.eastState;
    }
}
