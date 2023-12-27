# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
def guess(num: int) -> int:
    """Compare num with the secret number pick."""
    if num > 6:
        return -1
    elif num < 6:
        return 1
    else:
        return 0

class Solution:
    def guessNumber(self, n: int) -> int:
        min = 1
        max = n

        average = (min+max)//2

        while guess(average) != 0:
            if guess(average) == 1:
                min = average + 1
                
            if guess(average) == -1:
                max = average -1            
            average = (min+max)//2
        return average


print(Solution.guessNumber(Solution,10))
        

        