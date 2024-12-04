/*
 Greatest Common Divisor of Strings - 1071

 For two strings s and t, we say "t divides s" 
 if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 */


 class Solution {

    // Function to find the greatest common divisor of lengths of two strings.
    // This GCD can be used to find the longest substring that can construct
    // the given strings by repeated concatenation.


    public String gcdOfStrings(String str1, String str2) {
        // Check if the two strings can be constructed from a common substring
        // Only if str1+str2 equals str2+str1, they have a common divisor string
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; // If not, return an empty string as there is no common divisor
        }
        // Calculate the GCD of lengths of the two strings
        int len = gcd(str1.length(), str2.length());
        // The substring from the beginning of str1 with length 'len' is the gcd string
        return str1.substring(0, len);
    }

    // Helper function to calculate the greatest common divisor (GCD) of two integers
    private int gcd(int a, int b) {
        // Base case: if b is 0, then a is the GCD (as GCD(a, 0) = a)
        // Recursive step: GCD(a, b) = GCD(b, a mod b)
        return b == 0 ? a : gcd(b, a % b);
    }
}