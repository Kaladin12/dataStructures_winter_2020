def bubble(x):
    for i in range(len(x)):
        for j in range(len(x)-1-i):
            if x[j]>x[j+1]:
                temp  = x[j]
                x[j] = x[j+1]
                x[j+1] = temp
    print(x)

x = [4,0,-1,12,45,102,3,56,845,5,1,23,32,99,2,101]
#bubble(x)

def modBubble(x):
    flag = False
    for i in range(len(x)):
        flag = False
        for j in range(len(x)-i-1):
            if x[j]>x[j+1]:
                temp = x[j]
                x[j] = x[j+1]
                x[j+1] = temp
                flag = True
        if flag == False:
            break
    print(x)

#modBubble(x)

def selection(x):
    for i in range(len(x)):
        minn = i
        for j in range(i+1, len(x)):
            if x[j]<x[minn]:
                minn = j
        temp = x[i]
        x[i] = x[minn]
        x[minn] = temp
    print(x)

selection(x)

def insertion(x):
    for i in range(1,len(x)):
        key = x[i]
        j= i-1
        while j>=0 and x[j]>key:
            x[j+1] = x[j]
            j-=1
        x[j+1] = key
    print(x)

#insertion(x)

