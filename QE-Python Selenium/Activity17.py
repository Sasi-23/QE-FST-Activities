from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

d = webdriver.Firefox()
d.get("https://training-support.net/webelements/selects")
print("Title:", d.title)

m = Select(d.find_element(By.XPATH,
    "/html/body/div/main/div/div/div/div/section/div[2]/select"))

m.select_by_visible_text("HTML")
m.select_by_index(3)
m.select_by_index(4)
m.select_by_index(5)

d.execute_script("arguments[0].selected=true;",
    d.find_element(By.XPATH,
    "/html/body/div/main/div/div/div/div/section/div[2]/select/option[11]"))

d.execute_script("arguments[0].selected=false;",
    d.find_element(By.XPATH,
    "/html/body/div/main/div/div/div/div/section/div[2]/select/option[5]"))

time.sleep(1)
d.quit()
