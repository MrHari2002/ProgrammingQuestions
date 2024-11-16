from bisect import bisect_left
from typing import List


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        sorted_potions = sorted(potions)
        result = []
        for a in spells:
            lenSorted = len(sorted_potions)
            startingIndex = bisect_left(sorted_potions, (success + a -1 ) // a)
            result.append(lenSorted - startingIndex)
        return result
    
solution = Solution()
print(solution.successfulPairs([5,1,3],[1,2,3,4,5],7))