from typing import List


class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        #if the grid doesn't exist
        if not grid or not grid[0]:
            return 0

        #Getting the width and height of the grid        
        width, height = len(grid), len(grid[0])

        """
        Recursively explores all possible paths from the given cell, and returns
        the maximum gold that can be collected.
        """
        def backtrack(i, j):
            #if out of bound
            if(i<0 or i >= width or j<0 or j>= height or grid[i][j] == 0):
                return 0
            gold = grid[i][j]
            grid[i][j] = 0
            max_gold = 0
            for dx, dy in [(-1,0),(1,0),(0,1),(0,-1)]:
                max_gold = max(max_gold, backtrack(i+dx,j+dy))
            grid[i][j] = gold
            return gold + max_gold

        
        #For every cell find the max gold
        max_gold_global = 0
        for i in range(width):
            for j in range(height):
                max_gold_global = max(max_gold_global,backtrack(i,j))
        
        return max_gold_global

    
solution = Solution()
print(solution.getMaximumGold([[1,2],[3,4]]))