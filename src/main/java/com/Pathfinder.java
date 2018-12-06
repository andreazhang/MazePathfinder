package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pathfinder {
    
    private int width, height;
    private int[] start;
    private int[] end;
    private int[] maze;
    private int playerPosition;
    private List<Integer> path;
    private List<Integer> deadEnd;

    public Pathfinder(MazeDetails mazeDetails){
        width = mazeDetails.getSize()[0];
        height = mazeDetails.getSize()[1];
        start = mazeDetails.getStart().clone();
        end = mazeDetails.getEnd();
        maze = mazeDetails.getMaze();

        path = new ArrayList<>();
        deadEnd = new ArrayList<>();
    }

    public boolean isNorthTraversable() {
        boolean isNorthTraversable = false;

        playerPosition = start[0] + width * start[1];
        int northCell = playerPosition - width;

        if(northCell >= 0 && maze[northCell] != 1){
            isNorthTraversable = true;
        }

        return  isNorthTraversable;
    }

    public boolean isSouthTraversable() {
        boolean isSouthTraversable = false;

        playerPosition = start[0] + width * start[1];
        int southCell = playerPosition + width;

        if(southCell < maze.length && maze[southCell] != 1){
            isSouthTraversable = true;
        }

        return  isSouthTraversable;
    }

    public boolean isEastTraversable() {
        boolean isEastTraversable = false;

        playerPosition = start[0] + width * start[1];
        int eastCell = playerPosition + 1;

        if(eastCell < maze.length && maze[eastCell] != 1){
            isEastTraversable = true;
        }

        return  isEastTraversable;
    }

    public boolean isWestTraversable() {
        boolean isWestTraversable = false;

        playerPosition = start[0] + width * start[1];
        int westCell = playerPosition - 1;

        if(westCell >= 0 && maze[westCell] != 1){
            isWestTraversable = true;
        }

        return  isWestTraversable;
    }

    public boolean reachedEndCell() {
        boolean isPlayerOnEndCell = false;

        if(Arrays.equals(start, end)){
            isPlayerOnEndCell = true;
        }

        return isPlayerOnEndCell;
    }

    public List<Integer> findPath() {
        playerPosition = start[0] + width * start[1];
        path.add(playerPosition);

        if(reachedEndCell()){
            return path;
        }

        if(isNorthTraversable() && isNorthNewPath(playerPosition, path, deadEnd)){
            start[1] = start[1] - 1;
            findPath();
        }else if(isEastTraversable() && isEastNewPath(playerPosition, path, deadEnd)){
            start[0] = start[0] + 1;
            findPath();
        }else if(isSouthTraversable() && isSouthNewPath(playerPosition, path, deadEnd)){
            start[1] = start[1] + 1;
            findPath();
        }else if(isWestTraversable() && isWestNewPath(playerPosition, path, deadEnd)){
            start[0] = start[0] - 1;
            findPath();
        }else{
            resetPlayerPositionToLastCell(path, deadEnd, playerPosition);
            return path;
        }

        if(!reachedEndCell()){
            findPath();
        }

        return path;
    }

    private void resetPlayerPositionToLastCell(List<Integer> path, List<Integer> deadEnd, int playerPosition) {
        path.remove(path.size() - 1);
        if(path.size() == 0){
            return;
        }
        deadEnd.add(playerPosition);
        start[0] = path.get(path.size() - 1) % width;
        start[1] = path.get(path.size() - 1) / width;
        path.remove(path.size() - 1); // Prevent duplicate entry of player position
    }

    private boolean isWestNewPath(int playerPosition, List<Integer> path, List<Integer> deadEnd) {
        return !path.contains(playerPosition - 1) && !deadEnd.contains(playerPosition - 1);
    }

    private boolean isEastNewPath(int playerPosition, List<Integer> path, List<Integer> deadEnd) {
        return !path.contains(playerPosition + 1) && !deadEnd.contains(playerPosition + 1);
    }

    private boolean isSouthNewPath(int playerPosition, List<Integer> path, List<Integer> deadEnd) {
        return !path.contains(playerPosition + width) && !deadEnd.contains(playerPosition + width);
    }

    private boolean isNorthNewPath(int playerPosition, List<Integer> path, List<Integer> deadEnd) {
        return !path.contains(playerPosition - width) && !deadEnd.contains(playerPosition - width);
    }
}
