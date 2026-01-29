from datetime import datetime
name=input("Enter a name:")
age=int(input("Enter age:"))
current_year = datetime.now().year
year_turn_100 = current_year + (100 - age)
print(f"Hello {name}")
print(f"You will turn 100 years old in the year {year_turn_100}.")
