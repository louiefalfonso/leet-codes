// Sum Root to Leaf Numbers - 129
import java.util.*;

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode node, int num_sum) {
        if (node == null) {
            return 0;
        }
        
        num_sum = num_sum * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            return num_sum;
        }
        
        return dfs(node.left, num_sum) + dfs(node.right, num_sum);
    }
}