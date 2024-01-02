from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        SolutionArray = []
        SignificantPower = 1
        for i in range(n+1):
            if i == 0:
                SolutionArray.append(i)
            else:
                if SignificantPower * 2 == i:
                    SignificantPower = SignificantPower * 2
                SolutionArray.append(1 + SolutionArray[ i - SignificantPower])
        return SolutionArray
    
print(Solution.countBits(Solution,5))