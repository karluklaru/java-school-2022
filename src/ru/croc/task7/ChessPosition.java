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
        return new ChessPosition(position.charAt(0) - 'a', Character.getNumericValue(position.charAt(1)) - 1);
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
        return Character.toString('a' + x) + (y + 1);
    }

    private static boolean checkKnightsMove(ChessPosition before, ChessPosition after) {
        int subtractOfX = Math.abs(before.x - after.x);
        int subtractOfY = Math.abs(before.y - after.y);
        return (subtractOfX == 1 || subtractOfX == 2) && (subtractOfY == 1 || subtractOfY == 2);
    }

}
