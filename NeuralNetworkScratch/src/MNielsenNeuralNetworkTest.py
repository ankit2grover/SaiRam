# -*- coding: utf-8 -*-
"""
Created on Sun Jul 10 01:42:20 2016

@author: tkmaea9
"""

import mnist_loader
import MNielsenNeuralNetwork
import network

training_data, validation_data, test_data = mnist_loader.load_data_wrapper()

print len(training_data)

#print training_data[1]
net = MNielsenNeuralNetwork.MNielsenNeuralNetwork([784, 30, 10])
#net = network.Network([784, 30, 10])
net.SGD(training_data, 30, 5, 3.0, test_data = test_data)
#print training_data

#network = MNielsenNeuralNetwork.Network([])