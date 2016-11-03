#!/usr/bin/python


"""
    Starter code for the validation mini-project.
    The first step toward building your POI identifier!

    Start by loading/formatting the data

    After that, it's not our code anymore--it's yours!
"""

import pickle
import sys
sys.path.append("../tools/")
from feature_format import featureFormat, targetFeatureSplit

data_dict = pickle.load(open("../final_project/final_project_dataset.pkl", "r") )

### first element is our labels, any added elements are predictor
### features. Keep this the same for the mini-project, but you'll
### have a different feature list when you do the final project.
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
