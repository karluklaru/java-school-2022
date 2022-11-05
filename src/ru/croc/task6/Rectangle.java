package ru.croc.task6;

public class Rectangle extends Figure {
    private double x0, y0;
    private double x1, y1;

    public Rectangle(double x0, double y0,
                     double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public boolean hasPoint(double x, double y) {
        return x >= x0 && x <= x1 && y >= y0 && y <= y1;
    }

    @Override
    public void move(int dx, int dy) {
        x0 += dx;
        y0 += dy;
        x1 += dx;
        y1 += dy;
    }

    @Override
    public String toString() {
        return "R (" + x0 + ", " + y0 + "), " + "(" + x1 + ", " + y1 + ")";
    }
}
