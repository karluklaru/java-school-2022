package ru.croc.task8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int wordsInLine(String line) {
        String[] dividedBySpaces = line.split(" +");
        List<String> words = new ArrayList<>(List.of(dividedBySpaces));
        words.remove("");
        return words.size();
    }

    public static void main(String[] args) {
        String FILE_NAME = args[0];
        System.out.println(FILE_NAME);
        int countOfWords = 0;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILE_NAME), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countOfWords += wordsInLine(line);
            }
        } catch (IOException e) {
            System.out.println("Файла с таким именем не существует!");
        }

        System.out.println(countOfWords);
    }
}
