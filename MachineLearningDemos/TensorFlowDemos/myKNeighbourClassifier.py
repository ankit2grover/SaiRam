# -*- coding: utf-8 -*-
"""
Created on Mon Jun 13 13:57:06 2016

@author: tkmaea9
"""
import random
from scipy.spatial import distance

class MyKNeighborClf:
    
    def euc(self, a, b):
        return distance.euclidean(a, b)
        
    def fit(self, X_train, Y_train):
        self.X_train = X_train
        self.Y_train = Y_train
        return self
    
    def predict(self, X_test):
        predictions = []
        for row in X_test:
            #label = random.choice(self.Y_train)
            label = self.closest(row)
            predictions.append(label)
        return predictions
        
    def closest (self, test_row):
        short_dist = self.euc(test_row, self.X_train[0])
        short_dist_index = 0
        #print "short_dist" + "% .2f" %(short_dist)
        for index  in range(1, len(self.X_train)):
            dist = self.euc(test_row, self.X_train[index])
            #print "dist" + "% .2f" %(dist)
            if dist < short_dist:
                short_dist = dist
                short_dist_index = index
        
        return self.Y_train[short_dist_index]
        

from sklearn import datasets
from sklearn.cross_validation import train_test_split
from sklearn import tree
from sklearn.metrics import accuracy_score
from sklearn.neighbors import KNeighborsClassifier

iris = datasets.load_iris()

X = iris.data
Y = iris.target


X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.5)

#clf = tree.DecisionTreeClassifier()
#clf = KNeighborsClassifier()
clf = MyKNeighborClf()
clf = clf.fit(X_train, Y_train)
Y_Predict = clf.predict(X_test)

accuracy = accuracy_score(Y_test, Y_Predict)

print accuracy