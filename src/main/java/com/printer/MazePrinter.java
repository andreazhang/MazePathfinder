package com.printer;

import com.MazeDetails;

import java.util.List;

public class MazePrinter {

    public void printMaze(MazeDetails mazeDetails, List<Integer> path) {
        int counter = 0;

        char[] printableMaze = updateMazeCellWall(mazeDetails.getMaze());

        int start = mazeDetails.getStart()[0] + mazeDetails.getStart()[1] * mazeDetails.getSize()[0];
        printableMaze = updateMazePosition(printableMaze, start, 'S');
        int end = mazeDetails.getEnd()[0] + mazeDetails.getEnd()[1] * mazeDetails.getSize()[0];
        printableMaze = updateMazePosition(printableMaze, end, 'E');

        path.remove(0);
        path.remove(path.size() - 1);
        printableMaze = updateMazePath(printableMaze, path);

        for (char cell : printableMaze) {
            counter++;

            System.out.print(cell);

            if (counter % mazeDetails.getSize()[0] == 0){
                System.out.println();
            }
        }
    }

    public char[] updateMazeCellWall(int[] initialMaze) {
        char[] printableMaze = new char[initialMaze.length];

        for (int i = 0; i < initialMaze.length; i++){
            if(initialMaze[i] == 1){
                printableMaze[i] = '#';
            }else{
                printableMaze[i] = ' ';
            }
        }

        return printableMaze;
    }

    public char[] updateMazePosition(char[] initialMaze, int position, char character) {
        initialMaze[position] = character;

        return initialMaze;
    }

    public char[] updateMazePath(char[] initialMaze, List<Integer> path) {
        for (Integer pathCell : path) {
            initialMaze[pathCell] = 'X';
        }

        return initialMaze;
    }
}
