package ru.croc.task19;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter(args[0], false)) {
            writer.write("Hello, world!\n");
            writer.flush();
        }
    }
}
