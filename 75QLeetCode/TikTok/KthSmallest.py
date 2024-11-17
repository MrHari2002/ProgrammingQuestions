from typing import List


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        def findLessEqual(x):
            c = n - 1
            counter = 0
            for r in range(m):
                while c>= 0 and matrix[r][c] > x:
                    c -= 1
                counter += (c + 1)
            return counter
        
        # Binary Search and SubSearch
        left = matrix[0][0]
        right = matrix[-1][-1]
        while left <= right:
            mid = (left + right) // 2
            if findLessEqual(mid) >= k:
                right = mid - 1
            else:
                left = mid + 1
        return left
    
s = Solution()
print(s.kthSmallest([[1,5,9],[10,11,13],[12,13,15]], 8))

        
