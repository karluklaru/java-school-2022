package ru.croc.task7;

public class IllegalPositionException extends Exception {

    @Override
    public String getMessage() {
        return "Positions must be between 0 and 7";
    }
}
