from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        t1, t2 = 0 , -100000
        for price in prices:
            t1old = t1 
            t1 = max(t1, t2 + price)
            t2 = max(t2, t1old - price - fee)
        
        return t1

s = Solution()

print(s.maxProfit([1,3,2,8,4,9], 2))