class solution:
    def mergeAlternatively(self,word:str,word2:str) -> str:
        total = word+word2
        newString = ""
        i = len(word)
        j = len(word2)
        while not (i == 0 and j == 0):
            if not i == 0:
                newString += word[len(word)-i]
                i-=1
            if not j == 0:
                newString += word2[len(word2)-j]
                j-=1
        return newString

print(solution.mergeAlternatively(solution,"abc","pqr"))
    