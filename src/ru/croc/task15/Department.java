package ru.croc.task15;

public class Department {
    private final String name;
    private final int processTime;

    public Department(String name, int processTime) {
        this.name = name;
        this.processTime = processTime;
    }

    public int getProcessTime() {
        return processTime;
    }


}
