class JindoDog:
    def __init__(self):
        self.power_bark = 0
    
    def train(self):
        self.power_bark += 1
    
class SokchoBird():
    def __init__(self):
        self.flag_fly = False
    
    def practice(self):
        self.flag_fly = True

class BirdDog(JindoDog, SokchoBird):
    def __init__(self):
        JindoDog.__init__(self)
        SokchoBird.__init__(self)
        
bd = BirdDog()    
print(bd.power_bark)
print(bd.flag_fly)
bd.train()
print(bd.power_bark)
print(bd.flag_fly)
bd.practice()    
print(bd.power_bark)
print(bd.flag_fly)