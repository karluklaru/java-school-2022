package ru.croc.task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class LogManager {
    private final Queue<LogFileReader> readers = new PriorityQueue<>(new LogComparator());

    public LogManager(Path pathToLogFiles) throws IOException {
        List<File> filesInFolder;
        try (Stream<Path> walk = Files.walk(pathToLogFiles)) {
            filesInFolder = walk.filter(Files::isRegularFile)
                    .filter(file -> file.getFileName().toString().toLowerCase().endsWith(".log")
                            || file.getFileName().toString().toLowerCase().endsWith(".trace"))
                    .map(Path::toFile).toList();
        }

        for (File file : filesInFolder) {
            readers.add(new LogFileReader(file));
        }
    }

    public void unionLogFile() throws IOException {
        while (readers.size() != 0) {
            LogFileReader first = readers.poll();
            System.out.println(first.getLine());
            if (first.readLine() != null) {
                readers.add(first);
            }
            else {
                first.getBufferedReader().close();
            }
        }

    }

}