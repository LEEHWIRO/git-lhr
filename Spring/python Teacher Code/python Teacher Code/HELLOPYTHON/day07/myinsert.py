import pymysql


def insertStock(tuts):
    conn = pymysql.connect(host='localhost', user='root', password='java',
                           db='python', charset='utf8')

    curs = conn.cursor()
    sql = "INSERT INTO stock (s_code,s_name,s_price,crawl_date) VALUES (%s,%s,%s,%s)"
    cnt = curs.executemany(sql,tuts)

    conn.commit()
    conn.close()
    return cnt



if __name__ == '__main__':
    tuts = []
    tuts.append((1,1,1,1))
    cnt = insertStock(tuts)
    print("cnt",cnt)
    
    