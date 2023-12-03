from typing import List


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        for i in range(len(flowerbed)):
            if flowerbed[i] == 1:
                pass
            elif Solution.checkAdjacent(i,flowerbed):
                flowerbed[i] = 1
                n-=1

        return n <= 0
    
    def checkAdjacent(flowerPosition,flowerbed):
        if flowerPosition >= len(flowerbed):
            return False
            
        if flowerPosition - 1 >= 0:
            if flowerbed[flowerPosition-1] == 1:
                return False


        if flowerPosition + 1 < len(flowerbed):
            if flowerbed[flowerPosition+1] == 1:
                return False

        return True

print(Solution.canPlaceFlowers(Solution,[1,0,0,0,1,0,0],2))