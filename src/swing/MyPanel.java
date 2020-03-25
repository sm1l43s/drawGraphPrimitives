package swing;

import logic.Parser;
import shape.*;
import shape.Polygon;
import shape.Shape;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Parser parser;

    MyPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        repaint();
        parser = new Parser();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        parser.getAllPrimitivesList().forEach((n) -> paintPrimitives(g2, (Shape) n, new DrawObject()));
    }

    private void paintPrimitives(Graphics2D g2, Shape shape, DrawObject draw) {
        if (shape instanceof Line) {
            draw.paintLine(g2, (Line) shape);
        } else if (shape instanceof Arc) {
            draw.paintArc(g2, (Arc) shape);
        } else if (shape instanceof Oval) {
            draw.paintOval(g2, (Oval) shape);
        } else if (shape instanceof Rect) {
            draw.paintRect(g2, (Rect) shape);
        } else if (shape instanceof Polygon) {
            draw.paintPolygon(g2, (Polygon) shape);
        } else if (shape instanceof Polyline) {
            draw.paintPolyline(g2, (Polyline) shape);
        }
    }
}
