from typing import List
import bisect

class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        prefixSumArray = [0] * (len(nums) + 1 )
        i = 1
        for num in nums:
            prefixSumArray[i] = prefixSumArray[i-1]+num
            i += 1        
        
        nums.sort()
        for q in queries:
            insertPoint = bisect.bisect_left(nums,q)
             
        return prefixSumArray
        
        
        
        
        
        
solution = Solution()    
print(solution.minOperations([3,1,6,8],[1,5]))

nums = [1,3,6,8]
idx = bisect.bisect_left(nums,5)
print(idx)
