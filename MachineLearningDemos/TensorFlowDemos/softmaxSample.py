# -*- coding: utf-8 -*-
"""
Created on Sat Jul 30 13:41:16 2016

@author: tkmaea9
"""
import numpy as np
scores = [3.0, 1.0, 0.2]

def softmax(x):
    x = x / 10
    return np.exp(x) / np.sum(np.exp(x), axis = 0)

softmax(scores)

x = np.arange(-2.0, 6.0, 0.2)
x_one = np.ones_like(x)
x_one2 = np.ones_like(x) * 0.2
stackX = np.vstack([x, x_one, x_one2])
#print(stackX.shape)
y_soft = softmax(stackX)

import matplotlib.pyplot as plt
plt.plot(x, y_soft.T, linewidth=2)
    
