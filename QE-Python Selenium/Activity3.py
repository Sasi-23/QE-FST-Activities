from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/login-form")

print(driver.title)

driver.find_element(
    By.XPATH, '//*[@id="username"]'
).send_keys("admin")

driver.find_element(
    By.XPATH, '//*[@id="password"]'
).send_keys("password")

driver.find_element(
    By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/form/button"
).click()

driver.quit()
