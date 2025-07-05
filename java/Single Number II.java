// Single Number II - 137

class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += num >> i & 1;
            }
            count %= 3;
            answer |= count << i;
        }
        return answer;
    }
}