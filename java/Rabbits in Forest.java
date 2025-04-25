// Rabbits in Forest - 781

import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int x : answers) {
            count.merge(x, 1, Integer::sum);
        }
        int answer = 0;
        for (var e : count.entrySet()) {
            int group = e.getKey() + 1;
            answer += (e.getValue() + group - 1) / group * group;
        }
        return answer;
    }
}