from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import random, string

def rand(n=6):
    return ''.join(random.choices(string.ascii_letters, k=n))

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 15)

driver.get("https://training-support.net/webelements/dynamic-attributes")
print("Page Title:", driver.title)

name = rand()
email = rand() + "@test.com"
password = rand(6) + "@1"
details = rand(10)
date_value = "2026-02-01"   # YYYY-MM-DD (mandatory format)

wait.until(EC.presence_of_element_located(
    (By.XPATH, "//input[contains(@id,'full-name')]")
)).send_keys(name)

driver.find_element(By.XPATH, "//input[contains(@id,'email')]").send_keys(email)
driver.find_element(By.XPATH, "//*[@id='signInForm']/input[3]").send_keys(password)
driver.find_element(By.XPATH, "//textarea[contains(@id,'additional-details')]").send_keys(details)


date_field = driver.find_element(By.XPATH, "//input[@type='date']")
driver.execute_script("arguments[0].value = arguments[1];", date_field, date_value)

driver.find_element(By.XPATH, "//*[@id='signInForm']/button").click()

success = wait.until(EC.visibility_of_element_located(
    (By.XPATH, "//*[@id='action-confirmation']")
))
print("Success Message:", success.text)

driver.quit()
