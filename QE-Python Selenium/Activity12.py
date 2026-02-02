from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

d = webdriver.Firefox()
w = WebDriverWait(d, 10)

d.get("https://training-support.net/webelements/dynamic-content")
print(d.title)

w.until(EC.element_to_be_clickable((By.XPATH, "//*[@id='genButton']"))).click()
w.until(EC.text_to_be_present_in_element((By.XPATH, "//*[@id='word']"), "release"))

print(d.find_element(By.XPATH, "//*[@id='word']").text)
d.quit()
