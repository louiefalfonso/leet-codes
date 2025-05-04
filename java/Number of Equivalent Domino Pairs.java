// Number of Equivalent Domino Pairs - 1128

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int answer = 0;
        for (var e : dominoes) {
            int x = e[0] < e[1] ? e[0] * 10 + e[1] : e[1] * 10 + e[0];
            answer += count[x]++;
        }
        return answer;
    }
}