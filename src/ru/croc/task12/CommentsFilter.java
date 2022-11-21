package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class CommentsFilter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (String word : blackList) {
            comments.removeIf(comment -> comment.contains(word));
        }
    }
}
