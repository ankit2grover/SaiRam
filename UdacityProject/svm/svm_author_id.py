#!/usr/bin/python

""" 
    This is the code to accompany the Lesson 2 (SVM) mini-project.

    Use a SVM to identify emails from the Enron corpus by their authors:    
    Sara has label 0
    Chris has label 1
"""
    
import sys
from time import time
sys.path.append("../tools/")
from email_preprocess import preprocess
from sklearn import svm


### features_train and features_test are the features for the training
### and testing datasets, respectively
### labels_train and labels_test are the corresponding item labels
features_train, features_test, labels_train, labels_test = preprocess()

features_train = features_train[: len(features_train)/100]
labels_train = labels_train[: len(labels_train)/100]

clf = svm.SVC(kernel='rbf', C = 10000)
train_init_time = time()
clf = clf.fit(features_train, labels_train)

## Training time
print time() - train_init_time

predict_init_time = time()
labels_predict = clf.predict(features_test[100])


# Predict time
print time() - predict_init_time

from sklearn.metrics import accuracy_score
accuracy = accuracy_score(labels_predict, labels_test)

print accuracy




