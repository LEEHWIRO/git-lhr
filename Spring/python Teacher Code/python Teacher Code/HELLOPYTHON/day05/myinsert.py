import pymysql


def insertChicken(tuts):
    conn = pymysql.connect(host='localhost', user='root', password='java',
                           db='python', charset='utf8')

    curs = conn.cursor()
    sql = "INSERT INTO hello (col01,col02,col03) VALUES (%s,%s,%s)"
    cnt = curs.executemany(sql,tuts)

    conn.commit()
    conn.close()
    return cnt

if __name__ == '__main__':
    tuts = []
    tuts.append(('1','1','1'))
    tuts.append(('2','2','2'))
    tuts.append(('3','3','3'))
    cnt = insertChicken(tuts)
    print("cnt",cnt)