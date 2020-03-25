package shape;

import java.awt.*;

public class Polygon extends Shape{

    int[] x;
    int[] y;

    int countPoint;

    Color shapeColor;

    public Polygon() {
        super(Color.WHITE, 0);
    }

    public Polygon(int[] x, int[] y, int countPoint, Color shapeColor, Color fillColor, int numLayer) {
        super(fillColor, numLayer);
        this.x = x;
        this.y = y;
        this.countPoint = countPoint;
        this.shapeColor = shapeColor;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getCountPoint() {
        return countPoint;
    }

    public void setCountPoint(int countPoint) {
        this.countPoint = countPoint;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
}
