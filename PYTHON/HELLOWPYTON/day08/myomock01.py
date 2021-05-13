import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
from PyQt5 import QtGui
from PyQt5.Qt import QPushButton, QSize, QRect
from astropy.time.utils import split

form_class = uic.loadUiType("my0mock01.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.index = 1
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
        str_ij = self.sender().toolTip()
        arr_ij = str_ij.split(",")
        i = int(arr_ij[0])
        j = int(arr_ij[1])
        
        if self.arr2D[i][j] == 0 :
            self.index += 1
            loc_index = self.index % 2 +1
            self.arr2D[i][j] = loc_index
            
            self.myrender()
        #elif self.arr2D[i][j] == 1 or self.arr2D[i][j] == 2 :
         #   return
        else:
            return
            
        

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 