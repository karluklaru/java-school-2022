package ru.croc.task5;

public class Rectangle extends Figure {
    private final double x0;
    private final double y0;
    private final double x1;
    private final double y1;

    public Rectangle(double x0, double y0,
                     double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public String toString() {
        return "R (" + x0 + ", " + y0 + "), " + "(" + x1 + ", " + y1 + ")";
    }
}
