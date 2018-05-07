package com.algo.distancegraph;

public class ChessSquare {

    private int xCoord;
    private int yCoord;
    private int distance;

    public ChessSquare(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public ChessSquare(int xCoord, int yCoord, int distance) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.distance = distance;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ChessSquare{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", distance=" + distance +
                '}';
    }
}
