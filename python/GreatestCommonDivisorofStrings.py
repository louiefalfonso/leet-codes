#1071. Greatest Common Divisor of Strings

class Solution(object):
    def gcdOfStrings(self, str1, str2):
        if len(str1) < len(str2):
            str1, str2 = str2, str1
        if str1 == str2:
            return str1
        if str1[:len(str2)] != str2:
            return ""
        return self.gcdOfStrings(str1[len(str2):], str2)

