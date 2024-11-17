from typing import List
import bisect

class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        prefixSumArray = [0] * (len(nums) + 1 )
        i = 1
        nums.sort()
        for num in nums:
            prefixSumArray[i] = prefixSumArray[i-1]+num
            i += 1        
        
        n = len(nums)
        res = []
        for q in queries:
            insertPoint = bisect.bisect_left(nums,q)
            leftMoves = q * insertPoint - prefixSumArray[insertPoint]
            rightMoves = (prefixSumArray[n] - prefixSumArray[insertPoint]) - q * (n-insertPoint)            
            res.append(leftMoves+rightMoves)
        return res
        
        
solution = Solution()    
print(solution.minOperations([3,1,6,8],[1,5]))

# nums = [1,3,6,8]
# prefixArray = [0,1,4,10,18]
# idx = bisect.bisect_left(nums,5)
# print(idx)
