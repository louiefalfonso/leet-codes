// Total Characters in String After Transformations I - 3335

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int modulo = (int) 1e9 + 7;
        int[][] f = new int[t + 1][26];
        for (char c : s.toCharArray()) {
            f[0][c - 'a']++;
        }
        for (int i = 1; i <= t; ++i) {
            f[i][0] = f[i - 1][25] % modulo;
            f[i][1] = (f[i - 1][0] + f[i - 1][25]) % modulo;
            for (int j = 2; j < 26; j++) {
                f[i][j] = f[i - 1][j - 1] % modulo;
            }
        }

        int answer = 0;
        for (int j = 0; j < 26; ++j) {
            answer = (answer + f[t][j]) % modulo;
        }
        return answer;
    }
}