// Count Largest Group - 1399

class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[40];
        int ans = 0, mx = 0;
        for (int i = 1; i <= n; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            ++count[s];
            if (mx < count[s]) {
                mx = count[s];
                ans = 1;
            } else if (mx == count[s]) {
                ++ans;
            }
        }
        return ans;
    }
}