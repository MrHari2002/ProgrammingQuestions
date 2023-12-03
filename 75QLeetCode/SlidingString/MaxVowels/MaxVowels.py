from typing import List


class Solution:
    def maxVowels(self, s: str, k: int) -> int:        
        curSum = 0
        maxSum = 0
        copyK = k
        for i in range(len(s)):
            if k > 0:
                if s[i] in ["a","e","i","o","u"]:
                    curSum += 1
                k-=1
                maxSum = curSum
            else:
                if s[i] in ["a","e","i","o","u"]:
                    curSum += 1
                if s[i-copyK] in ["a","e","i","o","u"]:
                    curSum -= 1
            maxSum = max(curSum,maxSum)
        return maxSum
    
# print(Solution.findMaxAverage(Solution, [1,12,-5,-6,50,3],4))
print(Solution.maxVowels(Solution, "abciiidef",3))
print(Solution.maxVowels(Solution, "aeiou",2))
print(Solution.maxVowels(Solution, "leetcode",3))