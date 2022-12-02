package ru.croc.task13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите индексы просмотренных фильмов через запятую");
        String line = sc.nextLine();

        DatabaseWorker databaseWorker = new DatabaseWorker("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task13\\resources\\films.txt",
                "C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task13\\resources\\viewed.txt", line);
        RecommendAlgorithm recommendAlgorithm = new RecommendAlgorithm(databaseWorker);
        System.out.println(recommendAlgorithm.getRecommendFilm());

    }
}
