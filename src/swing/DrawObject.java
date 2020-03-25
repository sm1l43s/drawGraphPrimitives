package swing;

import shape.*;
import shape.Polygon;

import java.awt.*;

public class DrawObject {

    public void paintLine(Graphics2D g2, Line line) {
        g2.setColor(line.getFillColor());
        g2.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    public void paintRect(Graphics2D g2, Rect rect) {
        g2.setColor(rect.getShapeColor());
        g2.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
        g2.setColor(rect.getFillColor());
        g2.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    public void paintArc(Graphics2D g2, Arc arc) {
        g2.setColor(arc.getFillColor());
        g2.drawArc(arc.getX(), arc.getY(), arc.getWidth(), arc.getHeight(), arc.getStartAngle(), arc.getArcAngle());
    }

    public void paintOval(Graphics2D g2, Oval oval) {
        g2.setColor(oval.getShapeColor());
        g2.drawOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());

        g2.setColor(oval.getFillColor());
        g2.fillOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());
    }

    public void paintPolygon(Graphics2D g2, Polygon polygon) {
        g2.setColor(polygon.getShapeColor());
        g2.drawPolygon(polygon.getX(), polygon.getY(), polygon.getCountPoint());
        g2.setColor(polygon.getFillColor());
        g2.fillPolygon(polygon.getX(), polygon.getY(), polygon.getCountPoint());
    }

    public void paintPolyline(Graphics2D g2, Polyline polyline) {
        g2.setColor(polyline.getFillColor());
        g2.drawPolyline(polyline.getX(), polyline.getY(), polyline.getCountPoint());
    }

}
