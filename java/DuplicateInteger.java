
/*
Duplicate Integer

Given an integer array nums, return true if any value appears more than once
in the array, otherwise return false.

Input: nums = [1, 2, 3, 3]
Output: true

 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}