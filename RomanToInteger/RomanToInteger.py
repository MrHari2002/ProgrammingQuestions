class Solution:


    def romanToInt(self,s:str) -> int:
        romanTable = {
        "I":1,
        "V":5,
        "X":10,
        "L":50,
        "C":100,
        "D":500,
        "M":1000
        }
        result = 0
        for count,value in enumerate(s):
            if count + 1 < len(s):
                if value == "I" and (s[count+1] == "V" or s[count+1] == "X"):
                    result-=romanTable[value]
                elif value == "X" and (s[count+1] == "L" or s[count+1] == "C"):
                    result-=romanTable[value]
                elif value == "C" and (s[count+1] == "D" or s[count+1] == "M"):
                    result-=romanTable[value]
                elif value in romanTable.keys():
                    result+=romanTable[value]
            elif value in romanTable.keys():
                result+=romanTable[value]
            else:
                pass
        return result
    
print(Solution.romanToInt(Solution,s="III"))
print(Solution.romanToInt(Solution,s="IV"))