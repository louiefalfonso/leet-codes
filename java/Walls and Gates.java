// Walls and Gates - 286

import java.util.*;

class Solution {
    
     // This method fills in the distances from the gates to the empty rooms in a grid
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length; // number of rows in the grid
        int n = rooms[0].length; // number of columns in the grid

        // Create a queue to store the cells to be processed
        Deque<int[]> q = new LinkedList<>();

        // Add all the gates to the queue
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    // if the cell is a gate, add it to the queue
                    q.offer(new int[] { i, j });
                }
            }
        }

        int d = 0; // current distance from the gates

        // Define the possible directions to move in the grid
        int[] dirs = { -1, 0, 1, 0, -1 };

        // Perform BFS
        while (!q.isEmpty()) {
            ++d; // increment the distance

            // Process all the cells at the current distance
            for (int i = q.size(); i > 0; --i) {
                int[] p = q.poll(); // get the next cell from the queue

                // Explore all the neighboring cells
                for (int j = 0; j < 4; ++j) {
                    int x = p[0] + dirs[j]; // calculate the x-coordinate of the neighboring cell
                    int y = p[1] + dirs[j + 1]; // calculate the y-coordinate of the neighboring cell

                    // Check if the neighboring cell is within the grid boundaries and is an empty
                    // room
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        // if the neighboring cell is an empty room, update its distance and add it to
                        // the queue
                        rooms[x][y] = d;
                        q.offer(new int[] { x, y });
                    }
                }
            }
        }
    }
}