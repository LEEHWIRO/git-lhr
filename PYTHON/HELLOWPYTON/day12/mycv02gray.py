import cv2
 
img = cv2.imread('pack1.jpg', 1)
img2 = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
 
cv2.imshow('Test Image', img2)
cv2.waitKey(0)
cv2.destroyAllWindows()
 
