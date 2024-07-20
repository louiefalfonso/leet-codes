# String Encode and Decode

#Design an algorithm to encode a list of strings to a single string. 
#The encoded string is then decoded back to the original list of strings.

#Please implement encode and decode

#Example 1:
#Input: ["neet","code","love","you"]
#Output:["neet","code","love","you"]

class Solution:

    def encode(self, strs: List[str]) -> str:
        return ''.join(f"{len(s)}#{s}" for s in strs)

    def decode(self, s: str) -> List[str]:
        strs = []
        i = 0
        while i < len(s):
            j = s.find('#', i)
            length = int(s[i:j])
            i = j + 1
            strs.append(s[i:i+length])
            i += length
        return strs