import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
import random

form_class = uic.loadUiType("myqt06.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.btnClick)
        
        
    def btnClick(self): 
        n1 = int(self.le1.text())
        n2 = int(self.le2.text())
        print(1)
        arr2 = range(n1, n2 + 1)
        print(2)
        sum = 0
        for arr in arr2:
            if arr % 2 == 0:
                sum += arr
                        
        self.le_result.setText(str(sum))

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
    
    
    
    
    
    
    
 