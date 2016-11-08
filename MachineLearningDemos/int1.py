# -*- coding: utf-8 -*-
"""
Created on Mon Feb 15 22:21:26 2016

@author: tkmaea9
"""

myList = [1,2,3,4,5,6,7]
k = 3
l = len(myList)


def rotate(index):
    y = 0
    if (index < k):
        y = myList[6 - index]
        rotate(index +1)
        
    if (y != 0):    
        print(y)
        
        
        
rotate(0)
z = l -k
for i in range (0, z):
    print(myList[i])
        