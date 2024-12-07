/*
 Find the Highest Altitude - 1732
 */

 class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0; // Starting altitude
        int maxAltitude = 0; // To keep track of the maximum altitude

        // Iterate through the gain array
        for (int g : gain) {
            currentAltitude += g; // Update the current altitude
            maxAltitude = Math.max(maxAltitude, currentAltitude); // Update the maximum altitude
        }

        return maxAltitude; // Return the highest altitude
    }
}