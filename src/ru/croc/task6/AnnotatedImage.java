package ru.croc.task6;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            if (annotation.getFigure() instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) annotation.getFigure();
                if (rectangle.hasPoint(x, y)) {
                    return annotation;
                }
            }
            if (annotation.getFigure() instanceof Circle) {
                Circle circle = (Circle) annotation.getFigure();
                if (circle.hasPoint(x, y)) {
                    return annotation;
                }
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.getDescription().contains(label)) {
                return annotation;
            }
        }
        return null;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

}
