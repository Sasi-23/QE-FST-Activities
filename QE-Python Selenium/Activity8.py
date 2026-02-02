from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)
actions = ActionChains(driver)

driver.get("https://training-support.net/webelements/mouse-events")
print("Title:", driver.title)

cargo_lock = driver.find_element(By.CSS_SELECTOR, ".file:nth-child(1)")
cargo_toml = driver.find_element(By.CSS_SELECTOR, ".file:nth-child(2)")
src = driver.find_element(By.CSS_SELECTOR, ".file:nth-child(3)")
target = driver.find_element(By.CSS_SELECTOR, ".file:nth-child(4)")

actions.click(cargo_lock).move_to_element(cargo_toml).click().perform()
print(driver.find_element(By.ID, "result").text)

actions.double_click(src).context_click(target).perform()

open_option = wait.until(
    EC.element_to_be_clickable((By.CSS_SELECTOR, "li.w-full:nth-child(1)"))
)
open_option.click()

print(driver.find_element(By.ID, "result").text)

driver.quit()
