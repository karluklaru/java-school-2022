package ru.croc.task5;

public class Annotation {
    private final Figure figure;
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
        return figure + ": " + description;
    }
}
