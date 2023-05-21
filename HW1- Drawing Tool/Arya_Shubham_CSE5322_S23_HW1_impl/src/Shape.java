import java.awt.*;

interface Shape {
    public int x = -9999; // give some default values to point that is not on drawing area
    public int y = -9999;

    void draw(Graphics2D g2d);

    void setPosition(int x, int y);
}
