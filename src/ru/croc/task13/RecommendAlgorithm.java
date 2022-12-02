package ru.croc.task13;

import java.util.*;

public class RecommendAlgorithm {
    private final DatabaseWorker databaseWorker;

    public RecommendAlgorithm(DatabaseWorker databaseWorker) {
        this.databaseWorker = databaseWorker;
    }

    public String getRecommendFilm() {
        List<List<Integer>> similarUsers = getSimilarUsers();
        if (similarUsers.isEmpty()) return "Нет рекомендации";
        Integer key = mostPopularFilm(excludeViewed(similarUsers));
        return databaseWorker.getFilmDataBase().get(key);
    }

    /**
     * Метод, получающий список пользователей сервиса, предпочтения которых похожи на предпочтения
     * конкретного пользователя
     * @return список пользователей, которые просмотрели хотя бы половину данного списка
     */
    private List<List<Integer>> getSimilarUsers() {
        Set<Integer> uniqueFilms = new HashSet<>(List.of(databaseWorker.getUserViewed()));
        List<List<Integer>> similarUsers = new ArrayList<>();
        for (List<Integer> oneUserViewed : databaseWorker.getViewedDataBase()) {
            int count = 0;
            for (Integer film : uniqueFilms) {
                if (oneUserViewed.contains(film)) {
                    ++count;
                    if (count >= databaseWorker.getUserViewed().length/2) {
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
            u.removeAll(List.of(databaseWorker.getUserViewed()));
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
        int max = Collections.max(filmFrequency.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return max;
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
            for (List<Integer> oneUserViewed : databaseWorker.getViewedDataBase()) {
                count += Collections.frequency(oneUserViewed, film);
            }
            filmFrequency.put(film, count);
        }
        return filmFrequency;
    }

}
