class SmallestInfiniteSet:

    def __init__(self):
        self.cur = 1
        self.s = set()

    def popSmallest(self) -> int:
        if self.s:
            res = min(self.s)
            self.s.remove(res)
            return res;  
        else:
            self.cur += 1
            return self.cur - 1

    def addBack(self, num: int) -> None:
        if self.cur > num:
            self.s.add(num)


solution = SmallestInfiniteSet()
solution.addBack(2)
solution.popSmallest()
solution.popSmallest()
solution.popSmallest()
solution.addBack(1)
solution.popSmallest()
solution.popSmallest()
solution.popSmallest()

print(solution.s)

for s in solution.s:
    print(s)

