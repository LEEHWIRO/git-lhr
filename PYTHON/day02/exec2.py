#2
first = int(input("첫번째 숫자를 입력하시오"))
secon = int(input("두번째 숫자를 입력하시오"))
result = 0

arr = range(first, secon+1)

for i in arr :
    result += i

print("모든 숫자의 합은" + str(result) + "입니다.")