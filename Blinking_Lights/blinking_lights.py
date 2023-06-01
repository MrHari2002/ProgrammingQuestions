
def gcd(a,b):
    return a if b == 0 else gcd(b, a % b)

text = input()
numArray = [int(num) for num in text.split()]
multiply = numArray[0] * numArray[1]
lcm = multiply / gcd(numArray[0], numArray[1])

print(lcm)
print(gcd(numArray[0], numArray[1]))

if numArray[2] >= lcm:
    print("yes")
else:
    print("no")
