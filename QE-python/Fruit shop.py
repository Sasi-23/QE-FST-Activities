fruits = {
    "apple": 120,
    "banana": 40,
    "orange": 60,
    "mango": 150,
    "grapes": 90
}

fruit_name = input("Enter the fruit you want to check: ").lower()
if fruit_name in fruits:
    print(f"{fruit_name.capitalize()} is available.")
    print(f"Price: {fruits[fruit_name]}")
else:
    print(f"Sorry, {fruit_name.capitalize()} is not available.")
