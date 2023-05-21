import java.awt.*;

 class Box implements Shape {
    int width = 50;
    int height = 50;
    int x;
    int y;

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.white);
        g2d.fillRect(x+1, y+1, width-2*1, height-2*1);
    }
}
