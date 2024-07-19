
/*
 Two Integer Sum

Given an array of integers nums and an integer target, return the indices
i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

Input: nums = [3,4,5,6], target = 7
Output: [0,1]

Input: nums = [4,5,6], target = 10
Output: [0,2]

 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No solution found");

    }
}