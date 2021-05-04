from sqlalchemy.sql.expression import false
class Animal:
    def __init__(self):
        self.fullness = 0
    def eat(self):
        self.fullness ++1
    def mantang(self):
        self.fullness = 10
       
class Human(Animal):
    def __init__(self):
        super().__init__()
        self.flag_cook = False
    def goHakwon(self):
        self.flag_cook = True
        
hun = Human()
print(hun.fullness)
print(hun.flag_cook)
hun.mantang()
hun.goHakwon()
print(hun.fullness)
print(hun.flag_cook)


    