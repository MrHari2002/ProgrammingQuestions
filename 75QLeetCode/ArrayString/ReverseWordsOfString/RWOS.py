class Solution:
    def reverseWords(self, s: str) -> str:
        i = 0
        j = 0
        resultString = ""
        while j < len(s):
            while i < len(s) and s[i] == " ":
                i += 1
                j = i + 1
            while j < len(s) and s[j] != " ":
                j += 1
            if s[i:j] != " ":
                if resultString == "": resultString = s[i:j] + resultString
                else: resultString = s[i:j] + " " + resultString
            i = j+1
            j = i+1
        
        return resultString.strip()
            

print(Solution.reverseWords(Solution, "  hello world  "))