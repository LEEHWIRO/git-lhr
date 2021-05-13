import pymysql

def insertChicken(tuts):
    conn = pymysql.connect(host='localhost', user='root', password='java',
                           db='python', charset='utf8')
   
    curs = conn.cursor()
    sql = "insert into chicken (col01,col02,col03) values (%s, %s, %s)"
    cnt = curs.executemany(sql, tuts)
    print("cnt",cnt)
    
    conn.commit()
    conn.close()
    return cnt

if __name__ == '__main__':
    tuts = [] 
    tuts.append((1,'1','3'))
    tuts.append((2,'1','3'))
    tuts.append((3,'1','3'))
    cnt = insertChicken(tuts)
    print("cnt",cnt)
    