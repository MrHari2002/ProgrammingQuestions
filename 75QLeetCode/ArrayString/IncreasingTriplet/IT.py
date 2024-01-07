import sys
from typing import List


class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        f = sys.maxsize 
        s = sys.maxsize
        for i in nums:
            if i <= f:
                f = i
            elif i <= s:
                s = i
            else:
                return True
        return False
    
print(Solution.increasingTriplet(Solution,[1,1,1]))
