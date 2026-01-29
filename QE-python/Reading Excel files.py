import pandas as pd
df=pd.read_excel("users.xlsx")
print("Data from excel file:")
print(df)
rows,columns=df.shape
print("\n Number of rows:",rows)
print("\n Number of columns:", columns)
print("\n Emails column")
print(df["Email"])
print("\n Sorted by FirstName: ")
print(df.sort_values("FirstName", ascending=True))
