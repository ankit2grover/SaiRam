# -*- coding: utf-8 -*-
"""
Created on Mon Feb 15 09:25:18 2016

@author: tkmaea9
"""

import numpy as np
from scipy import optimize
from __future__ import division
import sklearn.datasets as datasets
from sklearn import cross_validation



def tanh(x):
    return np.tanh(x)

def tanh_deriv(x):
    return 1.0 - np.tanh(x)**2

def logistic(x):
    return 1/(1 + np.exp(-x))

def logistic_derivative(x):
    return logistic(x)*(1-logistic(x))
    
class NeuralNetwork:
    def __init__(self, layers, activation='tanh'): 
        if activation == 'logistics'
            self.activation = logistic
            self.activation_deriv = logistic_derivative
        else if activation = 'tanh'
            self.activation = tanh
            self.activation_deriv = tanh_deriv
            
        self.weights = []
        for i in range[0, len(layers) -1]:
            self.weights[i] =  ((2* np.random.random((layers[i] + 1, layers[i]))) -1) * 0.25
            
def fit(self, X, y, learning_rate=0.2, epochs=10000):
    
