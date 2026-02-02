





from bs4 import BeautifulSoup
import requests
import pytest

@pytest.fixture
def home_page_content():
    res = requests.get("https://training-support.net")
    content = res.content
    soup=BeautifulSoup(content, "html.parser")
    return soup