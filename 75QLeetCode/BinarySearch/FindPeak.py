from bisect import bisect_left
from typing import List

# If You are in the descending part of the array.
# The peak is to the left (including mid).
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if(nums[mid] > nums[mid + 1]):
                right = mid 
            else:
                left = mid + 1
        
        return left
    
s = Solution()
print(s.findPeakElement([1,2,3,1]))