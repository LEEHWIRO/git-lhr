from mpl_toolkits import mplot3d
import numpy as np
import matplotlib.pyplot as plt
import pymysql
import random
def getPrices(s_name):
    ret = []
    conn = pymysql.connect(host='localhost', user='root', password='java', db='python', charset='utf8')
    
    curs = conn.cursor()
    sql = "select s_price FROM stock where s_name = '{}' ORDER BY s_name, crawl_date".format(s_name)
    curs.execute(sql)
    
    rows = curs.fetchall()
    for row in rows:
        ret.append(row[0])
        
    conn.close()
    return ret

conn = pymysql.connect(host='localhost', user='root', password='java', db='python', charset='utf8')
curs = conn.cursor()
sql = "SELECT s_name FROM stock GROUP BY s_name ORDER BY s_name, crawl_date"
curs.execute(sql)

rows = curs.fetchall()
arrs = []
for i,row in enumerate(rows):
    arrs.append(row[0])
conn.close()

ret=[]
ax = plt.axes(projection='3d')
for i,arr in enumerate(arrs):
    ret = getPrices(arr)
    ret0 = ret[0]
    per = ret*(100%ret[0])
    z = per     
    fig = plt.figure()
    x = np.array([i,i,i,i,i,i,i,i,i,i]) 
    y = np.array([0,1,2,3,4,5,6,7,8,9])
    color = ['red', 'blue', 'green', 'yellow', 'pink']
    ax.plot3D(x, y, z, color[random.randrange(1,6)])
    print(i)
ax.set_title('3D line plot')
plt.show()
    

