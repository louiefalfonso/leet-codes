# Valid Anagram - 242


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        # Using dictionaries to store the count of each character
        count_s = {}
        count_t = {}
        
        # Count the number of each character in the strings
        for char in s:
            # If the character is not in the dictionary, add it with a count of 1
            count_s[char] = count_s.get(char, 0) + 1
        
        # Count the number of each character in the strings
        for char in t:
            # If the character is not in the dictionary, add it with a count of 1
            count_t[char] = count_t.get(char, 0) + 1
        
        # Return True if the dictionaries are equal
        return count_s == count_t