package ru.croc.task6;

public class Circle extends Figure implements Movable {
    private double x0, y0;
    private double radius;
    public Circle(double x0, double y0, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public boolean hasPoint(int x, int y) {
        return x0 == x && y0 == y;
    }

    @Override
    public void move(int dx, int dy) {
        x0 = x0 + dx;
        y0 = y0 + dy;
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

}
