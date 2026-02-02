from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 1. Open browser
driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)

# 2. Open page
driver.get("https://training-support.net/webelements/tables")

# 3. Print page title
print("Page Title:", driver.title)

# 4. Locate table body and count rows & columns
tbody = wait.until(EC.presence_of_element_located(
    (By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/table/tbody")
))

rows = tbody.find_elements(By.TAG_NAME, "tr")
cols = rows[0].find_elements(By.TAG_NAME, "td")

print("Number of Rows:", len(rows))
print("Number of Columns:", len(cols))

# 5. Book name in 5th row BEFORE sorting
book_before = driver.find_element(
    By.XPATH,
    "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]"
).text
print("Book name in 5th row before sorting:", book_before)

# 6. Click Price column header to sort (ascending)
price_header = driver.find_element(
    By.XPATH,
    "/html/body/div/main/div/div/div/div/div[2]/table/thead/tr/th[5]"
)
print("Sorting by column:", price_header.text)
price_header.click()

# 8. Print ALL prices in ascending order
print("Prices in ascending order:")
prices = driver.find_elements(
    By.XPATH,
    "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr/td[5]"
)

for price in prices:
    print(price.text)


# 7. Book name in 5th row AFTER sorting
book_after = wait.until(EC.presence_of_element_located(
    (By.XPATH,
     "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[5]/td[2]")
)).text
print("Book name in 5th row after sorting:", book_after)

driver.quit()
