class Solution:
    def numTilings(self, n: int) -> int:
        dp = [1,2,5] + [0] * (n - 3)
        for i in range(3, n):
            dp[i] = (dp[i -3] + 2*dp[i - 1]) % 1000000007
        return dp[n-1]
    
s = Solution()
print(s.numTilings(3))