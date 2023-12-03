def solution(a, i=None):
    if len(a) % 2 == 0:
        if a[len(a)-1] < a[0]:
            return False
        for i in range(len(a) - 2, int(len(a) / 2), -1):
            if not (a[i - 1] > a[i] > a[len(a) - 1 - i] and a[len(a) - i - 1] > a[i + 1]):
                return False
        if a[int(len(a) / 2 - 1)] < a[int(len(a) / 2 - 2)]:
            return False
    else:
        for i in range(len(a) - 1, int(len(a) / 2), -1):
            if not (a[i - 1] > a[i] > a[len(a) - 1 - i]):
                return False
    return True


#print(solution([1, 3, 5, 6, 4, 2]))
#print(solution([1, 3, 5, 4, 2]))
print(solution([-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48]))
