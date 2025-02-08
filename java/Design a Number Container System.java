// Design a Number Container System - 2349

import java.util.*;


 // Design a Number Container System.
 // This class provides methods to change the number at a given index and find the smallest index that contains a given number.
class NumberContainers {
    // Map to store the number at each index
    private Map<Integer, Integer> d = new HashMap<>();

    // Map to store the indices of each number in a sorted order
    private Map<Integer, TreeSet<Integer>> g = new HashMap<>();

    /**
     * Initializes the Number Container System.
     */
    public NumberContainers() {
    }

    
     // Changes the number at the given index.
     
     // @param index  the index to change
     // @param number the new number
    public void change(int index, int number) {
        // If the index already contains a number, remove it from the sorted set
        if (d.containsKey(index)) {
            int oldNumber = d.get(index);
            g.get(oldNumber).remove(index);
        }
        // Update the number at the index
        d.put(index, number);
        // Add the index to the sorted set of the new number
        g.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    
     // Finds the smallest index that contains the given number.
     // @param number the number to find
     // @return the smallest index that contains the number, or -1 if not found
    public int find(int number) {
        // Get the sorted set of indices for the given number
        var ids = g.get(number);
        // Return the smallest index, or -1 if not found
        return ids == null || ids.isEmpty() ? -1 : ids.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */