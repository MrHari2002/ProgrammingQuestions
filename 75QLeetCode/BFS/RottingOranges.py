from collections import deque

def orangesRotting(grid):
    q = deque()
    rows, cols = len(grid), len(grid[0])
    fresh, time = 0, 0

    for i in range(rows):
        for j in range(cols):
            if(grid[i][j] == 2):
                q.append((i,j))
            elif(grid[i][j] == 1):
                fresh += 1
    
    directions = [[0,1],[0,-1],[1,0],[-1,0]]
    while q and fresh > 0:
        for i in range(len(q)):
            poppedL, poppedR = q.popleft()
            for rowDiff, colDiff in directions:
                newCoordinateL, newCoordinateR = poppedL + rowDiff, poppedR + colDiff
                if(newCoordinateL < rows and newCoordinateL>= 0 and newCoordinateR < cols and newCoordinateR >= 0 and grid[newCoordinateL][newCoordinateR] == 1):
                    grid[newCoordinateL][newCoordinateR] = 2
                    q.append([newCoordinateL,newCoordinateR])
                    fresh -= 1
        time += 1
    return time if fresh == 0 else -1

                      
        
grid = [[2,1,1],[1,1,0],[0,1,1]]
print(orangesRotting(grid))

