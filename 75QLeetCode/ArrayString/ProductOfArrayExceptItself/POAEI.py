from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = 1
        postfix = 1
        returnArray = []
        returnArray.append(prefix)
        for i in nums[0:len(nums)-1]:
            prefix = prefix*i
            returnArray.append(prefix)

        returnArray[len(nums)-1] =  returnArray[len(nums)-1] * postfix
        for index, i in enumerate(nums[1:len(nums)]):
            postfix = postfix * nums[len(nums)-1-index]
            returnArray[len(nums)-2-index] = postfix * returnArray[len(nums)-2-index]


        return returnArray


# print(Solution.productExceptSelf(Solution,[1,2,3,4]))
print(Solution.productExceptSelf(Solution,[-1,1,0,-3,3]))
