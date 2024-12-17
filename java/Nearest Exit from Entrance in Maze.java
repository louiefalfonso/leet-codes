/*
 * Nearest Exit from Entrance in Maze - 1926
 */

 import java.util.*;
 
 class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // Maze dimensions
        int rowCount = maze.length;
        int colCount = maze[0].length;

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        // Mark the entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        // Step count for nearest exit
        int steps = 0;

        // Directions for exploring neighbors (up, right, down, left)
        int[] directions = { -1, 0, 1, 0, -1 };

        // Begin BFS
        while (!queue.isEmpty()) {
            steps++; // Increment steps at each level

            for (int count = queue.size(); count > 0; count--) {
                int[] currentPos = queue.poll(); // Poll the current position from the queue

                // Iterate through all possible directions
                for (int l = 0; l < 4; l++) {
                    int nextRow = currentPos[0] + directions[l];
                    int nextCol = currentPos[1] + directions[l + 1];

                    // Check if the next position is within bounds and not a wall
                    if (nextRow >= 0 && nextRow < rowCount && nextCol >= 0 && nextCol < colCount
                            && maze[nextRow][nextCol] == '.') {
                        // Check if the next position is at the border, thus an exit
                        if (nextRow == 0 || nextRow == rowCount - 1 || nextCol == 0 || nextCol == colCount - 1) {
                            return steps; // Return the number of steps to reach this exit
                        }
                        // Mark the position as visited
                        queue.offer(new int[] { nextRow, nextCol });
                        maze[nextRow][nextCol] = '+';
                    }
                }
            }
        }
        // If no exit was found, return -1
        return -1;
    }
}