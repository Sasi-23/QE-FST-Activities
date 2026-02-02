from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/dynamic-controls")

print("Page Title:", driver.title)

wait = WebDriverWait(driver, 10)

checkbox_xpath = "//*[@id='checkbox']"

toggle_btn_xpath = "/html/body/div/main/div/div/div/div/div[2]/section[1]/button"

checkbox = driver.find_element(By.XPATH, checkbox_xpath)
print("Checkbox displayed:", checkbox.is_displayed())

toggle_btn = driver.find_element(By.XPATH, toggle_btn_xpath)
toggle_btn.click()

wait.until(EC.invisibility_of_element_located((By.XPATH, checkbox_xpath)))
print("Checkbox disappeared")

toggle_btn.click()

checkbox = wait.until(
    EC.visibility_of_element_located((By.XPATH, checkbox_xpath))
)

checkbox.click()
print("Checkbox selected")

driver.quit()