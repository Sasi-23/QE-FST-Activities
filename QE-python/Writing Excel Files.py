import pandas as pd
data={
    "FirstName":["Satvik", "Avinash", "Lahri"],
    "LastName":["Shah", "Kati", "Rath"],
    "Email":["sashah@example.com", "avinashk@example.com", "lahrir@example.com"],
    "Phone number":[1234567890, 9876543210,9753864210]
}
df=pd.DataFrame(data)
df.to_excel("users.xlsx", index=False)
print("Created successfully")