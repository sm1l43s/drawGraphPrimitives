package shape;

import java.awt.*;

public class Polyline extends Shape {
    int[] x;
    int[] y;
    int countPoint;

    public Polyline() {
        super(Color.WHITE, 0);
    }

    public Polyline(Color fillColor, int numLayer) {
        super(fillColor, numLayer);
    }

    public Polyline(int[] x, int[] y, int countPoint, Color fillColor, int numLayer) {
        super(fillColor, numLayer);
        this.x = x;
        this.y = y;
        this.countPoint = countPoint;
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
}
