from typing import List


class Solution:
    def minMoves(self, nums: List[int]) -> int:
        min_num = min(nums)
        total_sum = sum(nums)
        moves = total_sum - min_num * len(nums)
        return moves
    

solution = Solution()
print(solution.minMoves([1,2,3]))