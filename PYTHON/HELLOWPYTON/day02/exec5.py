#5
first = int(input("첫번째 숫자를 입력하시오"))
secon = int(input("두번째 숫자를 입력하시오"))
result = 0

arr = range(first, secon+1)

for i in arr :
    if i % 2 == 1 :
        result += i
print("모든 홀수의 합은" + str(result) + "입니다.")