package ru.croc.task7;

public class IllegalMoveException extends Exception {
    String positionBefore;
    String positionAfter;

    public IllegalMoveException(String positionBefore, String positionAfter) {
        this.positionBefore = positionBefore;
        this.positionAfter = positionAfter;
    }

    @Override
    public String getMessage() {
        return "The knight cannot make such a move: " + positionBefore + " -> " +
                positionAfter;
    }
}
