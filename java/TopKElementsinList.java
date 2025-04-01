
// Top K Elements in List - 347


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
