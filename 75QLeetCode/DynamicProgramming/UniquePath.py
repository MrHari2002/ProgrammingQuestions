class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        twoDDp =[[1] * n] * m
        for i in range(1,m):
            for j in range(1,n):
                twoDDp[i][j] = twoDDp[i-1][j] + twoDDp[i][j-1]

        return twoDDp[m - 1][n - 1]

s = Solution()
print(s.uniquePaths(3,7))