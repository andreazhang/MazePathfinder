package com.mapper;

import com.MazeDetails;

import java.util.List;

public class MazeMapper {

    public MazeDetails mapFileToObject(List<String> file) {
        MazeDetails mazeDetails = new MazeDetails();

        /*
            Legend:
            File line 0: Size (width and height)
            File line 1: Start (X and Y)
            File line 2: End (X and Y)
            File line 3: Maze first line
         */

        mazeDetails.setSize(mapLineToArray(file.get(0), 2));
        mazeDetails.setStart(mapLineToArray(file.get(1), 2));
        mazeDetails.setEnd(mapLineToArray(file.get(2), 2));

        String mazeAsString = convertMazeToOneDimensionalArrayAsString(file.subList(3, file.size()));
        mazeDetails.setMaze(mapLineToArray(mazeAsString, mazeDetails.getSize()[0] * mazeDetails.getSize()[1]));

        return mazeDetails;
    }

    public int[] mapLineToArray(String sizeAsString, int arraySize) {
        int[] size = new int[arraySize];

        String[] split = sizeAsString.split(" ");

        for (int i = 0; i < split.length; i++){
            size[i] = Integer.valueOf(split[i]);
        }

        return size;
    }

    public String convertMazeToOneDimensionalArrayAsString(List<String> mazeList) {
        StringBuilder maze = new StringBuilder();

        for (String mazeLine : mazeList) {
            maze.append(mazeLine).append(" ");
        }

        return maze.toString().trim();
    }
}
