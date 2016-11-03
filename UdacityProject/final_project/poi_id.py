#!/usr/bin/python

import sys
import pickle
sys.path.append("../tools/")

from feature_format import featureFormat, targetFeatureSplit
from tester import dump_classifier_and_data

### Task 1: Select what features you'll use.
### features_list is a list of strings, each of which is a feature name.
### The first feature must be "poi".

#Try other features options : total_payments, total_stock_value, restricted_stock, fraction_from_poi,shared_receipt_with_poi, expenses, shared_receipt_with_poi
#features_list = ['poi', 'salary', 'bonus', 'fraction_from_poi', 'fraction_to_poi', 'total_payments', 'long_term_incentive', 'total_stock_value']
features_list = ['poi', 'salary', 'bonus', 'fraction_to_poi', 'long_term_incentive', 'other', 'exercised_stock_options']

### Load the dictionary containing the dataset
with open("final_project_dataset.pkl", "r") as data_file:
    data_dict = pickle.load(data_file)
    

### Task 2: Remove outliers
data_dict.pop("TOTAL", 0 )
#data_dict.pop("FREVERT MARK A",0)

# Try with some more outliers also
#data_dict.pop("LAY KENNETH L",0)
#data_dict.pop("SKILLING JEFFREY K",0)
#data_dict.pop("LAVORATO JOHN J",0)
#data_dict.pop("FREVERT MARK A", 0 )


## Compute fraction between poi_messages and all_messages
def computeFraction( poi_messages, all_messages ):
    """ given a number messages to/from POI (numerator) 
        and number of all messages to/from a person (denominator),
        return the fraction of messages to/from that person
        that are from/to a POI
   """
    fraction = 0.
    if  poi_messages == 'NaN' or  all_messages == 'NaN':
        fraction = 0.0
    else:
        fraction = float(float(poi_messages) / float(all_messages))
    return fraction


### Task 3: Create new feature(s)
## Set two new features fraction_from_poi and fraction_to_poi
## As per intutiion both new featues will help in identifying correct POI
def addNewFeature(data_dict):
    for name in data_dict:        
        data_point = data_dict[name]
        from_poi_to_this_person = data_point["from_poi_to_this_person"]
        to_messages = data_point["to_messages"]
        fraction_from_poi = computeFraction( from_poi_to_this_person, to_messages )
        data_point["fraction_from_poi"] = fraction_from_poi
        from_this_person_to_poi = data_point['from_this_person_to_poi']
        from_messages = data_point['from_messages']
        fraction_to_poi = computeFraction( from_this_person_to_poi, from_messages )
        data_point["fraction_to_poi"] = fraction_to_poi
        



    
        
addNewFeature(data_dict)


### Store to my_dataset for easy export below.
my_dataset = data_dict

### Extract features and labels from dataset for local testing
#data = featureFormat(my_dataset, features_list, sort_keys = True)
data, keys_list = featureFormat(my_dataset, features_list)
labels, features = targetFeatureSplit(data)



### Task 4: Try a varity of classifiers
### Please name your classifier clf for easy export below.
### Note that if you want to do PCA or other multi-stage operations,
### you'll need to use Pipelines. For more info:
### http://scikit-learn.org/stable/modules/pipeline.html

# Provided to give you a starting point. Try a variety of classifiers.

# Try Naive Bayes
#from sklearn.naive_bayes import GaussianNB
#clf = GaussianNB()

#from sklearn.svm import SVC
# SVM using Grid SearchCV with best params
#param_grid = {
         #'C': [1e3, 5e3, 1e4, 5e4, 1e5],
          #'gamma': [0.0001, 0.0005, 0.001, 0.005, 0.01, 0.1],
          #}
#clf = GridSearchCV(SVC(kernel='rbf', class_weight='auto'), param_grid)

from sklearn.decomposition import PCA
from sklearn.pipeline import Pipeline
# Random Forest classifier
from sklearn.ensemble import RandomForestClassifier
# for sklearn version 0.16 or prior, the class_weight parameter value is 'auto'
from sklearn.grid_search import GridSearchCV
from sklearn.feature_selection import SelectPercentile, SelectKBest, f_classif
from sklearn.svm import SVC


K_BEST = [2,3,4,5,6]
N_FEATURES_OPTIONS = [2, 4, 5, 6]

# Reduce dimensionality either using Kbest, percentile or PCA and estimate with SVM 
def pcaAndSVCPipe():
    # Define pipeline with PCA as feature selection and classifier
    pipe = Pipeline([
        #('reduce_dim', SelectPercentile(f_classif)),
        ('reduce_dim', SelectKBest(f_classif)),
        #('reduce_dim', PCA()),
        ('classify', SVC(kernel='linear', class_weight='auto'))
        #('classify', LinearSVC())
    ])
    
    
    param_grid = [
        {        
            #'reduce_dim__n_components': N_FEATURES_OPTIONS,
            #'reduce_dim__percentile': [10,20,30,40,50, 60, 70, 80, 90, 100],
            'reduce_dim__k': K_BEST,
            'classify__C':[10, 1e2, 1e3, 5e3, 1e4, 5e4, 1e5], 
            'classify__gamma': [0.0001, 0.0005, 0.001, 0.005, 0.01, 0.1]
        },
    ]
    return pipe, param_grid

# Reduce dimensionality either using Kbest, percentile or PCA and estimate with Random Forest 
def pcaAndRandomForestPipe():
    pipe = Pipeline([
        #('reduce_dim', SelectPercentile(f_classif)),
        #('reduce_dim', PCA()),
        ('reduce_dim', SelectKBest(f_classif)),
        ('classify', RandomForestClassifier())
        #('classify', RandomForestClassifier())
    ])
    
    
    param_grid = [
        {
            #'reduce_dim__n_components': N_FEATURES_OPTIONS,
            #'reduce_dim__percentile': [10,20,30,40,50, 60, 70, 80, 90, 100],
            'reduce_dim__k': K_BEST,
            'classify__n_estimators':[5,10,20,30,40,50], 
            'classify__criterion':['gini', 'entropy'],
            'classify__min_samples_split': [5,10,15,20,25,30]
        }
    ]
    return pipe, param_grid

## Call pipeline with feature selection and estimator
pipe, param_grid = pcaAndRandomForestPipe()
#pipe, param_grid = pcaAndSVCPipe()

## Add pipeline in grid search algorithm for giving best cross_val_score output.
clf = GridSearchCV(pipe, param_grid = param_grid)


## Calculate accuracy, precision and recall
def evaluateModel(labels_test, labels_predict):
    ##Evaluate accuracy of your model
    from sklearn.metrics import accuracy_score
    from sklearn.metrics import f1_score
    print "Accuracy is %f" %accuracy_score(labels_test, labels_predict)

    from sklearn.metrics import precision_score
    from sklearn.metrics import recall_score

    precision = float(precision_score(labels_test, labels_predict))
    recall = float(recall_score(labels_test, labels_predict))
    f1_score = float(f1_score(labels_test, labels_predict))    
    
    print "Precision score %f , recall score %f and f1_score %f" %(precision, recall,f1_score)

### Task 5: Tune your classifier to achieve better than .3 precision and recall 
### using our testing script. Check the tester.py script in the final project
### folder for details on the evaluation method, especially the test_classifier
### function. Because of the small size of the dataset, the script uses
### stratified shuffle split cross validation. For more info: 
### http://scikit-learn.org/stable/modules/generated/sklearn.cross_validation.StratifiedShuffleSplit.html

# Example starting point. Try investigating other evaluation techniques!
from sklearn.cross_validation import train_test_split
features_train, features_test, labels_train, labels_test = train_test_split(features, labels, test_size=0.3, random_state=42)
clf = clf.fit(features, labels)
labels_predict = clf.predict(features_test)
#evaluateModel(labels_test, labels_predict)

print clf.best_estimator_


## Evaluate final model using KFold split algorithm.
def trainAndEvaluateUsingKFold():
    from sklearn.model_selection import KFold
    kf = KFold(n_splits=4)
    
    for train_indices, test_indices in kf.split(features):
        features_train = []
        labels_train = []
        features_test = []
        labels_test = []
        ## Train model features and labels
        for train_index in train_indices:
            features_train.append(features[train_index])
            labels_train.append(labels[train_index])
        ## Test model features and labels
        for test_index in test_indices:        
            features_test.append(features[test_index])
            labels_test.append(labels[test_index])
            
        #clf = clf.fit(features_train, labels_train)
        #featureSelection(clf, features_train, labels_train)
        labels_predict = clf.predict(features_test)
        evaluateModel(labels_test, labels_predict)
        #for prediction, truth in zip(labels_predict, labels_test):
            #print "Prediction is %d and truth is %d" %(prediction, truth)
        
        #Estimate params of GridSearchCV
        #print clf.best_estimator_
    



trainAndEvaluateUsingKFold()

### Task 6: Dump your classifier, dataset, and features_list so anyone can
### check your results. You do not need to change anything below, but make sure
### that the version of poi_id.py that you submit can be run on its own and
### generates the necessary .pkl files for validating your results.

dump_classifier_and_data(clf, my_dataset, features_list)



### Miscellanous functions during practise
    
def featureSelection(clf, features, labels):
    from sklearn.feature_selection import SelectPercentile
    selector = SelectPercentile(clf, percentile=50)
    selector.fit(features, labels)
    
## Visualize dataset
def visualize():
    import matplotlib.pyplot as plt
    for name in data_dict: 
        data_point = data_dict[name]
        x_vector = data_point['shared_receipt_with_poi']
        y_vector = data_point['poi']
        if (x_vector == 'NaN'):
            x_vector = 0
        if (y_vector == 'NaN'):
            y_vector = 0
        x_vector = float(x_vector)
        y_vector = float(y_vector)
        if (x_vector > 20000000):
            print "Name is %s" %name
        plt.scatter(x_vector, y_vector, color ="blue")
    plt.xlabel("Feature")
    plt.ylabel("POI")
    plt.show() 
    