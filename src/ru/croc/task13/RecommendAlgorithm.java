package ru.croc.task13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RecommendAlgorithm {
    private final Map<String, String> filmDataBase;
    private final List<List<String>> viewedDataBase;

    public RecommendAlgorithm(String pathToFilms, String pathToViewed) {
        filmDataBase = getFilmsIntoFile(pathToFilms);
        viewedDataBase = getViewedFromFile(pathToViewed);
    }

    public String getRecommendFilm(String... films) {
        String key = mostPopularFilm(excludeViewed(getSimilarUsers(films), films));
        return filmDataBase.get(key);
    }

    private List<List<String>> getSimilarUsers(String... films) {
        List<List<String>> similarUsers = new ArrayList<>();
        for (List<String> oneUserViewed : viewedDataBase) {
            int count = 0;
            for (String film : films) {
                if (oneUserViewed.contains(film)) {
                    ++count;
                    if (count == films.length/2) {
                        similarUsers.add(oneUserViewed);
                        break;
                    }
                }
            }
        }
        return similarUsers;
    }

    private List<String> excludeViewed(List<List<String>> similarUsers, String... films) {
         List<String> notViewedFilms = new ArrayList<>();
        for (List<String> user : similarUsers) {
            List<String> u = new ArrayList<>(user);
            u.removeAll(List.of(films));
            notViewedFilms.addAll(u);
        }
        return notViewedFilms;
    }

    private String mostPopularFilm(List<String> films) {
        Map<String, Integer> filmFrequency = getFilmFrequency(films);
        Collection<Integer> frequencies = filmFrequency.values();
        int max = 0;
        for (Integer freq : frequencies) {
            if (freq > max) {
                max = freq;
            }
        }
        return getKey(filmFrequency, max);
    }

    private Map<String, Integer> getFilmFrequency(List<String> films) {
        Map<String, Integer> filmFrequency = new HashMap<>();
        for (String film : films) {
            Integer count = filmFrequency.get(film);
            if (count == null) {
                count = 0;
            }
            ++count;
            filmFrequency.put(film, count);
        }
        return filmFrequency;
    }

    private Map<String, String> getFilmsIntoFile(String pathToFilms) {
        Map<String, String> films = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToFilms), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] film = line.split(",");
                films.put(film[0], film[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    private List<List<String>> getViewedFromFile(String pathToViewed) {
        List<List<String>> viewed = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToViewed), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] oneUserViewed = line.split(",");
                viewed.add(List.of(oneUserViewed));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return viewed;
    }

    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry: map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
