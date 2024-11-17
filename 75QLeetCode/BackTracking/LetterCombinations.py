from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phoneDict = {"2":"abc","3": "def","4":"ghi","5":"jkl","6":"mno","7": "pqrs", "8": "tuv", "9": "wxyz"}
        res = []
        if len(digits) == 0:
            return res
        self.dfs(digits, 0, res, '', phoneDict)
        return res
    
    def dfs(self, nums, indexes, res, path, phoneDict):
        if indexes >= len(nums):
            res.append(path)
            return
        curString = phoneDict[nums[indexes]]
        for i in curString:
            self.dfs(nums,indexes + 1,res,path + i,phoneDict)

s = Solution()
print(s.letterCombinations("23"))