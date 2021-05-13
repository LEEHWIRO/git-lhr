import pymysql
 
conn = pymysql.connect(host='localhost', user='root', password='java',
                       db='python', charset='utf8')
 
curs = conn.cursor()
 
sql = "delete from hello where col01= 3"
cnt = curs.execute(sql)
print("cnt",cnt) 
conn.commit()
conn.close()