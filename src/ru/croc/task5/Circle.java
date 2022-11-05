package ru.croc.task5;

public class Circle extends Figure {
    private final double x0;
    private final double y0;
    private final double radius;
    public Circle(double x0, double y0, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "C (" + x0 + ", " + y0 + "), " + radius;
    }
}
