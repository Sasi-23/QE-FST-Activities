from selenium import webdriver
from selenium.webdriver.common.by import By
with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/target-practice")
    print(driver.title)
    print(driver.find_element(By.XPATH,"//h3[@class='text-3xl font-bold text-orange-600']").text)
    print(driver.find_element(By.XPATH,"//h5[@class='text-3xl font-bold text-purple-600']").value_of_css_property("color"))
    print(driver.find_element(By.XPATH,"//button[contains(text(),'Purple')]").get_attribute("class"))
    print(driver.find_element(By.XPATH,"//button[contains(text(),'Slate')]").text)
    driver.quit()