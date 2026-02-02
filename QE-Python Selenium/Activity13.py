from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

d = webdriver.Firefox()
w = WebDriverWait(d, 10)

d.get("https://training-support.net/webelements/tables")
print(d.title)

tb = w.until(EC.presence_of_element_located(
    (By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/table/tbody")
))

rows = tb.find_elements(By.TAG_NAME, "tr")
cols = rows[0].find_elements(By.TAG_NAME, "td")

print("Rows:", len(rows), "Columns:", len(cols))

for c in w.until(EC.presence_of_element_located(
        (By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[3]")
)).find_elements(By.TAG_NAME, "td"):
    print(c.text)

print("R2C2:",
      d.find_element(By.XPATH,
      "/html/body/div/main/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]").text)

d.quit()
