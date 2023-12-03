class Solution:
    def reverseVowels(self, s: str) -> str:
        
        vowels = []
        newString = ""
        for c in s:
            if c in ["a","e","i","o","u","A","E","I","O","U"]:
                vowels.append(c)
        
        vowelsReverse = vowels[::-1]
        i = 0
        for c in s:
            if c in ["a","e","i","o","u","A","E","I","o","U"]:
                newString+=vowelsReverse[i]
                i+=1
            else:
                newString+=c
        return newString

    
print(Solution.reverseVowels(Solution,"OE"))