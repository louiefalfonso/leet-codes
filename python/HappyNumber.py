# 202. Happy Number

def is_happy(n: int) -> bool:
   
    seen = set()  
    while n != 1 and n not in seen:
        seen.add(n)
        n = sum(int(digit) ** 2 for digit in str(n)) 
    return n == 1