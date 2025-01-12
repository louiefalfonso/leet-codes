// H-Index - 274

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        // Sorting an int[] in reverse in Java is annoying
        // We first sort normally then reverse the array
        Arrays.sort(citations);
        for (int i = 0; i < citations.length / 2; i++) {
            int tmp = citations[i];
            citations[i] = citations[citations.length - 1 - i];
            citations[citations.length - 1 - i] = tmp;
        }

        int h = 0;
        while (h < citations.length && citations[h] >= h + 1) {
            h++;
        }
        return h;
    }
}