from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
import time

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/keyboard-events")

print("Page Title:", driver.title)

body = driver.find_element(By.TAG_NAME, "body")
body.click()

message = "Hello from Selenium Firefox"

actions = ActionChains(driver)
actions.send_keys(message).perform()

print("Typed Message:", message)

time.sleep(2)
driver.quit()