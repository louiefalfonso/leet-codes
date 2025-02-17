# Top K Frequent Elements - 374

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # Create a dictionary to store the frequency of each number
        freq = {}
        
        for num in nums:
            # If the number is not in the dictionary, add it with a frequency of 0
            if num not in freq:
                freq[num] = 0
            # Increment the frequency of the number
            freq[num] += 1

        # Create a max heap to store the numbers and their frequencies
        # The heap is implemented as a list of tuples, where the first element is the negative frequency (to simulate a max heap)
        # and the second element is the number itself
        heap = [(-freq[num], num) for num in freq]
        # Convert the list into a heap
        heapq.heapify(heap)

        # Extract the top k frequent numbers from the heap
        # The heappop function returns the smallest element in the heap (which is the most frequent number in this case)
        # We use a list comprehension to extract the numbers (which are the second elements of the tuples)
        return [heapq.heappop(heap)[1] for _ in range(k)]