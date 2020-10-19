def lcm(x, y):
    from fractions import gcd # or can import gcd from `math` in Python 3
    return x * y // gcd(x, y)
s = input()
a = s.index(' ')

print(lcm(int(s[(a+1):]), int(s[:a])))