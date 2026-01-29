def calc(n):
    if n == 0:        
        return 0
    else:
        return n + calc(n - 1)
result = calc(10)
print("Sum from 0 to 10 is:", result)
