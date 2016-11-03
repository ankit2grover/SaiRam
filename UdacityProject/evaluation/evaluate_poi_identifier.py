#!/usr/bin/python


"""
    Starter code for the evaluation mini-project.
    Start by copying your trained/tested POI identifier from
    that which you built in the validation mini-project.

    This is the second step toward building your POI identifier!

    Start by loading/formatting the data...
"""

import pickle
import sys
sys.path.append("../tools/")
from feature_format import featureFormat, targetFeatureSplit

data_dict = pickle.load(open("../final_project/final_project_dataset.pkl", "r") )

### add more features to features_list!
features_list = ["poi", "salary"]

data = featureFormat(data_dict, features_list)
labels, features = targetFeatureSplit(data)



def visualize_data(X, y):
    ## Visualize the data
    import matplotlib.pyplot as plt
    try:
        plt.scatter(X, y, color ="blue")
    except NameError:
        pass
    plt.xlabel('Salary')
    plt.ylabel('Poi')
    plt.show()

### it's all yours from here forward!  

### training-testing split
from sklearn.cross_validation import train_test_split
feature_train, feature_test, labels_train, labels_test = train_test_split(features, labels, test_size=0.3, random_state=0)

visualize_data(feature_test, labels_test)

## Classifier
from sklearn import tree
clf = tree.DecisionTreeClassifier(criterion='gini', min_samples_split=2)
clf = clf.fit(feature_train, labels_train)
labels_predict = clf.predict(feature_test)

visualize_data(feature_test, labels_predict)

## Accuracy
from sklearn.metrics import accuracy_score
accuracy = accuracy_score(labels_predict, labels_test)
print accuracy

predict_count = 0
actual_count = 0
for i in range(len(labels_predict)):
    if labels_predict[i] == 0:
        predict_count += 1
    if labels_test[i] == 0:
        actual_count +=1

## Count of POI predicted as 0 and actual 0 
print "Predict %d, Actual %d" %(predict_count, actual_count)

## Calculate precision and recall
from sklearn.metrics import precision_score
from sklearn.metrics import recall_score

precision = float(precision_score(labels_test, labels_predict))
recall = float(recall_score(labels_test, labels_predict))

print "Precision score %f and recall score %f" %(precision, recall)