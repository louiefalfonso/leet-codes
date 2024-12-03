/*
Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also
case-insensitive and ignores all non-alphanumeric characters.

Example 1:
Input: s = "Was it a car or a cat I saw?"
Output: true

Example 2:
Input: s = "tab a cat"
Output: false


 */

class Solution {
    public boolean isPalindrome(String s) {
        
        // Two pointers
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next valid character
            while (left < right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous valid character
            while (left < right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            // Compare characters
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            // Move both pointers
            left++;
            right--;
        }

        return true; // If we complete the loop, it's a palindrome
    }

    // Helper method to check if a character is alphanumeric
    private boolean isAlphanumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
