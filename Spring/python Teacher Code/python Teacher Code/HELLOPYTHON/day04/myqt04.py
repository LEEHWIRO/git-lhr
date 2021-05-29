import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic

form_class = uic.loadUiType("myqt04.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb.clicked.connect(self.btnClick)
        
        
    def btnClick(self): 
        a = int(self.le1.text())
        b = int(self.le2.text())
        
        sum = 0
        for i in range(a,b+1):
            sum += i
        self.le3.setText(str(sum))
        
        
        
        
        

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
    
    
    
    
    
    
    
 