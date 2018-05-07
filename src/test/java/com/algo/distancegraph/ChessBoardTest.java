package com.algo.distancegraph;

import junit.framework.TestCase;

public class ChessBoardTest extends TestCase {

    private ChessBoard board;

    protected void setUp() {
        board = new ChessBoard(3, 4);
    }

    public void testMinMoves() {
        ChessSquare start = new ChessSquare(0, 0);
        ChessSquare end = new ChessSquare(1, 0);

        assertTrue(board.findMinimumMoves(start, end) == 3);
    }

    public void testIsValidMove() {
        assertTrue(board.isValidMove(1, 2));
        assertFalse(board.isValidMove(2, 3));
    }
}
