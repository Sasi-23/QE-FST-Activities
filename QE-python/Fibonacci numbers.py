"""
def fibonacci(n):
    if n <= 1:
        return n 
    else:
        return fibonacci(n-1) + fibonacci(n-2)
print(fibonacci(10))"""

#using while loop
n=int(input("enter a number:"))
a,b=0,1
count = 0
while count<n:
    print(a)
    c=a+b
    a=b
    b=c
    count += 1


"""n=10
a,b=0,1
for i in range(n):
    print(a)
    c=a+b
    a=b
    b=c
"""
  