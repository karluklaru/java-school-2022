package ru.croc.task16;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LogFileReader {
    private final BufferedReader bufferedReader;
    private long time;
    private String line;

    public LogFileReader(File filePath) throws IOException {
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8));
        readLine();
    }

    public String readLine() throws IOException {
        line = bufferedReader.readLine();
        if (line == null) return null;
        time = Integer.parseInt(line.split(" ")[0]);
        return line;
    }

    public long getTime() {
        return time;
    }

    public String getLine() {
        return line;
    }
}
