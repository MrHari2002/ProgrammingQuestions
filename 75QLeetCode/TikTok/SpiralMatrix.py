from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        result = [[0] * n for _ in range(n)]
        i, j, di, dj = 0, 0, 0, 1
        for cur in range(n * n):
            result[i][j] = cur + 1

            if result[(i + di) % n][(j + dj) % n]:
                di, dj = dj, -di

            i += di
            j += dj
        
        return result


s = Solution()
print(s.generateMatrix(5))

for i in s.generateMatrix(5):
    print(i)