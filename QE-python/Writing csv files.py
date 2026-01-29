import pandas as pd
data = {
    "username": ["admin", "charles", "deku"],
    "password": ["Password", "Charli3", "AllMight"]
}
df = pd.DataFrame(data)
df.to_csv("users.csv", index=False)

print("CSV file created successfully!")

