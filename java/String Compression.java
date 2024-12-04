/*
String Compression - 443

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, 
be stored in the input character array chars. Note that group lengths that are 10 or longer
 will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 */

 class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0; // tracks where to write in the array
        int length = chars.length; // total length of the input array

        // start processing each sequence of characters
        for (int start = 0; start < length;) {
            // 'start' is the beginning of a sequence; 'end' will be one past the last char
            int end = start + 1;

            // expand the sequence to include all identical contiguous characters
            while (end < length && chars[end] == chars[start]) {
                end++;
            }

            // write the character that the sequence consists of
            chars[writeIndex++] = chars[start];

            // if the sequence is longer than 1, write the count of characters
            if (end - start > 1) {
                String count = String.valueOf(end - start); // convert count to string
                for (char c : count.toCharArray()) { // iterate over each character in the count
                    chars[writeIndex++] = c; // write count characters to the result array
                }
            }

            // move to the next sequence
            start = end;
        }

        // writeIndex represents the length of the the compressed string within the
        // array
        return writeIndex;
    }
}