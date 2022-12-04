package ru.croc.task15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static Map<String, Integer> departments = new HashMap<>();

    public static int maxTime(List<String[]> nodes) {
        int max = 0;
        while (nodes.size() != departments.size()) {

            for (String[] current : nodes) {
                if (current[1].equals("-")) {
                    int time = Integer.parseInt(current[2]);
                    if (time > max) max = time;
                    departments.put(current[0], time);
                } else if (departments.containsKey(current[1])) {
                    int time = departments.get(current[1]) + Integer.parseInt(current[2]);
                    if (time > max) max = time;
                    departments.put(current[0], time);
                }
            }

        }
        return max;
    }

    static public List<String[]> getDepartmentNodes(String filePath) {
        List<String[]> nodes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] node = line.split(",");
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nodes;
    }

    public static void main(String[] args) {
        List<String[]> nodes = getDepartmentNodes("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task15\\departments.txt");
        int max = maxTime(nodes);
        System.out.println(max);
    }
}
