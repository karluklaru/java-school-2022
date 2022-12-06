package ru.croc.task15;

import java.util.List;

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

    public static int contains(List<Department> departments, String name) {
        int i = 0;
        for (Department department : departments) {
            if (department.name.equals(name)) {
                return i;
            }
            ++i;
        }
        return -1;
    }
}
