/*
 3Sum
 
 Given an integer array nums, return all the triplets [nums[i], nums[j],
 nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
 
 The output should not contain any duplicate triplets. You may return the
 output and the triplets in any order.

 Example 1:
 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]
 
 Example 2:
 Input: nums = [0,1,1]
 Output: []
 
 Example 3:
 Input: nums = [0,0,0]
 Output: [[0,0,0]]
 */

 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

 class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip the same element to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left and right pointers to skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase the sum by moving the left pointer to the right
                } else {
                    right--; // Decrease the sum by moving the right pointer to the left
                }
            }
        }

        return result;
    }
}
