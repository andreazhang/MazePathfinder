Maze Pathfinder
This application take files input that contains a maze and outputs in the standard console a solution to the maze.
The input is in the format:
	- First line contains two numbers indicating the width and height of the maze
	- Second line contains two numbers indicating the starting point
	- Third line contains two numbers indicating the ending point
	- Fourth line onwards is the maze made of 1 (walls) and 0 (traversable path)

The output is a solved maze in the format:
	- '#' to represent the walls
	- 'S' to represent the starting point
	- 'E' to represent the ending point
	- 'X' to represent the solution path which can only go through traversable path
	- Empty to represent the other traversable paths