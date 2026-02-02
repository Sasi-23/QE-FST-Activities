from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/dynamic-controls")

print("Title:", driver.title)

checkbox = driver.find_element(By.ID, "checkbox")

print("Checkbox selected (before):", checkbox.is_selected())

checkbox.click()

print("Checkbox selected (after):", checkbox.is_selected())

driver.quit()
