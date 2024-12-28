/*
 * Single Number - 136
 */

 class Solution {
    // Function to find the single number in an array where every element appears
    // twice except for one
    public int singleNumber(int[] nums) {
        // Initialize the variable 'answer' with 0
        int answer = 0;

        // Loop over each value in the array 'nums'
        for (int value : nums) {
            // Apply XOR operation between the 'answer' and the 'value'
            // Since XOR of a number with itself is 0 and with 0 is the number itself,
            // this will cancel out all pairs leaving the single number alone
            answer ^= value;
        }

        // Return the single number that doesn’t have a pair
        return answer;
    }
}