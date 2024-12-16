/*
 * Number of Provinces - 547
 */


 class Solution {
    // This variable stores the connection graph.
    private int[][] connectionGraph;
    // This array keeps track of visited cities to avoid repetitive checking.
    private boolean[] visited;

    // The method finds the number of connected components (provinces or circles) in
    // the graph.
    public int findCircleNum(int[][] isConnected) {
        // Initialize the connection graph with the input isConnected matrix.
        connectionGraph = isConnected;
        // The number of cities is determined by the length of the graph.
        int numCities = connectionGraph.length;
        // Initialize the visited array for all cities, defaulted to false.
        visited = new boolean[numCities];
        // Initialize the count of provinces to zero.
        int numProvinces = 0;
        // Iterate over each city.
        for (int i = 0; i < numCities; ++i) {
            // If the city is not yet visited, it's a new province.
            if (!visited[i]) {
                // Perform a depth-first search starting from this city.
                dfs(i);
                // Increment the number of provinces upon returning from DFS.
                ++numProvinces;
            }
        }
        // Return the total number of provinces found.
        return numProvinces;
    }

    // Depth-first search recursive method that checks connectivity.
    private void dfs(int cityIndex) {
        // Mark the current city as visited.
        visited[cityIndex] = true;
        // Iterate over all possible destinations from the current city.
        for (int destination = 0; destination < connectionGraph.length; ++destination) {
            // If the destination city is not yet visited and is connected to the current
            // city,
            // perform a DFS on it.
            if (!visited[destination] && connectionGraph[cityIndex][destination] == 1) {
                dfs(destination);
            }
        }
    }
}