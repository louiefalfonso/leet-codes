/*
 Optimal Partition of String - 2405

Given a string s, partition the string into one or more substrings such that
the characters in each substring are unique. That is, no letter appears in a 
single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings 

 */

 class Solution {
    public int partitionString(String s) {
        // 'bitMask' is used to keep track of the characters seen in the current
        // partition
        int bitMask = 0;

        // 'partitionsCount' represents the number of partitions needed
        int partitionsCount = 1;

        // Iterate over each character in the string
        for (char character : s.toCharArray()) {
            // Calculate the bit number corresponding to 'character'
            int bitNumber = character - 'a';

            // 'bitMask >> bitNumber' shifts the bitMask 'bitNumber' times to the right
            // '& 1' checks if the bit at position 'bitNumber' is set to 1, i.e., if
            // character is already seen
            if (((bitMask >> bitNumber) & 1) == 1) {
                // If the character has been seen, reset bitMask for a new partition
                bitMask = 0;

                // Increment partition count as we're starting a new partition
                ++partitionsCount;
            }

            // '|=' is the bitwise OR assignment operator. It sets the bit at position
            // 'bitNumber' in bitMask to 1
            // '1 << bitNumber' creates a bitmask with only bitNumber'th bit set
            // This indicates that character is included in the current partition
            bitMask |= 1 << bitNumber;
        }

        // Return the total number of partitions needed
        return partitionsCount;
    }
}