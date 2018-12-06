package com.printer;

import com.MazeDetails;
import com.Pathfinder;
import com.mapper.MazeMapper;
import com.reader.FileReader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazePrinterTest {

    private MazePrinter mazePrinter;

    @Before
    public void setUp(){
        mazePrinter = new MazePrinter();
    }

    @Test
    public void testPrintMaze_PrintsMazeOnConsole(){
        FileReader fileReader = new FileReader();
        List<String> file = fileReader.readFile("input.txt");
        MazeMapper mazeMapper = new MazeMapper();
        MazeDetails mazeDetails = mazeMapper.mapFileToObject(file);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);
        List<Integer> path = pathfinder.findPath();

        mazePrinter.printMaze(mazeDetails, path);
    }

    @Test
    public void testUpdateMazeCellWall_ReturnPrintableMaze_GivenInitialMaze(){
        int[] initialMaze = {1, 1, 0, 0};

        char[] printableMaze = mazePrinter.updateMazeCellWall(initialMaze);

        char[] expectedMaze = {'#', '#', ' ', ' '};
        assertArrayEquals(expectedMaze, printableMaze);
    }

    @Test
    public void testUpdateMazePosition_ReturnPrintableMazeWithUpdatedPosition_GivenMazeWithUpdatedWall(){
        char[] initialMaze = {'#', '#', ' ', ' '};

        char[] printableMaze = mazePrinter.updateMazePosition(initialMaze, 2, 'S');

        char[] expectedMaze = {'#', '#', 'S', ' '};
        assertArrayEquals(expectedMaze, printableMaze);
    }

    @Test
    public void testUpdateMazePosition_ReturnPrintableMazeWithUpdatedPath_GivenMazeWithUpdatedPosition(){
        char[] initialMaze = {'#', '#', 'S', ' '};
        List<Integer> path = new ArrayList<>();
        path.add(3);

        char[] printableMaze = mazePrinter.updateMazePath(initialMaze, path);

        char[] expectedMaze = {'#', '#', 'S', 'X'};
        assertArrayEquals(expectedMaze, printableMaze);
    }

}