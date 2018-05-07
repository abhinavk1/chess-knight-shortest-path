package com.algo.distancegraph;

public class Main {

    /**
     * Entry point of the application
     *
     * @param args args[0] = Length of chess board
     *             args[1] = Width of chess board
     *             args[2] = Starting X coordinate
     *             args[3] = Starting Y coordinate
     */
    public static void main(String[] args) {

        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        int startXCoord = Integer.parseInt(args[2]);
        int startYCoord = Integer.parseInt(args[3]);

        /* Input validation */
        if (rows <= 0 || cols <= 0) {
            System.err.println("Invalid matrix dimensions entered");
            return;
        }

        /* Input validation */
        if (startXCoord < 0 || startYCoord < 0 ||
                startXCoord >= cols || startYCoord >= rows) {
            System.err.println("Invalid start coordinates entered");
            return;
        }
        ChessBoard board = new ChessBoard(cols, rows);

        /* Print the distance graph given the starting coordinates */
        board.generateDistanceGraph(startXCoord, startYCoord);
    }
}
