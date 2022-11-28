package ru.croc.task14;

import java.util.*;
import java.util.function.Predicate;

public interface BlackListFilter {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  any collection of comments; every comment
     *                  can be represented by an object of any
     *                  class that defines a predicate
     * @param filter condition for filtering comment objects
     */
    default <T> List<T> filterComments(Collection<T> comments, Predicate<T> filter) {
        List<T> filteringComments = new LinkedList<>(comments);
        filteringComments.removeIf(filter);
        return filteringComments;
    }
}

