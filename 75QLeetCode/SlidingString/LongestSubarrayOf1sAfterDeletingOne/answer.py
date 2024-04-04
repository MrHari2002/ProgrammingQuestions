

from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        l = 0
        nums_of_zeroes = 1
        for r,num in enumerate(nums):
            nums_of_zeroes -= num == 0
            
            if nums_of_zeroes < 0:
                nums_of_zeroes += nums[l] == 0
                l += 1
        return r-l

#print(Solution.longestSubarray(Solution,[1,1,0,1]))
print(Solution.longestSubarray(Solution,[0,1,1,1,0,1,1,0,1]))