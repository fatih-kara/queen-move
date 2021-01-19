package com.istegelsin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Case2 {

    private static boolean positionRangeForQueen(int boardSize, int queenPosX, int queenPosY) {
        return (queenPosX <= boardSize &&
                queenPosX > 0 &&
                queenPosY <= boardSize &&
                queenPosY > 0);
    }

    private static Map<Coordinates, Boolean> getObstacles(int obstacleCount, int[] obstaclePosX, int[] obstaclePosY) {
        Map<Coordinates, Boolean> obstacleMap = new HashMap<>();
        int counter = 0;
        while (obstacleCount > 0 && counter < obstaclePosX.length) {
            obstacleMap.put(new Coordinates(obstaclePosX[counter], obstaclePosY[counter]), true);
            obstacleCount--;
            counter++;
        }

        return obstacleMap;
    }

    private static int getValidMovesInDirection(int boardSize, int queenPosX, int queenPosY, int stepX, int stepY, Map<Coordinates, Boolean> obstacleMap) {
        int moves = 0;

        while(positionRangeForQueen(boardSize, queenPosX, queenPosY)) {
            if(checkMap(obstacleMap, new Coordinates(queenPosX, queenPosY))) {
                return moves;
            }
            queenPosX = queenPosX + stepX;
            queenPosY = queenPosY + stepY;
            moves++;
        }
        return moves;
    }

    private static boolean checkMap(Map<Coordinates, Boolean> map, Coordinates key) {
        Boolean b = map.get(key);
        if(b != null) {
            return b;
        }
        return false;
    }

    public static int calculateQueenMoves(int boardSize, int queenPosX, int queenPosY, int obstacleCount, int[] obstaclePosX, int[] obstaclePosY ) {
        int totalMoves = 0;
        Map<Coordinates, Boolean> obstacleMap = getObstacles(obstacleCount, obstaclePosX, obstaclePosY);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY, 1, 0, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY-1,1,-1, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX, queenPosY-1,0,-1, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY-1,-1,-1, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY,-1,0, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX-1, queenPosY+1,-1,+1, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX, queenPosY+1,0,1, obstacleMap);
        totalMoves += getValidMovesInDirection(boardSize, queenPosX+1, queenPosY+1,1,1, obstacleMap);

        return totalMoves;
    }

    static class Coordinates {
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int boardSize = 5;
        int queenPosX = 4;
        int queenPosY = 3;
        int obstacleCount = 3;
        int[] obstaclePosX = {4,2,5};
        int[] obstaclePosY = {2,3,5};

        System.out.println(calculateQueenMoves(boardSize, queenPosX, queenPosY, obstacleCount, obstaclePosX, obstaclePosY));
    }
}
