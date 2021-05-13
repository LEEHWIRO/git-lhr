import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
import random

form_class = uic.loadUiType("myqt05.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.btnClick)
        
        
    def btnClick(self):
        a = self.lin1.text()
        b = ""
        c = ""
        rand = random.random()
        if rand < 0.5 :
            b = "홀"
        else :
            b = "짝"
        
        if a == b :
            c = "이김"
        else:
            c = "짐"  
        
        self.lin2.setText(b)
        self.lin3.setText(c)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 