lineI = ""
lineList = []
while lineI != "0 0":
    lineI = input()
    if lineI != "0 0":
        lineList.append(lineI)

for line in lineList:
    a, b = line.split()
    a = int(a)
    b = int(b)
    num = a // b
    mod = a % b
    print(str(num) + " "+ str(mod) + " / "+ str(b))