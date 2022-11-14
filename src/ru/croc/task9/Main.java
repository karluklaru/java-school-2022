package ru.croc.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static String toNormalizePath(String originalPath) {
        List<String> folders = createArrayOfFolders(originalPath);

        int i = 0;
        if (Objects.equals(folders.get(0), "..")) ++i;
        while (true) {
            if (Objects.equals(folders.get(i), ".")) {
                folders.remove(i);
            }
            else if (Objects.equals(folders.get(i), "..")) {
                if (i > 0 && !Objects.equals(folders.get(i - 1), "..")) {
                    folders.remove(i);
                    folders.remove(i - 1);
                    --i;
                }
                else break;
            }
            else if (i == folders.size() - 1) break;
            else ++i;
        }

        return createPathFromArray(folders);
    }

    private static List<String> createArrayOfFolders(String path) {
        String[] dividedBySlashes = path.split("/");
        return new ArrayList<>(List.of(dividedBySlashes));
    }

    private static String createPathFromArray(List<String> folders) {
        return String.join("/", folders);
    }

    public static void main(String[] args) {
        String path = "../КРОК/работа/src/./../../универ/мемы/котики";
        String normalizePath = toNormalizePath(path);
        System.out.println(normalizePath);
    }
}
