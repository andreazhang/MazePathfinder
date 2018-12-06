package com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PathfinderTest {
    
    @Test
    public void testIsNorthTraversable_ReturnTrue_GivenTraversablePath(){
        int[] size = {2, 2};
        int[] start = {0, 1};
        int[] end = {0, 0};
        int[] maze = {0, 1, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isNorthTraversable = pathfinder.isNorthTraversable();

        assertTrue(isNorthTraversable);
    }

    @Test
    public void testIsNorthTraversable_ReturnFalse_GivenWallOnPath(){
        int[] size = {2, 2};
        int[] start = {0, 1};
        int[] end = {0, 0};
        int[] maze = {1, 1, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isNorthTraversable = pathfinder.isNorthTraversable();

        assertFalse(isNorthTraversable);
    }

    @Test
    public void testIsSouthTraversable_ReturnTrue_GivenTraversablePath(){
        int[] size = {2, 2};
        int[] start = {0, 0};
        int[] end = {0, 0};
        int[] maze = {0, 1, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isSouthTraversable = pathfinder.isSouthTraversable();

        assertTrue(isSouthTraversable);
    }

    @Test
    public void testIsSouthTraversable_ReturnFalse_GivenWallOnPath(){
        int[] size = {2, 2};
        int[] start = {0, 0};
        int[] end = {0, 0};
        int[] maze = {0, 1, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isSouthTraversable = pathfinder.isSouthTraversable();

        assertFalse(isSouthTraversable);
    }

    @Test
    public void testIsEastTraversable_ReturnTrue_GivenTraversablePath(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {0, 0};
        int[] maze = {0, 0, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isEastTraversable = pathfinder.isEastTraversable();

        assertTrue(isEastTraversable);
    }

    @Test
    public void testIsEastTraversable_ReturnFalse_GivenWallOnPath(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {0, 0};
        int[] maze = {1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isEastTraversable = pathfinder.isEastTraversable();

        assertFalse(isEastTraversable);
    }

    @Test
    public void testIsWestTraversable_ReturnTrue_GivenTraversablePath(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {0, 0};
        int[] maze = {0, 0, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isWestTraversable = pathfinder.isWestTraversable();

        assertTrue(isWestTraversable);
    }

    @Test
    public void testIsWestTraversable_ReturnFalse_GivenWallOnPath(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {0, 0};
        int[] maze = {1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isWestTraversable = pathfinder.isWestTraversable();

        assertFalse(isWestTraversable);
    }

    @Test
    public void testReachedEndCell_ReturnTrue_GivenPlayerOnEndCell(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {1, 0};
        int[] maze = {1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        boolean isPlayerOnEndCell = pathfinder.reachedEndCell();

        assertTrue(isPlayerOnEndCell);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenEndOnNorth(){
        int[] size = {2, 2};
        int[] start = {0, 1};
        int[] end = {0, 0};
        int[] maze = {0, 1, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(2);
        expectedPath.add(0);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenEndOnSouth(){
        int[] size = {2, 2};
        int[] start = {0, 0};
        int[] end = {0, 1};
        int[] maze = {0, 1, 0, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(0);
        expectedPath.add(2);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenEndOnEast(){
        int[] size = {2, 2};
        int[] start = {0, 0};
        int[] end = {1, 0};
        int[] maze = {0, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(0);
        expectedPath.add(1);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenEndOnWest(){
        int[] size = {2, 2};
        int[] start = {1, 0};
        int[] end = {0, 0};
        int[] maze = {0, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(0);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenSimplePathNorth(){
        int[] size = {3, 3};
        int[] start = {0, 2};
        int[] end = {0, 0};
        int[] maze = {0, 1, 1, 0, 1, 1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(6);
        expectedPath.add(3);
        expectedPath.add(0);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenSimplePathSouth(){
        int[] size = {3, 3};
        int[] start = {0, 0};
        int[] end = {0, 2};
        int[] maze = {0, 1, 1, 0, 1, 1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(0);
        expectedPath.add(3);
        expectedPath.add(6);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenSimplePathEast(){
        int[] size = {3, 3};
        int[] start = {0, 0};
        int[] end = {2, 0};
        int[] maze = {0, 0, 0, 1, 1, 1, 1, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(0);
        expectedPath.add(1);
        expectedPath.add(2);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenSimplePathWest(){
        int[] size = {3, 3};
        int[] start = {2, 0};
        int[] end = {0, 0};
        int[] maze = {0, 0, 0, 1, 1, 1, 1, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(2);
        expectedPath.add(1);
        expectedPath.add(0);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenLPathNorth(){
        int[] size = {3, 3};
        int[] start = {0, 2};
        int[] end = {1, 0};
        int[] maze = {0, 0, 1, 0, 1, 1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(6);
        expectedPath.add(3);
        expectedPath.add(0);
        expectedPath.add(1);
        assertEquals(expectedPath, path);
    }

    @Test
    public void testFindPath_ReturnPathAsArray_GivenBacktrackPath(){
        int[] size = {3, 3};
        int[] start = {0, 1};
        int[] end = {0, 2};
        int[] maze = {0, 1, 1, 0, 1, 1, 0, 1, 1};
        MazeDetails mazeDetails = new MazeDetails(size, start, end, maze);
        Pathfinder pathfinder = new Pathfinder(mazeDetails);

        List<Integer> path = pathfinder.findPath();

        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(3);
        expectedPath.add(6);
        assertEquals(expectedPath, path);
    }
}