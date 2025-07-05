// Find Lucky Integer in an Array - 1394

class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int x : arr) {
            ++count[x];
        }
        for (int x = count.length - 1; x > 0; --x) {
            if (x == count[x]) {
                return x;
            }
        }
        return -1;
    }
}