// Count Subarrays Where Max Element Appears at Least K Times - 2962
import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long answer = 0;
        int count = 0, j = 0;

        for (int x : nums) {
            while (j < n && count < k) {
                count += nums[j++] == maxElement ? 1 : 0;
            }
            if (count < k) {
                break;
            }
            answer += n - j + 1;
            count -= x == maxElement ? 1 : 0;
        }
        return answer;
    }
}