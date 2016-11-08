# -*- coding: utf-8 -*-
"""
Created on Wed Jun  8 13:03:03 2016

@author: tkmaea9
"""

import sklearn
from sklearn import tree
features = [[150, 0], [170, 0], [140, 1], [130, 1]]
labels = [10, 10, 11, 11]
decTreeClf = tree.DecisionTreeClassifier()
decTreeClf = decTreeClf.fit(features, labels)
print decTreeClf.predict([[90, 1]])