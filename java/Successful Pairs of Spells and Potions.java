/*
 * Successful Pairs of Spells and Potions - 2300
 */


 import java.util.Arrays; // Ensure to import the necessary Arrays class for sorting.

class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // Sort the potions array
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long requiredPotion = (success + spells[i] - 1) / spells[i]; // Calculate the minimum potion needed
            // Use binary search to find the first potion that is >= requiredPotion
            int index = binarySearch(potions, requiredPotion);
            // The number of successful pairs for this spell
            result[i] = potions.length - index;
        }

        return result;
    }

    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid; // Move left
            }
        }
        return left; // The index of the first potion >= target
    }
}