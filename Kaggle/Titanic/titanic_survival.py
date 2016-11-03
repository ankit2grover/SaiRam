#!/usr/bin/python
import sys
from dataProcessing import dataPreProcessingTrain, dataPreProcessingTest

from feature_format import targetFeatureSplit
from sklearn.decomposition import PCA
from sklearn.pipeline import Pipeline
# Random Forest classifier
from sklearn.ensemble import RandomForestClassifier

from sklearn.grid_search import GridSearchCV
from sklearn.feature_selection import SelectPercentile, SelectKBest, f_classif
from sklearn.svm import SVC
from sklearn.cross_validation import train_test_split
from sklearn.model_selection import KFold
from sklearn.ensemble import AdaBoostClassifier
import pandas as pd




### Extract train data from CVS file and separate label and feature
data_train = dataPreProcessingTrain()
labels_df_train, features_df_train = targetFeatureSplit(data_train)

### Extract test data from CVS file and separate label and feature
data_test = dataPreProcessingTest()




K_BEST = [2,3,4,5]
N_FEATURES_OPTIONS = [2, 4, 5, 6, 7]

def bestEstimatorEvaluation():
    #pca_estimator = SelectKBest(f_classif, k=6)
    #new_features = pca_estimator.fit_transform(features_df_train, labels_df_train)
    #print pca_estimator.scores_
    clf_estimator = RandomForestClassifier(criterion='entropy',n_estimators = 30, min_samples_split = 10)
    clf_estimator = clf_estimator.fit(features_df_train, labels_df_train)
    print clf_estimator.feature_importances_
    return clf_estimator

# Reduce dimensionality either using Kbest, percentile or PCA and estimate with SVM 
def pcaAndSVCPipe():
    # Define pipeline with PCA as feature selection and classifier
    pipe = Pipeline([
        #('reduce_dim', SelectPercentile(f_classif)),
        ('reduce_dim', SelectKBest(f_classif)),
        #('reduce_dim', PCA()),
        ('classify', SVC(kernel='rbf', class_weight='balanced'))
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
        #('reduce_dim', SelectKBest(f_classif)),
        ('classify', RandomForestClassifier())
        #('classify', RandomForestClassifier())
    ])
    
    
    param_grid = [
        {
            #'reduce_dim__n_components': N_FEATURES_OPTIONS,
            #'reduce_dim__percentile': [10,20,30,40,50, 60, 70, 80, 90, 100],
            #'reduce_dim__k': K_BEST,
            'classify__n_estimators':[5,10,20,30,40,50], 
            'classify__criterion':['gini', 'entropy'],
            'classify__min_samples_split': [5,10,15,20,25,30,50,80,100]
        }
    ]
    return pipe, param_grid
    
def pcaAndAdaBoost():
    pipe = Pipeline([
        #('reduce_dim', SelectKBest(f_classif)),
        ('classify', AdaBoostClassifier())
    ])
    
    
    param_grid = [
        {
            #'reduce_dim__k': K_BEST,
            'classify__n_estimators':[50,80,100, 120, 150]
        }
    ]
    return pipe, param_grid

## Call pipeline with feature selection and estimator
pipe, param_grid = pcaAndRandomForestPipe()
#pipe, param_grid = pcaAndSVCPipe()
#pipe, param_grid = pcaAndAdaBoost()

## Add pipeline in grid search algorithm for giving best cross_val_score output.

clf = GridSearchCV(pipe, param_grid = param_grid)
clf = clf.fit(features_df_train, labels_df_train)

# Evaluation of best estimator
#clf = bestEstimatorEvaluation()


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


def trainAndEvaluateUsingCrossVal():
    features_train, features_test, labels_train, labels_test = train_test_split(features_df_train, labels_df_train, test_size=0.2, random_state=42)
    labels_predict = clf.predict(features_test)
    evaluateModel(labels_test, labels_predict)
    print clf.best_estimator_


## Evaluate final model using KFold split algorithm.
def trainAndEvaluateUsingKFold():
    
    kf = KFold(n_splits=4)
    
    for train_indices, test_indices in kf.split(features_df_train):
        features_train = []
        labels_train = []
        features_test = []
        labels_test = []
        ## Train model features and labels
        for train_index in train_indices:
            features_train.append(features_df_train[train_index])
            labels_train.append(labels_df_train[train_index])
        ## Test model features and labels
        for test_index in test_indices:        
            features_test.append(features_df_train[test_index])
            labels_test.append(labels_df_train[test_index])
            
        #clf = clf.fit(features_train, labels_train)
        #featureSelection(clf, features_train, labels_train)
        labels_predict = clf.predict(features_test)
        evaluateModel(labels_test, labels_predict)
        #for prediction, truth in zip(labels_predict, labels_test):
            #print "Prediction is %d and truth is %d" %(prediction, truth)
        
        #Estimate params of GridSearchCV
        #print clf.best_estimator_
        
## Predict output on test data and submit output in the CSV file.        
def submitTestDataToOutputCSV():
    labels_predict = clf.predict(data_test)
    passenger_ids = []
    for i in xrange(len(labels_predict)):
        ##  Passenger ID of the test data
        id = i + 892
        passenger_ids.append(id)
    output_dict = {"PassengerId": pd.Series(passenger_ids), "Survived": pd.Series(labels_predict)}
    df = pd.DataFrame(output_dict)
    df.to_csv("output.csv")
    print len(labels_predict)
    #print labels_predict
    
trainAndEvaluateUsingKFold()
#print len(features_df_train)
submitTestDataToOutputCSV()
print clf.best_estimator_
#print clf.scorer_ 

    
 
    