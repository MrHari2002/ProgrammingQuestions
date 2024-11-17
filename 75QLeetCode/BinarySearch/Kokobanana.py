import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def feasible(speed) -> bool:
            sum = 0
            for pile in piles:
                sum += ( math.ceil(pile / speed))
            return sum <= h
            
        left, right = 1, max(piles)
        while left < right:
            mid = left + (right - left) // 2
            if feasible(mid):
                right = mid
            else:
                left = mid + 1    
        return left
    
s = Solution()
print(s.minEatingSpeed([3,6,7,11],8))