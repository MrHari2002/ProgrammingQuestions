import sys
# Lines to input files
lines = []
instruction = []
turtle = [7,0,0]

# Read board configuration
for i in range(8):
    lines.append(input())

# Read program instructions
instruction = input()

def move(y,x,i):
    if not check(y,x):
        return False
    elif(i == "F"):
        if turtle[2] % 360 == 0: 
            turtle[1] = x+1

        if turtle[2] % 360 == 90:
            turtle[0] = y-1

        if turtle[2] % 360 == 180: 
            turtle[1] = x-1

        if turtle[2] % 360 == 270: 
            turtle[0] = y+1

    elif(i == "L"):
        turtle[2] += 90
    elif(i == "R"):
        turtle[2] += 270
    elif(i == "X"):
        if turtle[2] % 360 == 0:
            if lines[y][x + 1] == "I":
                lines[y] = lines[y][:x + 1] + "." + lines[y][x + 2:]

        elif turtle[2] % 360 == 90:
            if lines[y - 1][x] == "I":
                lines[y - 1] = lines[y - 1][:x] + "." + lines[y - 1][x + 1:]

        elif turtle[2] % 360 == 180:
            if lines[y][x - 1] == "I":
                lines[y] = lines[y][:x - 1] + "." + lines[y][x:]

        elif turtle[2] % 360 == 270:
            if lines[y + 1][x] == "I":
                lines[y + 1] = lines[y + 1][:x] + "." + lines[y + 1][x + 1:]        
        else:
            return False
    return True



def check(y,x):
    if (8 > x >= 0) and (8 > y >= 0):
        pass
    else: 
        return False
    
    if lines[y][x] == "C" or lines[y][x] == "I":
        return False
    else:
        return True
         


for i in instruction:
    if not move(turtle[0],turtle[1],i): 
        print("Bug!") 
        sys.exit()

if lines[turtle[0]][turtle[1]] == "D":
    print("Diamond!")
else:
    print("Bug!")

