a = input()
b = input()

num = 1

for number in range(len(a)):
    if a[number] != b[number]:
        num = num * 2

print(num)