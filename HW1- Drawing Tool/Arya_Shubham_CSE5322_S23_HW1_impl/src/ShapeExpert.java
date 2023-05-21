import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// This class incorporates the expert design pattern as it has knowledge of all the shapes.
public class ShapeExpert {
    // shapes utilizes a composite pattern 
    Collection<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void draw(Graphics2D g2d) {
        // Iterator pattern
        Iterator<Shape> it = shapes.iterator();
        // this repaints all the shapes again.
        while (it.hasNext()) {
            it.next().draw(g2d);
        }
        
    }
}
