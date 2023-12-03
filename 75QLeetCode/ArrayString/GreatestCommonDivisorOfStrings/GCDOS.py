
class Solution:

    def gcd(a,b):
        if(b == 0):
            return abs(a)
        else:
            return Solution.gcd(b, a % b)

    def gcdOfStrings(self,str1:str,str2:str) -> str:
        a = len(str1)
        b = len(str2)
        gcdNum = Solution.gcd(a,b)
        gcdWord = str1[:gcdNum]
        i = 0
        flag = True
        index = 0
        while i < a:
            if not str1[i] == gcdWord[index]:
                flag = False
                break
            if index == gcdNum - 1:
                index = 0
            else:
                index += 1
            i += 1

        j = 0
        index = 0
        while j < b:
            if not str2[j] == gcdWord[index]:
                flag = False
                break            
            if index == gcdNum - 1:
                index = 0
            else:
                index += 1

            j += 1        
        if flag:
            return gcdWord
        else:
            return "" 
    
print(Solution.gcdOfStrings(Solution,"ab","abab"))
print(Solution.gcdOfStrings(Solution,"abab","ab"))
print(Solution.gcdOfStrings(Solution,"abcabc","abc"))
print(Solution.gcdOfStrings(Solution,"leet","code"))


print(Solution.gcd(6,1))