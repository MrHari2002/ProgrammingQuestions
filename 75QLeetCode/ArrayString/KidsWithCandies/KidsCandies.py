from typing import List


class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        booleanList = []
        candiesSorted = sorted(candies)
        mostCandies = candiesSorted[len(candies)-1]
        for candy in candies:
            if candy + extraCandies >= mostCandies:
                booleanList.append(True)
            else:
                booleanList.append(False)
        return booleanList

print(Solution.kidsWithCandies(Solution,[5,1,2,3],3))