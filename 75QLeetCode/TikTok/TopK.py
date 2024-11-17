import heapq
from typing import List


class Solution:
    # def topKFrequent(self, nums: List[int], k: int) -> List[int]:
    #     myDict = {}
    #     res = []
    #     for i in nums:
    #         if i in myDict:
    #             myDict[i] += 1
    #         else:
    #             myDict[i] = 1

    #     sortedDict = dict(sorted(myDict.items(),key=lambda item: item[1],reverse=True))
    #     for i in sortedDict:
    #         if k > 0:
    #             res.append(i)
    #             k -= 1
    #     return res
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = {}
        orderHeap = []

        for i in nums:
            counter[i] = 1 + counter.get(i,0)
        
        for key, val in counter.items():
            heapq.heappush(orderHeap,(-val, key))

        res = []
        while(len(res) < k):
            res.append(heapq.heappop(orderHeap)[1])
        return res
    
        
s = Solution()
print(s.topKFrequent([3,0,1,0],1))
#print(s.topKFrequent([1,1,1,2,2,3],2))