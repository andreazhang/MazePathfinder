package com;

import java.util.Arrays;

public class MazeDetails {
    private int[] size;
    private int[] start;
    private int[] end;
    private int[] maze;

    public MazeDetails(int[] size, int[] start, int[] end, int[] maze) {
        this.size = size;
        this.start = start;
        this.end = end;
        this.maze = maze;
    }

    public MazeDetails() {

    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    public int[] getStart() {
        return start;
    }

    public void setStart(int[] start) {
        this.start = start;
    }

    public int[] getEnd() {
        return end;
    }

    public void setEnd(int[] end) {
        this.end = end;
    }

    public int[] getMaze() {
        return maze;
    }

    public void setMaze(int[] maze) {
        this.maze = maze;
    }
}
