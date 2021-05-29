import pymysql

conn = pymysql.connect(host='localhost', user='root', password='java',
                       db='python', charset='utf8')

curs = conn.cursor()

sql = """
        UPDATE hello 
        SET
        col02 = '5'
        ,col03 = '4'
        WHERE col01 = 3
    """ 
    
cnt = curs.execute(sql)
print("cnt",cnt)
conn.commit()


conn.close()
