package com.algo.distancegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChessBoard {

    private int rows;
    private int cols;

    /* Allowed knight moves represented in (x, y) coordinate form */
    private final int[][] validKnightMoves = new int[][]
            {{-1, 2}, {1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};

    /**
     * @param rows
     * @param cols
     */
    public ChessBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * This function uses breadth first search to get the minimum steps
     * that a knight will take to reach from one point to another
     *
     * @param start Starting chess square
     * @param dest  Destination chess square
     * @return Minimum steps. If knight cannot reach the destination, returns -1
     */
    protected int findMinimumMoves(ChessSquare start, ChessSquare dest) {
        int minMoves = -1;

        Queue<ChessSquare> queue = new LinkedList<ChessSquare>();
        List<ChessSquare> visitedSquares = new ArrayList<ChessSquare>();
        queue.add(start);

        while (!queue.isEmpty()) {
            ChessSquare square = queue.poll();

            /* Destination has been reached */
            if (square.getxCoord() == dest.getxCoord() &&
                    square.getyCoord() == dest.getyCoord()) {
                return square.getDistance();
            }

            /* The chess square has not been visited before */
            if (!isSquareVisited(visitedSquares, square.getxCoord(), square.getyCoord())) {

                /* Current node has now been visited */
                visitedSquares.add(square);

                for (int[] knightMove : validKnightMoves) {

                    /* Calculate new coordinates based on knight's movement */
                    int xCoord = knightMove[0] + square.getxCoord();
                    int yCoord = knightMove[1] + square.getyCoord();

                    boolean isValidMove = isValidMove(xCoord, yCoord);
                    if (isValidMove) {

                        ChessSquare newSquare = new ChessSquare(xCoord,
                                yCoord, square.getDistance() + 1);
                        queue.add(newSquare);
                    }
                }
            }
        }

        return minMoves;
    }

    /**
     * For checking if the move is within the chess board range
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @return True if within range, false otherwise
     */
    protected boolean isValidMove(int x, int y) {
        return (x >= 0 && x < cols && y >= 0 && y < rows);
    }


    /**
     * Outputs the distance graph given the starting coordinates
     *
     * @param startXCoord Starting X coordinate
     * @param startYCoord Starting Y coordinate
     */
    public void generateDistanceGraph(int startXCoord, int startYCoord) {
        ChessSquare startingSquare = new ChessSquare(startXCoord, startYCoord);
        ChessSquare endingSquare;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {

                endingSquare = new ChessSquare(x, y);
                System.out.print(findMinimumMoves(startingSquare, endingSquare)
                        + " ");
            }
            System.out.println("\n");
        }
    }

    private boolean isSquareVisited(List<ChessSquare> visitedSquares, int x, int y) {
        boolean visited = false;

        for (ChessSquare square : visitedSquares) {
            if (square.getxCoord() == x && square.getyCoord() == y) {
                visited = true;
                break;
            }
        }
        return visited;
    }
}
