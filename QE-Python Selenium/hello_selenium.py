from selenium import webdriver

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net")

    print(driver.title)

    driver.quit()