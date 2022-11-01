package ru.croc.task6;

public class Annotation {
    private Figure figure;
    String description;

    public Annotation(double x0, double y0, double x1, double y1, String description) {
        figure = new Rectangle(x0, y0, x1, y1);
        this.description = description;
    }

    public Annotation(double x0, double y0, double radius, String description) {
        figure = new Circle(x0, y0, radius);
        this.description = description;
    }

    @Override
    public String toString() {
        if (figure instanceof Rectangle) {
            return "R (" + ((Rectangle) figure).getX0() + ", " + ((Rectangle) figure).getY0() + "), "
                    + "(" + ((Rectangle) figure).getX1() + ", " + ((Rectangle) figure).getY1() + "): "
                    + description;
        }
        else if (figure instanceof Circle) {
            return "R (" + ((Circle) figure).getX0() + ", " + ((Circle) figure).getY0() + "), "
                    + ((Circle) figure).getRadius() + ": " + description;
        }
        return super.toString();
    }

    public Figure getFigure() {
        return figure;
    }

    public String getDescription() {
        return description;
    }
}
