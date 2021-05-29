import cv2

img = cv2.imread('iu.jpg', cv2.IMREAD_COLOR)

print(img)
 
cv2.imshow('Test Image', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
 
