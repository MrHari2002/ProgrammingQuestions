from collections import defaultdict
def countDivisibleSubstrings(word: str) -> int:
    d = ["ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz"]
    #starts from 1
    charMap = {}
    for index, string in enumerate(d,1):
        for char in string:
            charMap[char] = index

    n = len(word)
    prefix_sum = [0] * (n+1)

    for i in range(n):
        prefix_sum[i+1] = prefix_sum[i] + charMap[word[i]]
    
    totalCount = 0
    for length in range(1, n+1):
        for i in range(n-length+1):
            mod = prefix_sum[i+length] - prefix_sum[i]
            if mod % length == 0:
                totalCount += 1

    return totalCount

print(countDivisibleSubstrings("asdf"))