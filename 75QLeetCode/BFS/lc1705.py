from typing import List
import heapq

class Solution:
    def eatenApples(self, apples: List[int], days: List[int]) -> int:
        n = len(apples)
        heap = []
        max_apples_eaten = 0
        day = 0

        while day < n or heap:
            #Add apples grown today to the head
            if day < n and apples[day] > 0:
                heapq.heappush(heap, (day + days[day], apples[day]))
            
            #Pop Rotten Apple
            while heap and heap[0][0] <= day:
                heapq.heappop(heap)

            #Eat an apple
            if heap:
                expiration, available_apples = heapq.heappop(heap)
                if available_apples > 1:
                    heapq.heappush(heap, (expiration, available_apples -1))
                max_apples_eaten += 1
            
            day += 1
        
        return max_apples_eaten


solution = Solution()
print(solution.eatenApples([1,2,3,5,2],[3,2,1,4,2]))
print(solution.eatenApples([9,2],[3,5]))

