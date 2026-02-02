from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.alert import Alert
import time

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/alerts")
driver.maximize_window()

print("Page Title:", driver.title)

driver.find_element(By.XPATH, "//*[@id='confirmation']").click()

alert = Alert(driver)
print("Alert Text:", alert.text)

alert.accept()

time.sleep(2)
driver.quit()