/*
 * Keys and Rooms - 841
 */

import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private List<List<Integer>> rooms; // A list representing the keys in each room.
    private Set<Integer> visited; // A set to track visited rooms.

    // Method to check if we can visit all rooms starting from room 0.
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms; // Initialize the room list.
        visited = new HashSet<>(); // Initialize visited set.
        dfs(0); // Start depth-first search from room 0.
        // If the size of visited rooms is equal to total room count, return true.
        return visited.size() == rooms.size();
    }

    // Recursive method for depth-first search.
    private void dfs(int roomIndex) {
        // If the room has already been visited, return to avoid cycles.
        if (visited.contains(roomIndex)) {
            return;
        }
        // Mark the current room as visited.
        visited.add(roomIndex);
        // Recursively visit all rooms that can be unlocked with keys from the current
        // room.
        for (int nextRoomIndex : rooms.get(roomIndex)) {
            dfs(nextRoomIndex);
        }
    }
}