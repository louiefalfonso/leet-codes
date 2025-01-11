// Jump Game II - 45

class Solution {
    public int jump(int[] nums) {
        int steps = 0; // Initialize a step counter to keep track of the number of jumps made
        int maxReach = 0; // Initialize the maximum reach from the current position
        int lastJumpMaxReach = 0; // Initialize the maximum reach of the last jump

        // Iterate through the array except for the last element,
        // because we want to reach the last index, not jump beyond it
        for (int i = 0; i < nums.length - 1; ++i) {
            // Update the maximum reach by taking the maximum between the current maxReach
            // and the position we could reach from the current index (i + nums[i])
            maxReach = Math.max(maxReach, i + nums[i]);

            // If the current index reaches the last jump's maximum reach,
            // it means we have to make another jump to proceed further
            if (lastJumpMaxReach == i) {
                steps++; // Increment the step counter because we're making another jump

                lastJumpMaxReach = maxReach; // Update the last jump's max reach to the current maxReach

                // There's no need to continue if the maximum reach is already beyond the last
                // index,
                // as we are guaranteed to end the loop
                if (maxReach >= nums.length - 1) {
                    break;
                }
            }
        }

        // Return the minimum number of jumps needed to reach the last index
        return steps;
    }
}