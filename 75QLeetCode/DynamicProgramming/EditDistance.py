class Solution:
    #i is number of operations done on word1
    #j is number of operations done on word2
    def minDistance(self, word1, word2) -> int:
        def minDistance(word1, word2,i,j,memo) -> int:
            if i == len(word1) and j == len(word2):
                return 0
            if i == len(word1):
                return len(word2) - j
            if j == len(word2):
                return len(word1) - i
            if(i,j) not in memo:
                if word1[i] == word2[j]:
                    ans = minDistance(word1, word2,i+1,j+1,memo)
                else:
                    insert = 1 + minDistance(word1, word2,i,j+1,memo)
                    replace = 1 + minDistance(word1, word2,i+1,j+1,memo)
                    delete = 1 + minDistance(word1, word2,i+1,j,memo)
                    ans = min(insert, replace, delete)
                memo[(i,j)] = ans
            return memo[(i,j)]
        result = minDistance(word1, word2,0,0,{})
        return result
    

s = Solution()
print(s.minDistance("horse","ros"))