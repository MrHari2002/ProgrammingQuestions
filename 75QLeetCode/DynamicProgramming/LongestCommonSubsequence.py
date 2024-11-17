class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m = [[0] * (len(text2) + 1) for _ in range(len(text1) + 1)]

        print(m)

        for i in range(len(text1)):
            for j in range(len(text2)):
                if text1[i] == text2[j]:
                    m[i+1][j+1] = m[i][j] + 1
                else:
                    m[i+1][j+1] = max(m[i+1][j],m[i][j+1])

        return m[len(text1)][len(text2)]

s = Solution()
print(s.longestCommonSubsequence("abcba" ,"abcbcba")) 