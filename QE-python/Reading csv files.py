import pandas as pd
df=pd.read_csv("users.csv")
print("usernames:")
print(df["username"])
print("\n--------------------------\n")

print("username and password of second row:")
print(df.loc[1])

print("\n---------------------------\n")

print("Usernames in Ascending Order:")
print(df.sort_values("username"))

print("\n----------------------------\n")

print("Passwords in Descending Order:")
print(df.sort_values("password", ascending=False))