package ru.croc.task7;

public class ChessPosition {
    private final int x;
    private final int y;

    public ChessPosition(int x, int y) throws IllegalPositionException {
        if ((x < 0 || x > 7) && (y < 0 || y > 7)) {
            throw new IllegalPositionException();
        }
        this.x = x;
        this.y = y;
    }

    public static ChessPosition parse(String position) throws IllegalPositionException {
        return new ChessPosition(letToNum(position.charAt(0)), Character.getNumericValue(position.charAt(1)) - 1);
    }

    public static String knightMoving(ChessPosition... chessPositions) throws IllegalMoveException {
        for (int i = 0; i < chessPositions.length - 1; i++) {
             if (!checkKnightsMove(chessPositions[i], chessPositions[i + 1])) {
                 throw new IllegalMoveException(chessPositions[i].toString(), chessPositions[i + 1].toString());
             }
        }
        return "OK";
    }

    @Override
    public String toString() {
        try {
            return numToLet(x) + (y + 1);
        } catch (IllegalPositionException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkKnightsMove(ChessPosition before, ChessPosition after) {
        int subtractOfX = Math.abs(before.x - after.x);
        int subtractOfY = Math.abs(before.y - after.y);
        return (subtractOfX == 1 || subtractOfX == 2) && (subtractOfY == 1 || subtractOfY == 2);
    }

    private String numToLet(int num) throws IllegalPositionException {
        return switch (num) {
            case 0 -> "a";
            case 1 -> "b";
            case 2 -> "c";
            case 3 -> "d";
            case 4 -> "e";
            case 5 -> "f";
            case 6 -> "g";
            case 7 -> "h";
            default -> throw new IllegalPositionException();
        };
    }

    private static int letToNum(char let) throws IllegalPositionException {
        return switch (let) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> throw new IllegalPositionException();
        };
    }

}
