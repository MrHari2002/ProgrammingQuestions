from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        num_of_characters = len(chars)
        if num_of_characters < 2:
            return num_of_characters
        
        i = 0
        j = 0
        value = 0
        while i < num_of_characters:
            value = 1
            while i < num_of_characters  - 1 and chars[i] == chars[i+1]:
                    value += 1
                    i += 1
            chars[j] = chars[i]
            j += 1
            if value > 1:
                for s in str(value):
                    chars[j] = s
                    j += 1
            i += 1

        return j
    
print(Solution.compress(Solution,["a","a","b","b","c","c","c"]))