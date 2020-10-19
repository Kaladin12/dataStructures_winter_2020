import numpy as np

a = np.random.rand(1,20)
array = []
for i in a:
    for n in i:
        array.append(int( n*100))
        array.sort()
print(array)

def binarySearch(array, item, start, end):
    n = int(abs(end+start)/2)
    if array[n] == item:
        return n
    if array[n]<item:
        return binarySearch(array, item, n+1, end)
    elif array[n]>item:
        return binarySearch(array, item, start,n-1 )
    

print(binarySearch(array, int(input('numero: ')), 0, len(array)))