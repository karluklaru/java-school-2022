package ru.croc.task7;

public class Main {
    public static void main(String[] args) throws IllegalPositionException {
        String[] wrongSequence = {"g8", "e7", "e6"};
        String[] rightSequence = {"g8", "e7", "c8"};

        ChessPosition[] sequence1 = new ChessPosition[wrongSequence.length];
        ChessPosition[] sequence2 = new ChessPosition[rightSequence.length];

        for (int i = 0; i < sequence1.length; i++) {
            sequence1[i] = ChessPosition.parse(wrongSequence[i]);
            sequence2[i] = ChessPosition.parse(rightSequence[i]);
        }

        try {
            System.out.println(ChessPosition.knightMoving(sequence1));
        }
        catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ChessPosition.knightMoving(sequence2));
        }
        catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

    }
}
