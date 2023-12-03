from typing import List

class Solution:
    def FindPivotIndex(self, nums: List[int]) -> int:        
        Sum = 0
        for i in nums:
            Sum+=i
        
        SumToTheLeft = 0
        for index, i in enumerate(nums):
            if SumToTheLeft == Sum - i - SumToTheLeft:
                return index
            SumToTheLeft+=i
        return -1
    


print(Solution.FindPivotIndex(Solution, [1,1,1,0,0,0,1,1,1,1,0]))