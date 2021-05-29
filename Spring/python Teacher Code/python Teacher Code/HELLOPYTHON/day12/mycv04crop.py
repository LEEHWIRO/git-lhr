import cv2

img = cv2.imread('iu.jpg', cv2.IMREAD_GRAYSCALE)

img_crop = img[10:180,150:350]


cv2.imshow('Test Image', img_crop)
cv2.imwrite('ui.jpg', img_crop)


cv2.waitKey(0)
cv2.destroyAllWindows()
 
