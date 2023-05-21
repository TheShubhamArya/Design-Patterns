import java.awt.*;

// This class incorporates the Controller pattern as it delegates tasks from GUI
class DrawController {
    private DrawGUI gui;
    private ShapeExpert expert;

    public DrawController(DrawGUI gui){
        this.gui = gui;
        this.expert = new ShapeExpert();
    }

    public void drawShape(Shape currentShape, Point point) {
        int x = (int)point.getX();
        int y = (int)point.getY();
        currentShape.setPosition(x, y);
        expert.addShape(currentShape);
        Graphics2D g2d = (Graphics2D) gui.getGraphics();
        expert.draw(g2d);
    }
}
