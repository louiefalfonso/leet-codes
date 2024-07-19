/*
Top K Elements in List

Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.


Input: nums = [1,2,2,3,3,3], k = 2
Output: [2,3]

Input: nums = [7,7], k = 1
Output: [7]

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(count.entrySet());

        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = queue.poll().getKey();
        }

        return top;
    }
}
