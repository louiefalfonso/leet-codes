/*
 * Smallest Number in Infinite Set -2336
 */

 import java.util.Set;
import java.util.HashSet;

class SmallestInfiniteSet {
    // A HashSet to store numbers that have been popped.
    private Set<Integer> poppedNumbers = new HashSet<>();

    // Constructor
    public SmallestInfiniteSet() {
        // Nothing to initialize since HashSet is already initialized.
    }

    // Method to pop the smallest number that has not been popped yet.
    public int popSmallest() {
        // Starting from 1, as it's the smallest positive integer.
        int smallest = 1;
        // Loop over the set to find the smallest non-popped number (the ones not in
        // poppedNumbers).
        while (poppedNumbers.contains(smallest)) {
            // If current number is in the set, increase it to check the next one.
            smallest++;
        }
        // Once the smallest number is found, add it to the set to indicate it has been
        // popped.
        poppedNumbers.add(smallest);
        // Return the smallest number that hasn't been popped before.
        return smallest;
    }

    // Method to add back a number to the set of available numbers.
    public void addBack(int num) {
        // Remove the specified number from the set of popped numbers.
        poppedNumbers.remove(num);
    }
}