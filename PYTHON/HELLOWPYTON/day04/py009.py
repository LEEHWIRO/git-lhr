import sys
from PyQt5.QtWidgets import QApplication, QWidget, QMainWindow
from PyQt5 import uic
from PyQt5.Qt import QMessageBox

form_class = uic.loadUiType("myqt09.ui")[0]


class WindowClass(QMainWindow, form_class):

    def __init__(self):
        super().__init__()
        self.setupUi(self)
        self.pb0.clicked.connect(self.btnClick0)
        self.pb1.clicked.connect(self.btnClick1)
        self.pb2.clicked.connect(self.btnClick2)
        self.pb3.clicked.connect(self.btnClick3)
        self.pb4.clicked.connect(self.btnClick4)
        self.pb5.clicked.connect(self.btnClick5)
        self.pb6.clicked.connect(self.btnClick6)
        self.pb7.clicked.connect(self.btnClick7)
        self.pb8.clicked.connect(self.btnClick8)
        self.pb9.clicked.connect(self.btnClick9)
        self.pbCall.clicked.connect(self.btnClickCall)
        
    def btnClick0(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"0")
        
    def btnClick1(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"1")
        
    def btnClick2(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"2")
        
    def btnClick3(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"3")
        
    def btnClick4(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"4")
        
    def btnClick5(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"5")
        
    def btnClick6(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"6")
        
    def btnClick7(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"7")
        
    def btnClick8(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"8")
        
    def btnClick9(self):
        str_old = self.lin.text()
        self.lin.setText(str_old+"9")
        
    def btnClickCall(self):
        a = self.lin.text()
        QMessageBox.question(self.window(), 'message', a + '로 전화거시겠습니까?', QMessageBox.Yes, QMessageBox.NoButton)
        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWindow = WindowClass()
    myWindow.show()
    sys.exit(app.exec_())
 