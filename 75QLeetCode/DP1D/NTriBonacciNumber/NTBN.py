class Solution:
    def tribonacci(self, n: int) -> int:
        i = 0
        a = [0,1,1]
        
        while len(a)< n+1:
            if i > 2:
                a.append(a[i-3]+a[i-2]+a[i-1])
            i += 1

        return a[n]
    
print(Solution.tribonacci(Solution,4))