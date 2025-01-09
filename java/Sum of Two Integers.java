// Sum of Two Integers - 371

class Solution {
    public int getSum(int a, int b) {
        // If there is no carry (b == 0), then we have found the sum and can return 'a'
        if (b == 0) {
            return a;
        } else {
        // If there is a carry, recursively call getSum with the following parameters:
        // 1. a XOR b - This calculates the sum without carry
        // 2. (a AND b) << 1 - This calculates the carry and shifts it one bit to the left, as carry affects the next higher bit
            return getSum(a ^ b, (a & b) << 1);
        }
    }
}