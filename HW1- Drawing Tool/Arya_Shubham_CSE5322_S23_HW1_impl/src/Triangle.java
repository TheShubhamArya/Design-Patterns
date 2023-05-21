import java.awt.*;

class Triangle implements Shape {
    int side1 = 50;
    int side2 = 50; 
    int side3 = 50; 
    int x;
    int y;

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics2D g2d) {
        
        int xPointsBorder[] = {0,25,side1};
        int yPointsBorder[] = {0,-43,0};
        int xPoints[] = {2,25,48};
        int yPoints[] = {-2,-41,-2};

        for (int i = 0; i < xPointsBorder.length; i++) {
            xPointsBorder[i] = xPointsBorder[i] + x;
            yPointsBorder[i] = yPointsBorder[i] + y;
            xPoints[i] = xPoints[i] + x;
            yPoints[i] = yPoints[i] + y;
        }

        g2d.setColor(Color.black);
        g2d.fillPolygon(xPointsBorder, yPointsBorder, 3);
        g2d.setColor(Color.white);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
