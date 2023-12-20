from typing import List

class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        Dict = {1:[],2:[]}
        Answer=[]
        for num in nums1:
            if num not in Dict[1]:
                Dict[1].append(num)
        for num in nums2:
            if num not in Dict[2]:
                Dict[2].append(num)
                    
                    
        answer1 = []
        for num in Dict[1]:
            if num not in Dict[2]:
                answer1.append(num)
        Answer.append(answer1)

        answer2 = []
        for num in Dict[2]:
            if num not in Dict[1]:
                answer2.append(num)
        Answer.append(answer2)


        return Answer
    
print(Solution.findDifference(Solution, [1,2,3],[2,4,6]))