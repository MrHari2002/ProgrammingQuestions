import math
from typing import List


class Solution:
    
    def rob(self, nums: List[int]) -> int:
        memo = [-1] * (len(nums) + 1)
        def rob(nums, i):
            if i < 0: return 0
            if memo[i] >= 0:
                return memo[i]
            result = max(rob(nums, i - 2) + nums[i], rob(nums, i-1))
            memo[i] = result
            return result

        return rob(nums, len(nums)-1)
    
s = Solution()
print(s.rob([1,2,3,1]))


    
    