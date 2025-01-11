// Construct K Palindrome Strings - 1400

class Solution {
    public boolean canConstruct(String inputString, int palindromeCount) {
        // Length of the input string
        int length = inputString.length();

        // If the input string is shorter than the required number of palindromes,
        // it is not possible to construct the palindromes.
        if (length < palindromeCount) {
            return false;
        }

        // Array to hold the count of each character in the inputString.
        int[] characterFrequency = new int[26];

        // Count the frequency of each character in the inputString.
        for (int i = 0; i < length; ++i) {
            characterFrequency[inputString.charAt(i) - 'a']++;
        }

        // Count the number of characters that appear an odd number of times.
        int oddCount = 0;
        for (int frequency : characterFrequency) {
            oddCount += frequency % 2;
        }

        // It is possible to form palindromes if the number of characters with
        // odd frequency is less than or equal to the number of palindromes we need to
        // construct.
        return oddCount <= palindromeCount;
    }
}