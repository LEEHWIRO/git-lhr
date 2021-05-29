import pymysql

conn = pymysql.connect(host='localhost', user='root', password='java',
                       db='python', charset='utf8')
tuts = (
        ('1','1','1'),
        ('2','2','2'),
        ('3','3','3')
    )

curs = conn.cursor()
sql = "INSERT INTO hello (col01,col02,col03) VALUES (%s,%s,%s)"
cnt = curs.executemany(sql,tuts)
print("cnt",cnt)

conn.commit()
conn.close()
