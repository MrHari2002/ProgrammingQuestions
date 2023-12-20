from typing import List

class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        Dict = {1:[],2:[]}
        for num in nums1:
            if num not in Dict[1]:
                Dict[1].append(num)
        for num in nums2:
            if num not in Dict[2]:
                Dict[2].append(num)
        return -1
    
print(Solution.findDifference(Solution, [1,2,3],[2,4,6]))