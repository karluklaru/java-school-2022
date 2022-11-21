package ru.croc.task13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RecommendAlgorithm recommendAlgorithm = new RecommendAlgorithm("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task13\\films.txt",
                "C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task13\\viewed.txt");
        System.out.println("Введите индексы просмотренных фильмов через запятую");
        String line = sc.nextLine();
        String[] films = line.split(",");
        System.out.println(recommendAlgorithm.getRecommendFilm(films));
    }
}
