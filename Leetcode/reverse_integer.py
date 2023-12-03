def reverse(x: int) -> int:
    negative = 1
    if x < 0:
        negative = -1
        x = -x
    result = 0
    while x > 0:
        result = result * 10 + x % 10
        x = x // 10
    if -2 ** 31 < result < 2 ** 31:
        return negative * result
    else:
        return 0


print(reverse(-123))
