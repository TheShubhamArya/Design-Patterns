import java.awt.*;

class Circle implements Shape {
    int radius = 50;
    int x;
    int y;

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x, y, radius, radius);
        g2d.setColor(Color.white);
        g2d.fillOval(x+1, y+1, radius-2*1, radius-2*1);
    }
}
