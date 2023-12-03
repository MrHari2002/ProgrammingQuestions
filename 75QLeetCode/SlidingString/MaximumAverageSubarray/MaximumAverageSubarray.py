from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curSum = 0
        maxSum = 0
        copyK = k
        for i in range(len(nums)):
            if k > 0:
                curSum += nums[i]
                k-=1
                maxSum = curSum
            else:
                curSum += nums[i]
                curSum -= nums[i-copyK]
            maxSum = max(curSum,maxSum)
        return maxSum / copyK
    
# print(Solution.findMaxAverage(Solution, [1,12,-5,-6,50,3],4))
print(Solution.findMaxAverage(Solution, [-1],1))