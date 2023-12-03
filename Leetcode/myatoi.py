def myAtoi(s: str) -> int:
    if s == "":
        return 0
    s = s.strip()
    negative = 1
    res = 0
    if s[0] == "-":
        negative = -1
    elif s[0] == "+":
        negative = 1
    elif not s[0].isnumeric():
        return 0
    else:
        res = ord(s[0]) - ord("0")
    for i in range(1, len(s)):
        if s[i].isnumeric():
            res = res * 10 + ord(s[i]) - ord("0")
        else:
            break
    if negative == 1 and res > 2 ** 31:
        res = 2 ** 31 - 1
    elif negative == -1 and res > 2 ** 31:
        res = -2 ** 31

    return negative * res








print(myAtoi("  happy hour 1"))
print(myAtoi("  -1000 happy hour 1"))
