import os
import sys
import urllib.request
from bs4 import BeautifulSoup
import pymysql
from _datetime import datetime
import time

def insertStock(tuts):
    conn = pymysql.connect(host='localhost', user='root', password='java', db='python', charset='utf8')
    
    curs = conn.cursor()
    sql = "insert into stock(s_code, s_name, s_price, crawl_date) values(%s, %s, %s, %s)"
    cnt = curs.executemany(sql,tuts) 
    
    conn.commit()
    conn.close()
    return cnt

for i in range(10):
    url = "https://vip.mk.co.kr/newSt/rate/item_all.php" 
    request = urllib.request.Request(url)
    response = urllib.request.urlopen(request)
    rescode = response.getcode()
    if(rescode==200):
        response_body = response.read()
        
        soup = BeautifulSoup(response_body , 'html.parser')
        
        items = soup.select("td.st2 > a")
        items2 = soup.select("td[width='60'][align='right']")
        items3 = soup.select("span.t_11_black")
        
        #now = datetime.datetime.now()    
        #crawl_date = now.strftiomie("%Y%m%d_%h%M%S")
        tuts = []
        
        for i,item in enumerate(items):
            s_name = item.text
            s_code = item['title']
            s_price = items2[i].text.replace(",", "")
            crawl_date = "2021-" + items3[0].text.replace(".", "-")
            tuts.append((s_code, s_name, s_price, crawl_date))
    
        cnt = insertStock(tuts)
        print("insert횟수 :",cnt)
        
    else:
        print("Error Code:" + rescode)
    
    time.sleep(60)