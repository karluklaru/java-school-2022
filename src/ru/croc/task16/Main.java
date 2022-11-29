package ru.croc.task16;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        LogManager logManager = new LogManager(Path.of("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task16\\files"));
        logManager.unionLogFile("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task16\\result.log");
    }
}
