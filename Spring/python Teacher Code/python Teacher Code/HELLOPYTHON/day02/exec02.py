a = int(input('첫 숫자를 입력하세요'))
b = int(input('끝 숫자를 입력하세요'))


arr = range(a,b+1)

sum = 0
for i in arr:
    sum += i

print("숫자의 합은 {}입니다.".format(sum))
