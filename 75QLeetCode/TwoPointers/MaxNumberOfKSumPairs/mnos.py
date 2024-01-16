from collections import Counter
from math import floor

from typing import List


class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
            c = Counter(nums)
            seen = set()
            result = 0
            for x in c:
                if x not in seen:
                    if x == k-x: result += floor(c[x]/2)
                    else: result += min(c[x],c[k-x])
                seen.add(x)
                seen.add(k-x)
            return result
    
print(Solution.maxOperations(Solution,[1,2,3,4,5],5))
