// Finding 3-Digit Even Numbers  - 2094
import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];

        for (int x : digits) {
            ++count[x];
        }
        List<Integer> answer = new ArrayList<>();

        for (int x = 100; x < 1000; x += 2) {
            int[] count1 = new int[10];
            for (int y = x; y > 0; y /= 10) {
                ++count1[y % 10];
            }
            boolean ok = true;
            for (int i = 0; i < 10 && ok; ++i) {
                ok = count[i] >= count1[i];
            }
            if (ok) {
                answer.add(x);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}