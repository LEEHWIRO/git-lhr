import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic, QtWidgets
from PyQt5 import QtGui
from PyQt5.Qt import QPushButton, QSize, QRect, QMessageBox, reset
from astropy.time.utils import split
from sqlalchemy.sql.expression import false

form_class = uic.loadUiType("myomock01.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.index = 1
        self.flag_wb = True
        self.flag_ing = True
        self.setupUi(self)
        self.arr2D = [
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],

                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0],
                [0,0,0,0,0, 0,0,0,0,0]
            ]
        self.pb2D = []
        
        
        for i in range(10):
            pb_line = []
            for j in range(10):
                tmp = QPushButton(self)
                tmp.setToolTip(str(i)+","+str(j))
                tmp.setIconSize(QSize(40,40))
                tmp.setGeometry(QRect(40*j,40*i,40,40))
                tmp.setIcon(QtGui.QIcon('0.png'))
                tmp.clicked.connect(self.btnClick)
                pb_line.append(tmp)
            self.pb2D.append(pb_line)
            
        self.pb_reset.clicked.connect(self.myrest)
        self.myrender()    
            
    def myrest(self):
        self.flag_wb = True
        self.flag_ing = True
        
        for i in range(10):
            for j in range(10):
                self.arr2D[i][j] = 0
        self.myrender()        
             
    def myrender(self):
        for i in range(10):
            for j in range(10):
                if self.arr2D[j][i] == 0:
                    self.pb2D[j][i].setIcon(QtGui.QIcon('0.png'))   
                if self.arr2D[j][i] == 1:
                    self.pb2D[j][i].setIcon(QtGui.QIcon('1.png'))   
                if self.arr2D[j][i] == 2:
                    self.pb2D[j][i].setIcon(QtGui.QIcon('2.png'))   
                    
        
    def btnClick(self):
        if not self.flag_ing == True :
            return

        str_ij = self.sender().toolTip()
        arr_ij = str_ij.split(",")
        i = int(arr_ij[0])
        j = int(arr_ij[1])

        if self.arr2D[i][j] > 0:
            return 
        stone = 0
        if self.flag_wb:
            self.arr2D[i][j] = 1
            stone = 1
        else :
            self.arr2D[i][j] = 2
            stone = 2
            
        up = self.getUP(i, j, stone)
        dw = self.getDW(i, j, stone)
        le = self.getLE(i, j, stone)
        ri = self.getRI(i, j, stone)
        
        ur = self.getUR(i, j, stone)
        dl = self.getDL(i, j, stone)
        ul = self.getUL(i, j, stone)
        dr = self.getDR(i, j, stone)
        
        d1 = up + 1 + dw
        d2 = le + 1 + ri
        d3 = ur + 1 + dl
        d4 = ul + 1 + dr
        
        self.myrender()
        
        if d1 == 5 or d2 == 5 or d3 == 5 or d4 == 5 :
            if self.flag_wb :
                QtWidgets.QMessageBox.about(self,"오목","흑돌이 이겼습니다.")
            else :
                QtWidgets.QMessageBox.about(self,"오목","백돌이 이겼습니다.")
            self.flag_ing = False
        
        self.flag_wb = not self.flag_wb
        
    def getUL(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i -= 1
                j -= 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
        
    def getDR(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i += 1
                j += 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
    
    def getDL(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i += 1
                j -= 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt  
        
    def getUR(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i -= 1
                j += 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt    
        
    def getLE(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                j -= 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
    
    def getRI(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                j += 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
            
    def getUP(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i -= 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
        
    def getDW(self,i,j,stone):
        cnt = 0
        try : 
            while True:
                i += 1
                if i < 0 :
                    return cnt
                if j < 0 :
                    return cnt
                if self.arr2D[i][j] == stone :
                    cnt += 1
                else :
                    return cnt
        except :
            return cnt
            

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 