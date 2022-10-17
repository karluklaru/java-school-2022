package ru.croc.task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Введите координату x первой вершины: ");
        double x1;
        while (true) {
            input = sc.nextLine();
            try {
                x1 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }


        System.out.println("Введите координату y первой вершины: ");
        double y1;
        while (true) {
            input = sc.nextLine();
            try {
                y1 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }

        System.out.println("Введите координату x второй вершины: ");
        double x2;
        while (true) {
            input = sc.nextLine();
            try {
                x2 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }

        System.out.println("Введите координату y второй вершины: ");
        double y2;
        while (true) {
            input = sc.nextLine();
            try {
                y2 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }

        System.out.println("Введите координату x третьей вершины: ");
        double x3;
        while (true) {
            input = sc.nextLine();
            try {
                x3 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }

        System.out.println("Введите координату y третьей вершины: ");
        double y3;
        while (true) {
            input = sc.nextLine();
            try {
                y3 = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }

        double S = 1.0/2 * Math.abs((x2 - x1)*(y3 - y1) - (x3 - x1)*(y2 - y1));

        System.out.println("Площадь треугольника: " + S);

    }
}
