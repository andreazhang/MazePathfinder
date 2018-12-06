package com;

import com.mapper.MazeMapper;
import com.reader.FileReader;
import com.printer.MazePrinter;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        App app = new App();
        System.out.println("Input maze:");
        app.solveMaze("input.txt");

        System.out.println();
        System.out.println("Small maze:");
        app.solveMaze("small.txt");

        System.out.println();
        System.out.println("Sparse medium maze:");
        app.solveMaze("sparse_medium.txt");

        System.out.println();
        System.out.println("Medium maze:");
        app.solveMaze("Medium_input.txt");

        System.out.println();
        System.out.println("Large maze:");
        app.solveMaze("large_input.txt");
    }

    private void solveMaze(String filePath){
        FileReader fileReader = new FileReader();
        List<String> file = fileReader.readFile(filePath);

        MazeMapper mazeMapper = new MazeMapper();
        MazeDetails mazeDetails = mazeMapper.mapFileToObject(file);

        Pathfinder pathfinder = new Pathfinder(mazeDetails);
        List<Integer> path = pathfinder.findPath();

        if(path.size() == 0){
            System.out.println("There is no solution for the given maze");
        }else{
            MazePrinter mazePrinter = new MazePrinter();
            mazePrinter.printMaze(mazeDetails, path);
        }
    }
}
