from collections import deque
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #Helper Function To Do an inbound check
        def isInBound(x, y):
            return (x < len(grid) and x >= 0 and y < len(grid[0]) and y >= 0)
        #Helper Function to dd Breadth First Search
        def bfs(i, j):
            directions = [(1,0),(-1,0),(0,1),(0,-1)]
            q = deque()
            q.append((i,j))
            while q:
                x, y = q.popleft()
                for dx, dy in directions:
                   nx, ny = x+dx, y+dy
                   if(
                   # is in bound
                   isInBound(nx, ny) 
                   and
                   # is not visited
                   (nx,ny) not in visited
                   and
                   # is 1
                   grid[nx][ny] == "1"
                   ):
                       q.append((nx,ny))
                       visited.add((nx,ny))                    
        visited = set()
        islands = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j] == "1" and (i,j) not in visited):
                    islands += 1
                    visited.add((i,j))
                    bfs(i,j)


        return islands       
    

s = Solution()
print(s.numIslands([
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]))

print(s.numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]))