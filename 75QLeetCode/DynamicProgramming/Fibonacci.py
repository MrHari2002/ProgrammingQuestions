def fibb(i):
    if i == 0:
        return 0
    if i == 1:
        return 1
    return fibb(i-1) + fibb(i -2)

def dynaFibb(i):
    return dyna(i, [0] * (i+1))

def dyna(i, memo):
    if i == 1 or i == 0:
        return i
    
    if memo[i] == 0:
        memo[i] = dyna(i-1,memo) + dyna(i-2,memo)

    return memo[i]

print(dynaFibb(100))