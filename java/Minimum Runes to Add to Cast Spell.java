/*
 * Minimum Runes to Add to Cast Spell - 3383
 */

import java.util.HashMap;
import java.util.Map;

class MinimumRunesToAdd {
    public static int minimumRunes(int[] runes, int[] required) {
        // Count the current runes
        Map<Integer, Integer> runeCount = new HashMap<>();
        for (int rune : runes) {
            runeCount.put(rune, runeCount.getOrDefault(rune, 0) + 1);
        }

        int additionalRunesNeeded = 0;

        // Calculate the additional runes needed
        for (int req : required) {
            int currentCount = runeCount.getOrDefault(req, 0);
            if (currentCount < 1) {
                additionalRunesNeeded += 1; // Need one more rune of this type
            }
        }

        return additionalRunesNeeded;
    }
}