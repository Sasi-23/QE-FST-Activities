from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)
driver.get("https://training-support.net/webelements/drag-drop")

print(driver.title)

ball = wait.until(EC.visibility_of_element_located((By.ID, "ball")))
dz1  = wait.until(EC.visibility_of_element_located((By.ID, "dropzone1")))
dz2  = wait.until(EC.visibility_of_element_located((By.ID, "dropzone2")))

a = ActionChains(driver)

for dz, name in [(dz1, "Dropzone 1"), (dz2, "Dropzone 2")]:
    a.click_and_hold(ball).move_to_element(dz).release().perform()
    assert "Dropped" in dz.text
    print(f"Ball entered {name}")

driver.quit()
