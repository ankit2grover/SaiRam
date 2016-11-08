# -*- coding: utf-8 -*-
"""
Created on Wed Jan  6 23:10:51 2016

@author: tkmaea9
"""
# Package imports
import matplotlib.pyplot as plt
import numpy as np
import sklearn
import sklearn.datasets
import sklearn.linear_model
import matplotlib

# Display plots inline and change default figure size
#matplotlib inline
matplotlib.rcParams['figure.figsize'] = (10.0, 8.0)

np.random.seed(0)
X, y = sklearn.datasets.make_moons(200, 0.50)
plt.scatter(X[:,0], X[:,1], s = 40, c=y, cmap = plt.cm.spring)
