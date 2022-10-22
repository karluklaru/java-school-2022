package ru.croc.task3;

import java.util.Scanner;

public class Task3 {

    public static int indexOfMaxElement(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexOfMinElement(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        int i;

        System.out.println("Введите элементы массива по очереди через пробел");
        input = sc.nextLine();

        String[] numbers = input.split(" ");
        int[] array = new int[numbers.length];
        for (i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        int max = array[Task3.indexOfMaxElement(array)];
        array[Task3.indexOfMaxElement(array)] = array[array.length - 1];
        array[array.length - 1] = max;

        int min = array[Task3.indexOfMinElement(array)];
        array[Task3.indexOfMinElement(array)] = array[0];
        array[0] = min;

        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
