package logic;

import shape.*;
import shape.Polygon;
import shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.awt.Color.*;

public class Parser {
    ArrayList graphPrimitives = new ArrayList();

    ArrayList rects = new ArrayList();
    ArrayList lines = new ArrayList();
    ArrayList arcs = new ArrayList();
    ArrayList ovals = new ArrayList();
    ArrayList polygons = new ArrayList();
    ArrayList polylines = new ArrayList();

    public Parser() {
        ReadFromFile info = new ReadFromFile();
        graphPrimitives = info.getGraphPrimitives();
        sortPrimitivesByCategories();
        getRect();
    }


    private void sortPrimitivesByCategories() {
        for (int i = 0; i < graphPrimitives.size(); i++) {
            String primitives = graphPrimitives.get(i).toString();

            if (primitives.isEmpty()) continue;
            if(primitives.substring(0, 2).equals("//")) continue;

            String name = primitives.substring(0, getFirstIndexSymbol(primitives, '('));

            switch(name) {
                case "drawLine": lines.add(graphPrimitives.get(i)); break;
                case "drawRect": rects.add(graphPrimitives.get(i)); break;
                case "drawArc": arcs.add(graphPrimitives.get(i)); break;
                case "drawOval": ovals.add(graphPrimitives.get(i)); break;
                case "drawPolygon": polygons.add(graphPrimitives.get(i)); break;
                case "drawPolyline": polylines.add(graphPrimitives.get(i)); break;
                default: break;
            }
        }
    }

    private int getFirstIndexSymbol(String str, char symbol) {
        return str.indexOf(symbol);
    }

    private int getLastIndexSymbol(String str, char symbol) {
        return str.lastIndexOf(symbol);
    }

    private Color getColor(String str) {

        if(str.trim().equals("none")) return black;

        String string = str.substring(getFirstIndexSymbol(str, '(') + 1, getLastIndexSymbol(str, ')'));
        String[] c = string.split(",");

        int red = Integer.parseInt(c[0].trim());
        int green = Integer.parseInt(c[1].trim());
        int blue = Integer.parseInt(c[2].trim());

        return new Color(red, green, blue);
    }

    private int[] getPoints(String str) {
        String string = str.substring(getFirstIndexSymbol(str, '[') + 1, getLastIndexSymbol(str, ']'));
        String[] points = string.split(",");

        int[] p = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            p[i] = Integer.parseInt(points[i].trim());
        }
        return p;
    }

    private ArrayList getLine() {
        ArrayList lineList = new ArrayList();
        for (int i = 0; i < lines.size(); i++) {
            String ln = lines.get(i).toString();
            ln = ln.substring(getFirstIndexSymbol(ln, '(') + 1, getLastIndexSymbol(ln, ')'));

            String[] l = ln.split(";");

            Line line = new Line();
            line.setX1(Integer.parseInt(l[0].trim()));
            line.setY1(Integer.parseInt(l[1].trim()));

            line.setX2(Integer.parseInt(l[2].trim()));
            line.setY2(Integer.parseInt(l[3].trim()));
            line.setFillColor(getColor(l[4]));
            line.setNumLayer(Integer.parseInt(l[5].trim()));

            lineList.add(line);
        }
        return lineList;
    }

    private ArrayList getRect() {
        ArrayList rectList = new ArrayList();

        for (int i = 0; i < rects.size(); i++) {
            String rc = rects.get(i).toString();
            rc = rc.substring(getFirstIndexSymbol(rc, '(') + 1, getLastIndexSymbol(rc, ')'));

            String[] r = rc.split(";");

            Rect rect = new Rect();

            rect.setX(Integer.parseInt(r[0].trim()));
            rect.setY(Integer.parseInt(r[1].trim()));
            rect.setWidth(Integer.parseInt(r[2].trim()));
            rect.setHeight(Integer.parseInt(r[3].trim()));

            if(r[4].trim().equals("none")){
                rect.setShapeColor(getColor(r[5]));
            } else {
                rect.setShapeColor(getColor(r[4]));
            }
            rect.setFillColor(getColor(r[5]));
            rect.setNumLayer(Integer.parseInt(r[6].trim()));

            rectList.add(rect);
        }
        return rectList;
    }

    private ArrayList getArc() {
        ArrayList arcList = new ArrayList();

        for (int i = 0; i < arcs.size(); i++) {
            String arcNew = arcs.get(i).toString();
            arcNew = arcNew.substring(getFirstIndexSymbol(arcNew, '(') + 1, getLastIndexSymbol(arcNew, ')'));

            String[] ar = arcNew.split(";");

            Arc arc = new Arc();

            arc.setX(Integer.parseInt(ar[0].trim()));
            arc.setY(Integer.parseInt(ar[1].trim()));
            arc.setWidth(Integer.parseInt(ar[2].trim()));
            arc.setHeight(Integer.parseInt(ar[3].trim()));
            arc.setFillColor(getColor(ar[4]));
            arc.setStartAngle(Integer.parseInt(ar[5].trim()));
            arc.setArcAngle(Integer.parseInt(ar[6].trim()));
            arc.setNumLayer(Integer.parseInt(ar[7].trim()));

            arcList.add(arc);
        }

        return arcList;
    }

    private ArrayList getOval() {
        ArrayList ovalList = new ArrayList();

        for (int i = 0; i < ovals.size(); i++) {
            String ol = ovals.get(i).toString();
            ol = ol.substring(getFirstIndexSymbol(ol, '(') + 1, getLastIndexSymbol(ol, ')'));

            String[] ov = ol.split(";");
            Oval oval = new Oval();

            oval.setX(Integer.parseInt(ov[0].trim()));
            oval.setY(Integer.parseInt(ov[1].trim()));
            oval.setWidth(Integer.parseInt(ov[2].trim()));
            oval.setHeight(Integer.parseInt(ov[3].trim()));

            if(ov[4].trim().equals("none")){
                oval.setShapeColor(getColor(ov[5]));
            } else {
                oval.setShapeColor(getColor(ov[4]));
            }
            oval.setFillColor(getColor(ov[5]));
            oval.setNumLayer(Integer.parseInt(ov[6].trim()));

            ovalList.add(oval);
        }
        return ovalList;
    }

    private ArrayList getPolygon() {
        ArrayList polygonList = new ArrayList();

        for (int i = 0; i < polygons.size(); i++) {
            String pl = polygons.get(i).toString();
            pl = pl.substring(getFirstIndexSymbol(pl, '(') + 1, getLastIndexSymbol(pl, ')'));

            String[] pol = pl.split(";");
            shape.Polygon polygon = new Polygon();

            polygon.setX(getPoints(pol[0].trim()));
            polygon.setY(getPoints(pol[1].trim()));
            polygon.setCountPoint(Integer.parseInt(pol[2].trim()));
            if(pol[3].trim().equals("none")){
                polygon.setShapeColor(getColor(pol[4]));
            } else {
                polygon.setShapeColor(getColor(pol[3]));
            }
            polygon.setFillColor(getColor(pol[4]));
            polygon.setNumLayer(Integer.parseInt(pol[5].trim()));

            polygonList.add(polygon);
        }
        return polygonList;
    }

    private ArrayList getPolyline() {
        ArrayList polylineList = new ArrayList();

        for (int i = 0; i < polylines.size(); i++) {
            String pl = polylines.get(i).toString();
            pl = pl.substring(getFirstIndexSymbol(pl, '(') + 1, getLastIndexSymbol(pl, ')'));

            String[] pol = pl.split(";");
            Polyline polyline = new Polyline();

            polyline.setX(getPoints(pol[0].trim()));
            polyline.setY(getPoints(pol[1].trim()));
            polyline.setCountPoint(Integer.parseInt(pol[2].trim()));
            polyline.setFillColor(getColor(pol[3].trim()));
            polyline.setNumLayer(Integer.parseInt(pol[4].trim()));

            polylineList.add(polyline);

        }
        return polylineList;
    }

    public ArrayList getAllPrimitivesList() {
        ArrayList allPrimitives = new ArrayList();

        allPrimitives.addAll(getLine());
        allPrimitives.addAll(getArc());
        allPrimitives.addAll(getRect());
        allPrimitives.addAll(getOval());
        allPrimitives.addAll(getPolygon());
        allPrimitives.addAll(getPolyline());

        return sortListByNumLayer(allPrimitives);
    }

    private ArrayList sortListByNumLayer (ArrayList list) {
        Collections.sort(list, new Comparator<Shape>()  {
            @Override
            public int compare(Shape o1, Shape o2) {
                return String.valueOf(o1.getNumLayer()).compareTo((String.valueOf(o2.getNumLayer())));
            }
        });
        return list;
    }

}
