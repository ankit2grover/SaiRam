#!/usr/bin/python 

""" 
    Skeleton code for k-means clustering mini-project.
"""




import pickle
import numpy
import matplotlib.pyplot as plt
import sys
sys.path.append("../tools/")
from feature_format import featureFormat, targetFeatureSplit
from sklearn import metrics
from sklearn.cluster import KMeans



def Draw(pred, features, poi, mark_poi=False, name="image.png", f1_name="feature 1", f2_name="feature 2"):
    """ some plotting code designed to help you visualize your clusters """

    ### plot each cluster with a different color--add more colors for
    ### drawing more than five clusters
    colors = ["b", "c", "k", "m", "g"]
    for ii, pp in enumerate(pred):
        plt.scatter(features[ii][0], features[ii][1], color = colors[pred[ii]])

    ### if you like, place red stars over points that are POIs (just for funsies)
    if mark_poi:
        for ii, pp in enumerate(pred):
            if poi[ii]:
                plt.scatter(features[ii][0], features[ii][1], color="r", marker="*")
    plt.xlabel(f1_name)
    plt.ylabel(f2_name)
    plt.savefig(name)
    plt.show()



### load in the dict of dicts containing all the data on each person in the dataset
data_dict = pickle.load( open("../final_project/final_project_dataset.pkl", "r") )
### there's an outlier--remove it! 
data_dict.pop("TOTAL", 0)


### the input features we want to use 
### can be any key in the person-level dictionary (salary, director_fees, etc.) 
feature_1 = "salary"
feature_2 = "exercised_stock_options"
feature_3 = "total_payments"
poi  = "poi"
features_list = [poi, feature_1, feature_2]
#features_list = [poi, feature_1, feature_2]
data = featureFormat(data_dict, features_list )
poi, finance_features = targetFeatureSplit( data )
list = [200000, 1000000]

import numpy as np
finance_features.append(np.array(list))
print len(finance_features)
from sklearn.cross_validation import train_test_split
#feature_train, feature_test, target_train, target_test = train_test_split(finance_features, poi, test_size=0.3, random_state=42)
#print len(feature_train)
#print len(feature_test)

### in the "clustering with 3 features" part of the mini-project,
### you'll want to change this line to 
### for f1, f2, _ in finance_features:
### (as it's currently written, the line below assumes 2 features)
from sklearn import preprocessing
min_max_scaler = preprocessing.MinMaxScaler()
min_max_feature_train = min_max_scaler.fit_transform(finance_features)

max_stock  = 0
min_stock = finance_features[0][0]
calc_index = 0
for f1, f2 in finance_features:
    plt.scatter( f1, f2)
    plt.xlabel(feature_1)
    plt.ylabel(feature_2)
    if f2 != 0 and max_stock < f2:
        max_stock = f2
    if f2 != 0 and min_stock > f2:
        min_stock = f2
    elif min_stock == 0:
        min_stock = f2
    elif max_stock == 1000000:
        calc_index = index
        
plt.show()
print "Max stock %f and min stock %f" %(max_stock, min_stock)
print min_max_feature_train[len(min_max_feature_train) -1]

## Scaling features to a range using min max scaler


### cluster here; create predictions of the cluster labels
### for the data and store them to a list called pred
estimator = KMeans(init='k-means++', n_clusters=2, n_init=10)
#estimator = KMeans(init='random', n_clusters=4, n_init=20)
estimator.fit(min_max_feature_train)
pred_train = estimator.predict(min_max_feature_train)
#pred_test = estimator.predict(feature_test)


### rename the "name" parameter when you change the number of features
### so that the figure gets saved to a different file
try:
    Draw(pred_train, min_max_feature_train, poi, mark_poi=False, name="clusters.pdf", f1_name=feature_1, f2_name=feature_2)
except NameError:
    print "no predictions object named pred found, no clusters to plot"

#==============================================================================
# try:
#     #Draw(pred_test, feature_test, poi, mark_poi=False, name="clusters.pdf", f1_name=feature_1, f2_name=feature_2)
# except NameError:
#     print "no predictions object named pred found, no clusters to plot"
# 
#==============================================================================
