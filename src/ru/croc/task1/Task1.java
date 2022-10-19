package ru.croc.task1;

import java.util.Scanner;

public class Task1 {

    public static double inputCoordinate(Scanner sc) {
        String input;
        double c;
        while (true) {
            input = sc.nextLine();
            try {
                c = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] x = new double[3];
        double[] y = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите координату x " + (i + 1) + "-й вершины: ");
            x[i] = inputCoordinate(sc);
            System.out.println("Введите координату y " + (i + 1) + "-й вершины: ");
            y[i] = inputCoordinate(sc);
        }

        double S = 1.0/2 * Math.abs((x[1] - x[0])*(y[2] - y[0]) - (x[2] - x[0])*(y[2] - y[0]));

        System.out.println("Площадь треугольника: " + S);

    }
}
