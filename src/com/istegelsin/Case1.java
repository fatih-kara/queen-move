package com.istegelsin;

public class Case1 {

    private static boolean positionRangeForQueen(int boardSize, int queenPosX, int queenPosY) {
        return (queenPosX <= boardSize &&
                queenPosX > 0 &&
                queenPosY <= boardSize &&
                queenPosY > 0);
    }

    private static int getValidMovesInDirection(int boardSize, int queenPosX, int queenPosY, int stepX, int stepY) {
        int moves = 0;

        while(positionRangeForQueen(boardSize, queenPosX, queenPosY)) {
            queenPosX = queenPosX + stepX;
            queenPosY = queenPosY + stepY;
            moves++;
        }
        return moves;
    }

    public static int calculateQueenMoves(int boardSize, int queenPosX, int queenPosY) {
        int totalMoves = 0;

        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY, 1, 0);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY-1,1,-1);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX, queenPosY-1,0,-1);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY-1,-1,-1);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY,-1,0);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY+1,-1,+1);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX, queenPosY+1,0,1);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY+1,1,1);

        return totalMoves;
    }

    public static void main(String[] args) {
        int boardSize = 8;
        int queenPosX = 4;
        int queenPosY = 4;

        System.out.println(calculateQueenMoves(boardSize, queenPosX, queenPosY));
    }
}
