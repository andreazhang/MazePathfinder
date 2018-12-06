package com.mapper;

import com.MazeDetails;
import com.reader.FileReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazeMapperTest {

    @Test
    public void testMapFileToObject_ReturnMazeDetails_GivenFile(){
        FileReader fileReader = new FileReader();
        List<String> file = fileReader.readFile("input.txt");
        MazeMapper mazeMapper = new MazeMapper();

        MazeDetails mazeDetails = mazeMapper.mapFileToObject(file);

        int[] expectedSize = {5, 5};
        int[] expectedStart = {1, 1};
        int[] expectedEnd = {3, 3};
        int[] expectedMaze = {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        assertArrayEquals(expectedSize, mazeDetails.getSize());
        assertArrayEquals(expectedStart, mazeDetails.getStart());
        assertArrayEquals(expectedEnd, mazeDetails.getEnd());
        assertArrayEquals(expectedMaze, mazeDetails.getMaze());
    }

    @Test
    public void testMapLineToArray_ReturnArrayOfInt_GiveString(){
        MazeMapper mazeMapper = new MazeMapper();

        int[] size = mazeMapper.mapLineToArray("5 10", 2);

        int[] expectedSize = {5, 10};
        assertArrayEquals(expectedSize, size);
    }

    @Test
    public void testConvertMazeToOneDimensionalArrayAsString_ReturnStringOfMaze_GivenMazeInList(){
        MazeMapper mazeMapper = new MazeMapper();
        List<String> mazeList = new ArrayList<>();
        mazeList.add("1 1");
        mazeList.add("0 0");

        String maze = mazeMapper.convertMazeToOneDimensionalArrayAsString(mazeList);

        String expectedMaze = "1 1 0 0";
        assertEquals(expectedMaze, maze);
    }
}