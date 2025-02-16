# Group Anagrams - 49

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        # Create a hashmap to store the anagrams, with the sorted character counts as keys
        d = defaultdict(list)
        
        # Iterate over each string in the input list
        for s in strs:
            # Initialize a counter array to store the character counts
            cnt = [0] * 26
            
            # Count the occurrences of each character in the string
            for c in s:
                # Use the ASCII value of 'a' as a base to get the index of the character in the counter array
                cnt[ord(c) - ord('a')] += 1
            
            # Use the character counts as a key in the hashmap and append the string to the corresponding list
            d[tuple(cnt)].append(s)
        
        # Return the values of the hashmap as a list of lists, where each sublist contains anagrams
        return list(d.values())