import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import numpy as np
import cv2


#reading in an image
image = mpimg.imread("test_images/solidWhiteRight.jpg")

print ("The image type is", type(image) , "with dimensions" , image.shape)
plt.imshow(image) # if you wanted to show a single color channel image called 'gray', for example, call as plt.imshow(gray, cmap='gray')
plt.show()
## Try to show gray image
plt.imshow(image, cmap='gray')
plt.show()