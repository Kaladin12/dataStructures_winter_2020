import math

def maxSubarray(array, low, mid, high):
    leftSum = -1*math.inf
    s = 0
    maxLeft=0
    maxRight = 0
    for i in range(mid, low, -1):
        s = s +array[i]
        if s > leftSum:
            leftSum = s
            maxLeft = i
    rightSum = -1*math.inf
    s = 0
    for j in range(mid+1, high):
        s = s + array[j]
        if (s > rightSum):
            rightSum = s
            maxRight = j
    return (maxLeft,maxRight, leftSum+rightSum)

array = [13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7]
print(maxSubarray(array, 0, int(len(array)/2), len(array)))