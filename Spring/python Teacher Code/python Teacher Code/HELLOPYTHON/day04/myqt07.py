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
        mine = self.le1.text()
        com = random.randrange(1,4)

        if com == 1 :
            if mine == "가위":
                self.le_result.setText("무승부")
            elif mine == "바위":
                self.le_result.setText("성공")
            else : 
                self.le_result.setText("실패")
            self.le2.setText("가위")
        elif com == 2 :
            if mine == "바위":
                self.le_result.setText("무승부")
            elif mine == "보":
                self.le_result.setText("성공")
            else : 
                self.le_result.setText("실패")
            self.le2.setText("바위")
        else :
            if mine == "보":
                self.le_result.setText("무승부")
            elif mine == "가위":
                self.le_result.setText("성공")
            else : 
                self.le_result.setText("실패")        
            self.le2.setText("보")
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
    