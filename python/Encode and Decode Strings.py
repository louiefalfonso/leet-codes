# Encode and Decode Strings - 271

class Solution:

    # Encodes a list of strings into a single string
    def encode(self, strs: List[str]) -> str:
        # Use a generator expression to create a string for each input string
        # The string is in the format "{length}#{string}", where length is the length of the string
        return ''.join(f"{len(s)}#{s}" for s in strs)

    # Decodes a single string back into a list of strings
    def decode(self, s: str) -> List[str]:
        # Initialize an empty list to store the decoded strings
        strs = []
        # Initialize a pointer to the current position in the string
        i = 0
        # Loop until we've processed the entire string
        while i < len(s):
            # Find the position of the '#' character, which separates the length from the string
            j = s.find('#', i)
            # Extract the length of the string from the substring before the '#'
            length = int(s[i:j])
            # Move the pointer past the '#' character
            i = j + 1
            # Extract the string itself from the substring of the specified length
            strs.append(s[i:i+length])
            # Move the pointer past the extracted string
            i += length
        # Return the list of decoded strings
        return strs