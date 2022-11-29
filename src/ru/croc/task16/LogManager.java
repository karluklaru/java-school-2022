package ru.croc.task16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LogManager {
    private final Queue<LogFileReader> readers = new PriorityQueue<>(new LogComparator());

    public LogManager(Path pathToLogFiles) throws IOException {
        List<File> filesInFolder = Files.walk(pathToLogFiles)
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().endsWith(".log")
                        || file.getFileName().toString().endsWith(".trace"))
                .map(Path::toFile).toList();

        for (File file : filesInFolder) {
            readers.add(new LogFileReader(file));
        }
    }

    public void unionLogFile(String pathToResult) throws IOException {
        try (FileWriter writer = new FileWriter(pathToResult, false)) {
            while (readers.size() != 0) {
                LogFileReader first = readers.poll();
                writer.write(first.getLine() + "\n");
                if (first.readLine() != null) {
                    readers.add(first);
                }
            }
            writer.flush();
        }

    }

}