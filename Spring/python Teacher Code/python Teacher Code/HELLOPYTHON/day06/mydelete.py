import pymysql

conn = pymysql.connect(host='localhost', user='root', password='java',
                       db='python', charset='utf8')

curs = conn.cursor()

sql = "DELETE FROM hello WHERE col01=2"
cnt = curs.execute(sql)
print("cnt",cnt)
conn.commit()


conn.close()
