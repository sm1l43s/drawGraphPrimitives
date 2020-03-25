package shape;

import java.awt.*;

public class Shape {
    Color fillColor;
    int numLayer;

    private Shape() {}

    public Shape(Color fillColor, int numLayer) {
        this.fillColor = fillColor;
        this.numLayer = numLayer;
    }

    public int getNumLayer() {
        return numLayer;
    }

    public void setNumLayer(int numLayer) {
        this.numLayer = numLayer;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
