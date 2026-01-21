import sys

sys.setrecursionlimit(1073741824)

num = int(input("Enter a Number: "))

def isEven(number):
    if number > 1:
        return isEven(number - 2)
    elif number < 0: 
        return isEven(number + 2)
    elif number == 1:
        return False
    elif number == 0:
        return True    
    
print("Is It Even? " + str(isEven(num)))