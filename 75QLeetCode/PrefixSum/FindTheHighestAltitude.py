from typing import List

class Solution:
    def largestAltitude(self, gain: List[int]) -> int:        
        sum = 0
        best_sum = 0

        for index, i in enumerate(gain):
            sum+=i
            if sum >best_sum:
                best_sum = sum
        
        return best_sum 
    


print(Solution.largestAltitude(Solution, [1,1,1,0,0,0,1,1,1,1,0]))