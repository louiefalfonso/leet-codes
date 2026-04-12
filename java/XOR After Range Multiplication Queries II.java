// XOR After Range Multiplication Queries II - 3655

class Solution {
    class FenwickTree {
        int[] tree;
        int n;
        
        FenwickTree(int size) {
            n = size;
            tree = new int[n + 1];
        }
        
        void update(int idx, int val) {
            idx++; 
            while (idx <= n) {
                tree[idx] ^= val;
                idx += idx & -idx;
            }
        }
        
        int query(int idx) {
            idx++;
            int res = 0;
            while (idx > 0) {
                res ^= tree[idx];
                idx -= idx & -idx;
            }
            return res;
        }
        
        int queryRange(int left, int right) {
            return query(right) ^ query(left - 1);
        }
    }
    
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        FenwickTree ft = new FenwickTree(n);
        
        for (int i = 0; i < n; i++) {
            ft.update(i, nums[i]);
        }
        
        int result = 0;
        
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int value = query[2];
            
            int currentXor = ft.queryRange(left, right);
            result ^= currentXor;
            
            
            for (int i = left; i <= right; i++) {
                ft.update(i, nums[i]);
                nums[i] *= value;
                ft.update(i, nums[i]);
            }
        }
        
        return result;
    }
}



    