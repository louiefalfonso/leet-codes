// Find the K-th Character in String Game I - 3304

import java.util.ArrayList;
import java.util.List;

class Solution {
    public char kthCharacter(int k) {
        List<Integer> word = new ArrayList<>();
        word.add(0);
        while (word.size() < k) {
            for (int i = 0, m = word.size(); i < m; ++i) {
                word.add((word.get(i) + 1) % 26);
            }
        }
        return (char) ('a' + word.get(k - 1));
    }
}