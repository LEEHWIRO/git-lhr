from mpl_toolkits import mplot3d
import numpy as np
import matplotlib.pyplot as plt
import pymysql


def getNames():
    ret = []
    conn = pymysql.connect(host='localhost', user='root', password='java',
                           db='python', charset='utf8')
    curs = conn.cursor()
    sql = """
        SELECT s_name FROM stock 
        GROUP BY s_name
        LIMIT 10
    """
    curs.execute(sql)
    rows = curs.fetchall()
    for row in rows:
        ret.append(row[0])
    
    conn.close()
    return np.array(ret)


def getPrices(s_name):
    ret = []
    conn = pymysql.connect(host='localhost', user='root', password='java',
                           db='python', charset='utf8')
    curs = conn.cursor()
    sql = """
    SELECT s_price FROM stock WHERE s_name = '{}'
    ORDER BY crawl_date
    """.format(s_name)
    curs.execute(sql)
    rows = curs.fetchall()
    for row in rows:
        ret.append(row[0])
    
    conn.close()
    return np.array(ret)


arr_name = getNames()
print(arr_name)

arrz = []
for i in range(len(arr_name)):
    arrz.append(getPrices(arr_name[i]))

arr_per_z = []
for i in range(len(arr_name)):
    imsi = (arrz[i]/arrz[i][0])*100
    arr_per_z.append(imsi)


fig = plt.figure()
ax = plt.axes(projection='3d')

x = np.array([1,1,1,1,1,1,1,1,1,1])
y = np.array([0,1,2,3,4,5,6,7,8,9])


for i in range(len(arr_name)):
    ax.plot3D(x+i, y, arr_per_z[i])


ax.set_title('3D line plot')
plt.show()







