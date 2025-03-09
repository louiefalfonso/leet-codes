// Minimum Recolors to Get K Consecutive Black Blocks - 2379
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') count++;
        }
        int min = count;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') count++;
            if (blocks.charAt(i - k) == 'W') count--;
            min = Math.min(min, count);
        }
        return min;
    }
}