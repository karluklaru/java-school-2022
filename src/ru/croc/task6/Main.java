package ru.croc.task6;

public class Main {

    public static void main(String[] args) {
        Annotation annotation1 = new Annotation(1, 2, 4, 5, "Rectangle");
        Annotation annotation2 = new Annotation(0, 0, 2, "Circle");
        System.out.println(annotation1);
        System.out.println(annotation2);

        AnnotatedImage annotatedImage = new AnnotatedImage("", annotation1, annotation2);
        System.out.println(annotatedImage.findByPoint(1, 1));
        System.out.println(annotatedImage.findByPoint(10, 10));
        System.out.println(annotatedImage.findByLabel("tan"));
    }

}
