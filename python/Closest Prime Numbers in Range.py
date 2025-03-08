# Closest Prime Numbers in Range - 2523

# Function to generate prime numbers up to n using the Sieve of Eratosthenes algorithm
def sieve_of_eratosthenes(n):
    # Initialize a boolean array, prime, of size n+1
    sieve = [True] * (n + 1)
    # 0 and 1 are not prime numbers
    sieve[0:2] = [False, False]
    
    # Iterate over the array and mark the multiples of each prime number as non-prime
    for current_prime in range(2, int(n**0.5) + 1):
        if sieve[current_prime]:
            # Mark the multiples of the current prime number as non-prime
            for multiple in range(current_prime*2, n + 1, current_prime):
                sieve[multiple] = False
    
    # Return a list of all prime numbers in the range [2, n]
    return [num for num, is_prime in enumerate(sieve) if is_prime]


class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        # Generate all prime numbers up to right
        primes = sieve_of_eratosthenes(right)
        
        # Filter the prime numbers to only include those in the range [left, right]
        primes = [p for p in primes if p >= left]
        
        # If there are less than 2 prime numbers in the range, return [-1, -1]
        if len(primes) < 2:
            return [-1, -1]
        
        # Initialize the minimum difference and the result
        min_diff = float('inf')
        result = [-1, -1]
        
        # Iterate over the prime numbers to find the two closest ones
        for i in range(len(primes) - 1):
            # Calculate the difference between the current prime number and the next one
            diff = primes[i + 1] - primes[i]
            
            # If the difference is less than the minimum difference, update the minimum difference and the result
            if diff < min_diff:
                min_diff = diff
                result = [primes[i], primes[i + 1]]
        
        # Return the two closest prime numbers
        return result