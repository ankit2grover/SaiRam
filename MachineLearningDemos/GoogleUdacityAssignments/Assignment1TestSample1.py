# -*- coding: utf-8 -*-
"""
Created on Mon Aug  8 01:45:36 2016

@author: tkmaea9
"""

from IPython.display import Image
import matplotlib.pyplot as plt
import pickle
import Assignment1
import MNielsenNeuralNetwork
from sklearn import datasets, neighbors, linear_model

#print(train_dataset[0])
new_train_dataset = train_dataset[0:50]
new_train_labels = train_labels[0:50]
new_test_dataset = test_dataset[0:50]
new_test_labels = test_labels[0:50]

logistic = linear_model.LogisticRegression()
logistic = logistic.fit(new_train_dataset, new_train_labels)
    
#net = MNielsenNeuralNetwork.MNielsenNeuralNetwork([784, 30, 10])
#net.SGD(train_form_dataset, 30, 3, 3.0, test_data = test_form_dataset)
#Image(filename='notMNIST_large/A/a2F6b28udHRm.png')