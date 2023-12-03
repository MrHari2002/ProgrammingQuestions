from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.

        """
        left = 0
        right = 0
        for i in nums:
            if i == 0:
                right +=1
            else:
                copy = nums[left]
                nums[left] = nums[right]
                nums[right] = copy
                left +=1
                right +=1

        # zeroindex = []
        # numberindex = []
        # for index,i in enumerate(nums):
        #     if i == 0:
        #         zeroindex.append(index)
        #     else:
        #         numberindex.append(index)
        # for index,i in enumerate(numberindex):
        #     nums[index] = nums[i]
        # for index,i in enumerate(zeroindex):
        #     nums[index+len(numberindex)]= 0

            
            


print(Solution.moveZeroes(Solution, [0,1,0,3,12]))
