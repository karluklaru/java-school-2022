package ru.croc.task6;

public class Rectangle extends Figure implements Movable{
    private double x0, y0;
    private double x1, y1;

    public Rectangle(double x0, double y0,
                     double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public boolean hasPoint(double x, double y) {
        return (getX0() == x && getY0() == y) || (getX1() == x && getY1() == y);
    }

    @Override
    public void move(int dx, int dy) {
        x0 = x0 + dx;
        y0 = y0 + dy;
        x1 = x1 + dx;
        y1 = y1 + dy;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }
}
