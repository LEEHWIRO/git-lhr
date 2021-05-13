import requests
from bs4 import BeautifulSoup
from py import xml

url = 'chiken.xml'

response = requests.get(url)

if response.status_code == 200:
    html = response.text
    #print(html)
    soup = BeautifulSoup(xml, 'xml.parser')
    #print(soup)
    item = soup.select("item")
    for i, item in enumerate(item):
        if i > 1:
            print(item.get_text())
else : 
    print(response.status_code)