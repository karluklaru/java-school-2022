package ru.croc.task16;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        LogManager logManager = new LogManager(Path.of(args[0]));
        logManager.unionLogFile();
    }
}
