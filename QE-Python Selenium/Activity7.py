from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)

# Open page
driver.get("https://training-support.net/webelements/dynamic-controls")

# Print title
print("Title:", driver.title)

# Find input text field (YOUR XPath)
input_field = driver.find_element(By.XPATH, '//*[@id="textInput"]')

# Check if input field is enabled (before)
print("Input field enabled (before):", input_field.is_enabled())

# Click "Enable input" button (YOUR XPath)
driver.find_element(By.XPATH, '//*[@id="textInputButton"]').click()

# Wait until input field becomes enabled
wait.until(
    EC.element_to_be_clickable((By.XPATH, '//*[@id="textInput"]'))
)

# Check if input field is enabled (after)
print("Input field enabled (after):", input_field.is_enabled())

# Close browser
driver.quit()
