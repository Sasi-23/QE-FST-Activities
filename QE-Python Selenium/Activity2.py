from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/login-form")

print(driver.title)


driver.find_element(By.ID, "username").send_keys("admin")

driver.find_element(By.ID, "password").send_keys("password")

driver.find_element(By.CSS_SELECTOR,"body > div > main > div > div > div > div > div.mx-auto.my-5.flex.flex-col.justify-center.align-middle > form > button")
        

driver.quit()

