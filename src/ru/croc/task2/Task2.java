package ru.croc.task2;

import java.util.Scanner;

public class Task2 {

    public static void printBytes(double bytes) {
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        System.out.println(bytes);
        for (String unit : units) {
            System.out.println(bytes);
            if (bytes < 1024) {
                System.out.println(String.format("%.1f", bytes) + " " + unit);
                bytes = 0;
                break;
            }
            bytes /= 1024;
        }
        if (bytes != 0) {
            System.out.println("Давай число поменьше");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Введите количество байт:");
        double bytes;
        while (true) {
            input = sc.nextLine();
            try {
                bytes = Double.parseDouble(input);
                break;
            }
            catch (Exception e) {
                System.out.println("Введите число типа Double");
            }
        }
        Task2.printBytes(bytes);
    }
}
