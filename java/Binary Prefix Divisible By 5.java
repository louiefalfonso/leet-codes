// Binary Prefix Divisible By 5 - 1018

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int x = 0;
        for (int v : nums) {
            x = (x << 1 | v) % 5;
            ans.add(x == 0);
        }
        return ans;
    }
}