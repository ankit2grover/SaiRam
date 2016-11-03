#!/usr/bin/python

""" 
    This is the code to accompany the Lesson 1 (Naive Bayes) mini-project. 

    Use a Naive Bayes Classifier to identify emails by their authors
    
    authors and labels:
    Sara has label 0
    Chris has label 1
"""
    
import sys
from time import time
sys.path.append("../tools/")
from email_preprocess import preprocess


### features_train and features_test are the features for the training
### and testing datasets, respectively
### labels_train and labels_test are the corresponding item labels
features_train, features_test, labels_train, labels_test = preprocess()

## Print Train and test data
print "Train data : " , features_train[0]
#print "Test data : " , features_test





#########################################################
### your code goes here ###

## Training classifier
print "Train sample : %s Labels sample : %s" %(features_train[0][0],labels_train[0])

from sklearn.naive_bayes import GaussianNB
gnb = GaussianNB()
train_init_time = time()
gnb = gnb.fit(features_train, labels_train)
print "training time:", round(time()-train_init_time, 3), "s"

## Predicting output
test_init_time = time()
labels_predict = gnb.predict(features_test)
print "testing time:", round(time()-test_init_time, 3), "s"

#Testing accuracy
from sklearn.metrics import accuracy_score
accuracy = accuracy_score(labels_test, labels_predict)

print accuracy


#########################################################


