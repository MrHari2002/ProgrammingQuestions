from typing import List


def opsToVar(nums: List[int], var:int) -> int:
    absSum = 0
    for num in nums:
        absSum += abs(var-num)
    
    return absSum
def minOperations(nums: List[int], queries: List[int]) -> List[int]:
    res = []
    for q in queries:
        res.append(opsToVar(nums,q))
    return res


print(minOperations([3,1,6,8],[1,5]))