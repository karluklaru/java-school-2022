package ru.croc.task13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DatabaseWorker {
    private final Integer[] userViewed;
    private final Map<Integer, String> filmDataBase;
    private final List<List<Integer>> viewedDataBase;

    public DatabaseWorker(String pathToFilms, String pathToViewed, String viewed) {
        userViewed = getUserFilms(viewed);
        filmDataBase = getFilmsIntoFile(pathToFilms);
        viewedDataBase = getViewedFromFile(pathToViewed);
    }

    public Integer[] getUserViewed() {
        return userViewed;
    }

    public Map<Integer, String> getFilmDataBase() {
        return filmDataBase;
    }

    public List<List<Integer>> getViewedDataBase() {
        return viewedDataBase;
    }

    private Map<Integer, String> getFilmsIntoFile(String pathToFilms) {
        Map<Integer, String> films = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToFilms), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] position = line.split(",");
                films.put(Integer.parseInt(position[0]), position[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    private List<List<Integer>> getViewedFromFile(String pathToViewed) {
        List<List<Integer>> viewed = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToViewed), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] oneUserViewed = line.split(",");
                Integer[] keys = strArrToIntegerArr(oneUserViewed);
                viewed.add(List.of(keys));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return viewed;
    }

    private Integer[] getUserFilms(String userFilms) {
        String[] divided = userFilms.split(",");
        return strArrToIntegerArr(divided);

    }

    private Integer[] strArrToIntegerArr(String... strArray) {
        int i = 0;
        Integer[] intArray = new Integer[strArray.length];
        for (String f : strArray) {
            intArray[i] = Integer.parseInt(f);
            ++i;
        }
        return intArray;
    }
}
