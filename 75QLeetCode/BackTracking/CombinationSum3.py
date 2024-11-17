from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        self.dfs(k, n, res, [], list(range(1,10)))
        return res        
    def dfs(self, k, n, res, path, nums):
        #No Result
        if k < 0 or n < 0:
            return
        #Yes Result
        if k == 0 and n == 0:
            res.append(path)
            return
        #Continue
        for i in range(len(nums)):
            self.dfs(k-1, n-nums[i], res, path + [nums[i]], nums[i+1:])

solution = Solution()
print(solution.combinationSum3(3,7))