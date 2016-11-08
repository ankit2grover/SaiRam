# -*- coding: utf-8 -*-
"""
Created on Wed Jun  8 14:50:30 2016

@author: tkmaea9
"""

import sklearn.datasets
import numpy as np
from sklearn import tree
from sklearn.externals.six import StringIO
import pydot
from IPython.display import Image

iris = sklearn.datasets.load_iris()
#print iris.feature_names
#print iris.target_names
#print iris.data
#print iris.target

test_idx = [0, 40, 80, 120]

train_target = np.delete(iris.target, test_idx, axis = 0)
train_data = np.delete(iris.data, test_idx, axis = 0)

#print (len(train_data))

test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

#print (test_data)
clf = tree.DecisionTreeClassifier()
clf = clf.fit(train_data, train_target)

print test_target
print (clf.predict(test_data))

dot_data = StringIO()
tree.export_graphviz(clf, out_file=dot_data)
graph = pydot.graph_from_dot_data(dot_data.getvalue())
#graph.write_pdf("iris.pdf") 

#Image(graph.create_png())  



"""

tree.export_graphviz(clf, out_file=dot_data,  
                         feature_names=iris.feature_names,  
                         class_names=iris.target_names,  
                         filled=True, rounded=True,  
                         special_characters=True)

with open("iris.dot", 'w') as f:
    f = tree.export_graphviz(clf, out_file=f)

for i in range(len(iris.target)):
    print "Example %d: label %s: feature %s: " % (i, iris.target[i], iris.data[i])

"""

