package ru.croc.task13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RecommendAlgorithm {
    private final Integer[] userViewed;
    private final Map<Integer, String> filmDataBase;
    private final List<List<Integer>> viewedDataBase;

    public RecommendAlgorithm(String pathToFilms, String pathToViewed, String viewed) {
        userViewed = getUserFilms(viewed);
        filmDataBase = getFilmsIntoFile(pathToFilms);
        viewedDataBase = getViewedFromFile(pathToViewed);
    }

    public String getRecommendFilm() {
        Integer key = mostPopularFilm(excludeViewed(getSimilarUsers()));
        return filmDataBase.get(key);
    }

    /**
     * Метод, получающий список пользователей сервиса, предпочтения которых похожи на предпочтения
     * конкретного пользователя
     * @return список пользователей, которые просмотрели хотя бы половину данного списка
     */
    private List<List<Integer>> getSimilarUsers() {
        Set<Integer> uniqueFilms = new HashSet<>(List.of(userViewed));
        List<List<Integer>> similarUsers = new ArrayList<>();
        for (List<Integer> oneUserViewed : viewedDataBase) {
            int count = 0;
            for (Integer film : uniqueFilms) {
                if (oneUserViewed.contains(film)) {
                    ++count;
                    if (count == userViewed.length/2) {
                        similarUsers.add(oneUserViewed);
                        break;
                    }
                }
            }
        }
        return similarUsers;
    }

    /**
     * @param similarUsers пользователи, отобранные алгоритмом как "похожие по предпочтениям"
     * @return список уникальных фильмов, которые исследуемый пользователь еще не просмотрел
     */
    private Set<Integer> excludeViewed(List<List<Integer>> similarUsers) {
        Set<Integer> notViewedFilms = new HashSet<>();
        for (List<Integer> user : similarUsers) {
            List<Integer> u = new ArrayList<>(user);
            u.removeAll(List.of(userViewed));
            notViewedFilms.addAll(u);
        }
        return notViewedFilms;
    }

    /**
     * @param films список фильмов, отобранных на основе похожих пользователей и еще не просмотренных
     *              исследуемым.
     * @return ключ самого популярного по просмотрам фильма из списка среди всех пользователей сервиса
     */
    private Integer mostPopularFilm(Set<Integer> films) {
        Map<Integer, Integer> filmFrequency = getFilmFrequency(films);
        Collection<Integer> frequencies = filmFrequency.values();
        int max = Collections.max(frequencies);
        return getKey(filmFrequency, max);
    }

    /**
     * @param films список уникальных фильмов похожих пользователей, которые исследуемый еще не просмотрел
     * @return Список фильмов, где каждому индексу фильма соответствует количество его просмотров у всех
     * пользователей сервиса
     */
    private Map<Integer, Integer> getFilmFrequency(Set<Integer> films) {
        Map<Integer, Integer> filmFrequency = new HashMap<>();
        for (Integer film : films) {
            int count = 0;
            for (List<Integer> oneUserViewed : viewedDataBase) {
                count += Collections.frequency(oneUserViewed, film);
            }
            filmFrequency.put(film, count);
        }
        return filmFrequency;
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

    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry: map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
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
