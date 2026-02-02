from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/selects")

print("Page Title:", driver.title)

dropdown_element = driver.find_element(
    By.XPATH, "/html/body/div/main/div/div/div/div/section/div[1]/select"
)

dropdown = Select(dropdown_element)

print("Dropdown options:")
for option in dropdown.options:
    print(option.text)

driver.quit()
