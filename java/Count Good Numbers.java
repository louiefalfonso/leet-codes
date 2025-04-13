// Count Good Numbers - 1922

class Solution {
    private final int mod = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int) (gdNumbers(5, (n + 1) >> 1) * gdNumbers(4, n >> 1) % mod);
    }

    private long gdNumbers(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }
}