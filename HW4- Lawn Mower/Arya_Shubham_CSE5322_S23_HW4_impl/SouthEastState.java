public class SouthEastState extends MowerState {

    @Override
    public MowerState moveDown(MowerContext context) {
        context.row += 1;
        return context.westState;
    }
}
