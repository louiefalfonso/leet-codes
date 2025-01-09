// Majority Element - 169

class Solution {

    public int majorityElement(int[] nums) {
        // Initialize count and candidate for majority element
        int count = 0;
        int candidate = 0;

        // Iterate over all elements in the array
        for (int num : nums) {
            // If count is zero, we choose the current element as the new candidate
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                // If the current element is the same as the candidate, increment count
                if (num == candidate) {
                    count++;
                } else {
                    // If different, decrement count
                    count--;
                }
            }
        }

        // The candidate is the majority element, which is guaranteed to exist
        return candidate;
    }
}
