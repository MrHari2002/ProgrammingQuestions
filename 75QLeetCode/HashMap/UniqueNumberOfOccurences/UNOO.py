from typing import List

class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        numberMap = {}
        for num in arr:
            if num not in numberMap.keys():
                numberMap[num] = 1
            else:
                numberMap[num] += 1
        
        unique_elements = set(numberMap.values())

        return len(unique_elements) == len(numberMap.values())
    
print(Solution.uniqueOccurrences(Solution, [1,2,3]))