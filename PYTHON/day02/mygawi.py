import random

mine = input("가위/바위/보 선택하세요")
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
    
print("com " ,com)
print("mine " ,mine)
print("result " ,result)

