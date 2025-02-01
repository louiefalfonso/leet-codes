// Special Array I - 3151

class Solution {
    public boolean isArraySpecial(int[] nums) {

        // Check if array is empty
        for (int i = 1; i < nums.length; ++i) {
            // Check if current and previous elements have same parity
            if (nums[i] % 2 == nums[i - 1] % 2) {
                // If they have same parity, return false
                return false;
            }
        }
        // If all elements have different parity, return true
        return true;
    }
}