package ru.croc.task6;

public class Circle extends Figure {
    private double x0, y0;
    private final double radius;
    public Circle(double x0, double y0, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    @Override
    public boolean hasPoint(double x, double y) {
        double hypotenuse = Math.sqrt((x - x0)*(x - x0) + (y - y0)*(y - y0));
        return hypotenuse <= radius;
    }

    @Override
    public void move(int dx, int dy) {
        x0 += dx;
        y0 += dy;
    }

    @Override
    public String toString() {
        return "C (" + x0 + ", " + y0 + "), " + radius;
    }

}
