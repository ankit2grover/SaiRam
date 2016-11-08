#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 27 01:47:47 2016

@author: tkmaea9
"""
from six.moves import cPickle as pickle
from sklearn import linear_model
# Standard scientific Python imports
import matplotlib.pyplot as plt
from sklearn.metrics import accuracy_score

pickle_file = 'notMNIST.pickle'

try:
    with open(pickle_file, 'rb') as f:
        data = pickle.load(f)
        train_dataset = data['train_dataset']
        train_labels = data['train_labels']
        valid_dataset = data['valid_dataset']
        valid_labels = data['valid_labels']
        test_dataset = data['test_dataset']
        test_labels = data['test_labels']
    
    #print (train_dataset[0])
    #print (train_dataset[0].shape)
    images_and_labels = list(zip(train_dataset, train_labels))
    for index, (image, label) in enumerate(images_and_labels[:10]):
        plt.subplot(2, 10, index + 1)
        plt.axis('off')
        plt.imshow(image, cmap=plt.cm.gray_r, interpolation='nearest')
        #plt.title('Training: %i' % label)
        
    train_data_list = list(train_dataset)
    train_samples = len(train_data_list)
    ## Flatten the data in samples, features
    train_new_dataset = train_dataset.reshape(train_samples, -1)
    #train_new_dataset = train_new_dataset[:100]
    #print images_and_labels[0]
    train_new_dataset = train_new_dataset[:200, :]
    train_labels = train_labels[:200]
    logistic = linear_model.LogisticRegression(C=1e5)
    logistic = logistic.fit(train_new_dataset, train_labels)
    
    valid_data_list = list(valid_dataset)
    valid_samples = len(valid_data_list)
    valid_dataset = valid_dataset.reshape(valid_samples, -1)
    valid_dataset = valid_dataset[:100, :]
    valid_labels = valid_labels[:100]
    valid_predict_labels = logistic.predict(valid_dataset)
    acc = accuracy_score(valid_labels, valid_predict_labels)
    print (acc)
    
except Exception as e:
    print('Unable to read data from ', pickle_file, ':', e)
    raise