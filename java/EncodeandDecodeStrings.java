/*
 Design an algorithm to encode a list of strings to a single string.
 The encoded string is then decoded back to the original list of strings.
 
 Example 1:
 
Input: ["neet","code","love","you"]
Output:["neet","code","love","you"]
 
 Example 2:
 Input: ["we","say",":","yes"]
 Output: ["we","say",":","yes"]
 
 */

import java.util.ArrayList;
import java.util.List;

 class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            // use the length of the string followed by a '#' to indicate the length of the string
            encodedString.append(str.length()).append('#').append(str);
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {

            // Find the position of the delimiter '#'
            int j = s.indexOf('#', i);

            // Get the length of the next string
            int length = Integer.parseInt(s.substring(i, j));

            // Move the index to the start of the string
            i = j + 1;

            // Extract the string based on the length
            String str = s.substring(i, i + length);
            decodedList.add(str);
            
            // Move the index forward by the length of the string
            i += length;
        }
        return decodedList;
    }
}
