import sys

lines = []

number = {
    "0": "zero",
    "1": "one",
    "2": "two",
    "3": "three",
    "4": "four",
    "5": "five",
    "6": "six",
    "7": "seven",
    "8": "eight",
    "9": "nine",
    "10": "ten",
    "11": "eleven",
    "12": "twelve",
    "13": "thirteen",
    "14": "fourteen",
    "15": "fifteen",
    "16": "sixteen",
    "17": "seventeen",
    "18": "eighteen",
    "19": "nineteen",
    "20": "twenty",
    "30": "thirty",
    "40": "forty",
    "50": "fifty",
    "60": "sixty",
    "70": "seventy",
    "80": "eighty",
    "90": "ninety"
}

def convertNum(num):
    if num in number.keys():
        return number[num]
    else:
        intNum = int(num)
        intMod = intNum % 10
        intTen = intNum - intMod
        return number[str(intTen)] + "-" + number[str(intMod)]

def capitalize(word):
    return word[0].upper() + word[1:]

# print(capitalize("hi"))
# print(convertNum("90")+"-"+convertNum("9"))
# print(convertNum("60")+"-"+convertNum("5"))
# print(convertNum("99"))
# for i in range(100):
#     print(convertNum(str(i)))
#print(convertNum("99"))
# sys.exit

while True:
    try:
        line = input()
        if line == "":
            break
        lines.append(line)
    except EOFError:
        break



for line in lines:
    words = []
    for word in line.split(" "):
        words.append(word)

    newString = ""
    for index,item in enumerate(words):
        if item.isdigit():
            if index == 0:
                newString += capitalize(convertNum(item)) + " "
            else:
                newString += convertNum(item) + " "
        else:
            newString += item + " "    
    print(newString)

#print(lines)
#print(words)

