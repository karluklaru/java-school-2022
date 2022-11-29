package ru.croc.task16;

import java.util.Comparator;

public class LogComparator implements Comparator<LogFileReader> {

    @Override
    public int compare(LogFileReader o1, LogFileReader o2) {
        return Long.compare(o1.getTime(), o2.getTime());
    }
}
