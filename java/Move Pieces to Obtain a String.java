/*
 Move Pieces to Obtain a String - 2337
 */

import java.util.ArrayList;
import java.util.List;

 class Solution {
    // Main method to check if it's possible to transform the start string to the target string
    public boolean canChange(String start, String target) {
        // Parse the strings to obtain the positions and types of 'L' and 'R' characters
        List<int[]> startPosList = parseString(start);
        List<int[]> targetPosList = parseString(target);

        // If the number of 'L' and 'R' characters in both strings is different,
        // transformation is not possible
        if (startPosList.size() != targetPosList.size()) {
            return false;
        }

        // Compare the positions and types of 'L' and 'R' characters in the two lists
        for (int i = 0; i < startPosList.size(); ++i) {
            int[] startPos = startPosList.get(i);
            int[] targetPos = targetPosList.get(i);

            // If the types of characters (L or R) are different at any point,
            // transformation is not possible
            if (startPos[0] != targetPos[0]) {
                return false;
            }
            // If 'L' in start is to the right of 'L' in target, transformation is not
            // possible as 'L' only moves left
            if (startPos[0] == 1 && startPos[1] < targetPos[1]) {
                return false;
            }
            // If 'R' in start is to the left of 'R' in target, transformation is not
            // possible as 'R' only moves right
            if (startPos[0] == 2 && startPos[1] > targetPos[1]) {
                return false;
            }
        }
        // All checks passed, transformation is possible
        return true;
    }

    // Helper method to parse a string to a list of positions and types for 'L' and 'R'
    private List<int[]> parseString(String s) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            // If the current character is 'L', add to the list with type 1
            if (currentChar == 'L') {
                result.add(new int[] { 1, i });
            }
            // If the current character is 'R', add to the list with type 2
            else if (currentChar == 'R') {
                result.add(new int[] { 2, i });
            }
        }
        return result;
    }
}
