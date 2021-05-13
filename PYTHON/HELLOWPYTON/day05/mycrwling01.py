import requests
from bs4 import BeautifulSoup

url = 'chiken.xml'

response = requests.get(url)

if response.status_code == 200:
    html = response.text
    #print(html)
    soup = BeautifulSoup(html, 'html.parser')
    #print(soup)
    title = soup.select("title")
    for i, title in enumerate(title):
        if i > 1:
            print(title.get_text())
else : 
    print(response.status_code)