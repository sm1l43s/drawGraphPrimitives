package shape;

import java.awt.*;

public class Oval extends Shape {

    int x;
    int y;

    int width;
    int height;

    Color shapeColor;

    public Oval() {
        super(Color.WHITE, 0);
    }

    public Oval(int x, int y, int width, int height, Color shapeColor, Color fillColor, int numLayer) {
        super(fillColor, numLayer);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shapeColor = shapeColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(Color shapeColor) {
        this.shapeColor = shapeColor;
    }
}
