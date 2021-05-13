import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
import random

form_class = uic.loadUiType("myqt07.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.btnClick)
        
        
    def btnClick(self):
        mine = self.lin1.text()
        com = ""
        result = ""
        rand = random.random()
        if rand < 0.33 :
            com = "가위"
        elif rand >= 0.33 and rand < 0.66 :
            com = "바위"
        else :
            com = "보"
        
        if mine == com :
            result = "비김"
        elif mine == "가위" and com == "바위":
            result = "짐"
        elif mine == "보" and com == "가위":
            result = "짐"
        elif mine == "바위" and com == "보":
            result = "짐"
        elif mine == "가위" and com == "보":
            result = "이김"
        elif mine == "보" and com == "바위":
            result = "이김"
        elif mine == "바위" and com == "가위":
            result = "이김" 
        
        self.lin2.setText(com)
        self.lin3.setText(result)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 