from typing import List


class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:        
        l = maxSum = 0
        for r, num in enumerate(nums):
            if num == 0: 
                k-=1
            if k < 0:
                if nums[l] == 0:
                    k+=1
                l+=1
            else:
                maxSum = max(maxSum,r-l+1)
        return maxSum 
    
# print(Solution.findMaxAverage(Solution, [1,12,-5,-6,50,3],4))
print(Solution.longestOnes(Solution, [1,1,1,0,0,0,1,1,1,1,0],2))