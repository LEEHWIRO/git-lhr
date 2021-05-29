import sys
from PyQt5.QtWidgets import *
from PyQt5 import uic

form_class = uic.loadUiType("myqt09.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb1.clicked.connect(self.btnClick1)
        self.pb2.clicked.connect(self.btnClick2)
        self.pb3.clicked.connect(self.btnClick3)
        self.pb4.clicked.connect(self.btnClick4)
        self.pb5.clicked.connect(self.btnClick5)
        self.pb6.clicked.connect(self.btnClick6)
        self.pb7.clicked.connect(self.btnClick7)
        self.pb8.clicked.connect(self.btnClick8)
        self.pb9.clicked.connect(self.btnClick9)
        self.pb0.clicked.connect(self.btnClick0)
        self.pbcall.clicked.connect(self.btnClickCall)
        
        
    def btnClick1(self): 
        str_new = self.pb1.text()
        self.leInputText(str_new)
    def btnClick2(self): 
        str_new = self.pb2.text()
        self.leInputText(str_new)
    def btnClick3(self): 
        str_new = self.pb3.text()
        self.leInputText(str_new)
    def btnClick4(self): 
        str_new = self.pb4.text()
        self.leInputText(str_new)
    def btnClick5(self): 
        str_new = self.pb5.text()
        self.leInputText(str_new)
    def btnClick6(self): 
        str_new = self.pb6.text()
        self.leInputText(str_new)
    def btnClick7(self): 
        str_new = self.pb7.text()
        self.leInputText(str_new)
    def btnClick8(self): 
        str_new = self.pb8.text()
        self.leInputText(str_new)
    def btnClick9(self): 
        str_new = self.pb9.text()
        self.leInputText(str_new)
    def btnClick0(self): 
        str_new = self.pb0.text()
        self.leInputText(str_new)
    def btnClickCall(self): 
        print("call")
        result = self.le.text()
        
        self.msg = QMessageBox()
        self.msg.setIcon(QMessageBox.Information)
        self.msg.setWindowTitle('MessageBox Test')
        self.msg.setText(result)
        
        retval = self.msg.exec_()
        
    def leInputText(self, str_new):
        str_old = self.le.text()
        result = str_old + str_new
        
        self.le.setText(result)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 