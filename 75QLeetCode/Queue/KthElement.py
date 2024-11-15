from typing import List

# Given an integer array nums and an integer k, return the kth largest element in the array.

# Note that it is the kth largest element in the sorted order, not the kth distinct element.

# Can you solve it without sorting?


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        return nums[n - k ]
    
solution = Solution()
print(solution.findKthLargest([3,2,1,5,6,4],2))