/*
 * Koko Eating Bananas - 875
 */

 class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize the lower bound of the eating speed, cannot be less than 1.
        int minSpeed = 1;
        // Initialize the upper bound of the eating speed to a high number, (int) 1e9 is
        // used as an approximation.
        int maxSpeed = (int) 1e9;

        // Binary search to find the minimum eating speed.
        while (minSpeed < maxSpeed) {
            // Find the mid point which is the candidate for our potential eating speed.
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;

            // Initialize the total hours needed with the chosen speed.
            int totalHours = 0;

            // Calculate the total hours needed to eat the piles at midSpeed.
            for (int bananas : piles) {
                // The time to eat a pile is the pile size divided by eating speed, rounded up.
                totalHours += (bananas + midSpeed - 1) / midSpeed;
            }

            // If the total hours with midSpeed is less or equal to h, we might be able to
            // do better,
            // so we bring down the maximum speed to midSpeed.
            if (totalHours <= h) {
                maxSpeed = midSpeed;
            } else {
                // Otherwise, if we need more than 'h' hours, the speed is too slow.
                // We need to increase our eating speed, so we update minSpeed to midSpeed + 1.
                minSpeed = midSpeed + 1;
            }
        }

        // Loop finishes when minSpeed == maxSpeed, which is the minimum speed to eat
        // all bananas in 'h' hours.
        return minSpeed;
    }

}