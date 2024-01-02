from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        one, two = cost[len(cost)-1],cost[len(cost)-2]

        for i in range(0,len(cost)-2):
            cost[len(cost)-i-3] = min(cost[len(cost)-i-3]+one,cost[len(cost)-i-3]+two)
            one = two
            two = cost[len(cost)-i-3]
        
        return min(cost[0],cost[1])
    

print(Solution.minCostClimbingStairs(Solution,[1,100,1,1,1,100,1,1,100,1]))