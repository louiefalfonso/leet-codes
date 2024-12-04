/*
 Can Place Flowers - 605

 You have a long flowerbed in which some of the plots are planted, and some are not. 
 However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, 
and an integer n, return true if n new flowers can be planted in the flowerbed without 
violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

 */

 class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Get the length of the flowerbed array.
        int length = flowerbed.length;

        // Iterate over all spots in the flowerbed.
        for (int i = 0; i < length; ++i) {
            // Check the spot to the left, it's 0 if we're at the first spot.
            int left = i == 0 ? 0 : flowerbed[i - 1];
            // Check the spot to the right, it's 0 if we're at the last spot.
            int right = i == length - 1 ? 0 : flowerbed[i + 1];

            // If the current, left, and right spots are all empty (i.e., 0),
            // then a flower can be planted at the current position.
            if (left + flowerbed[i] + right == 0) {
                // Plant the flower at the current position.
                flowerbed[i] = 1;
                // Decrease the remaining number of flowers to plant.
                --n;
            }
        }

        // If n is less than or equal to 0, then all flowers have been successfully planted.
        return n <= 0;
    }
}