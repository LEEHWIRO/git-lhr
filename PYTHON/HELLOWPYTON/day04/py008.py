import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
import random

form_class = uic.loadUiType("myqt08.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.btnClick)
        
        
    def btnClick(self):
        a = int(self.lin1.text())
        re = ""
        for i in range(1, 10):
            re += str(a) + "*" + str(i) + "=" + str(a*i) + "\n"
            
        print(re)   
        self.ta.setText(str(re))
if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 