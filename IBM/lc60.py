import math
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        numbers = list(range(1,n+1))
        k-=1
        result = []

        for i in range(n,0,-1):
            factorial = math.factorial(i-1)

            index = k // factorial

            result.append(str(numbers[index]))

            numbers.pop(index)

            k %= factorial

        return "".join(result)
    
solution = Solution()
print(solution.getPermutation(3,6))