# -*- coding: utf-8 -*-
"""
Created on Sun Oct 16 23:42:11 2016

@author: tkmaea9
"""

# -*- coding: utf-8 -*-
"""
Created on Wed Oct  5 16:24:33 2016

@author: tkmaea9
"""

import sys
import pickle
sys.path.append("../tools/")
sys.path.append("../Dataset/")
import pandas as pd
import matplotlib.pyplot as plt
from scipy.stats import pearsonr
from feature_format import targetFeatureSplit
from sklearn.feature_selection import RFE
from sklearn.svm import SVC
from sklearn.ensemble import RandomForestClassifier
from sklearn.linear_model import (LogisticRegression, Ridge,Lasso, RandomizedLasso, RandomizedLogisticRegression)





def processAgeColumn(df, is_train):
    
    ## Filter outliers in which age = 'NaN', sex = male and survived = 0, it means remove men outliers whose age= "NaN"
    for index, row in df.iterrows():
        if (is_train and pd.isnull(row["Age"]) and row["Survived"] == 0):
            df = df.drop(index, axis = 0)

    df.fillna(df["Age"].mean(), inplace=True)
    return df
    
def oneHotEncodeSexData(df):
    dummy_ranks = pd.get_dummies(df['Sex'], prefix='Sex_')
    new_df = df.join(dummy_ranks)
    return new_df
    
def oneHotEncodePclassData(df):
    dummy_ranks = pd.get_dummies(df['Pclass'], prefix='Pclass_')
    new_df = df.join(dummy_ranks)
    return new_df


def featureScores(features, feature_names):
        #print features
        #print feature_names
        print features
        #features = map(lambda x: round(x, 2), features)
        print (dict(zip(features, feature_names)))
        
        
def rLasso(features, names, labels):
    print names
    rlasso = RandomizedLasso()
    rlasso = rlasso.fit(features, labels)
    print rlasso.scores_
    #featureScores(rlasso.scores_, names)
    
def ridgeScores(features, names, labels):
    print names
    estimator = Ridge()
    estimator = estimator.fit(features, labels)
    print estimator.coef_
    
    
def lassoScores(features, names, labels):
    print names
    estimator = Lasso(alpha=.05)
    estimator = estimator.fit(features, labels)
    print estimator.coef_
    
def logisticRegression(features, names, labels):
    print names
    estimator = LogisticRegression()
    estimator = estimator.fit(features, labels)
    print estimator.coef_
    
def rfeScore(features, names, labels):
    print names
    svc = SVC(kernel='linear', class_weight='auto')
    #rank all features, i.e continue the elimination until the last one
    rfe = RFE(svc, n_features_to_select=3)
    rfe = rfe.fit(features, labels)
    print rfe.ranking_
    
def randomForestFeatureImportance(features, names, labels):
    #print names
    clf_estimator = RandomForestClassifier(criterion='entropy',n_estimators = 30, min_samples_split = 10)
    clf_estimator = clf_estimator.fit(features, labels)
    print clf_estimator.feature_importances_
    
    
def computeFeatureSocres(titanic_df, data_array):
    ## Compute features scores
    labels_df_train, features_df_train = targetFeatureSplit(data_array)
    print ("R lasso score features")
    rLasso(features_df_train, titanic_df.columns.values[1:], labels_df_train)
    print ("RFE Features Ranking")
    rfeScore(features_df_train, titanic_df.columns.values[1:], labels_df_train)
    print ("Random Forest Features Importance")
    randomForestFeatureImportance(features_df_train, titanic_df.columns.values[1:], labels_df_train)
    print ("Ridge Scores")
    ridgeScores(features_df_train, titanic_df.columns.values[1:], labels_df_train)
    print ("Lasso Scores")
    lassoScores(features_df_train, titanic_df.columns.values[1:], labels_df_train)
    print ("logisticRegression Scores")
    logisticRegression(features_df_train, titanic_df.columns.values[1:], labels_df_train)

def dataPreProcessingTrain():
    
    # drop unnecessary columns, these columns won't be useful in analysis and prediction
    titanic_df = pd.read_csv('train.csv')    
    #titanic_df = titanic_df.drop(["PassengerId", "Name", "Parch", "Ticket", "Cabin", "Embarked", "Fare", "SibSp"], axis = 1)    
    titanic_df = titanic_df.drop(["PassengerId", "Name", "Parch", "Ticket", "Cabin", "Embarked", "SibSp"], axis = 1)    
    titanic_df = processAgeColumn(titanic_df, True)
    titanic_df = oneHotEncodeSexData(titanic_df)
    titanic_df = oneHotEncodePclassData(titanic_df)
    titanic_df = titanic_df.drop(["Sex"], axis = 1)
    titanic_df = titanic_df.drop(["Pclass"], axis = 1)
    titanic_df = titanic_df.drop(["Pclass__2"], axis = 1)
    #titanic_df = titanic_df.drop(["Sex__male"], axis = 1)
    #titanic_df = titanic_df.drop(["Pclass__3"], axis = 1)
    #titanic_df = titanic_df.drop(["Pclass", "Sex"], axis = 1)
    print titanic_df.columns.values
    titanic_data_array = titanic_df.as_matrix()
    #computeFeatureSocres(titanic_df, titanic_data_array)
    
    #print  titanic_df.head()
    #print titanic_data_array.shape
    #print titanic_data_array[0]
    return titanic_data_array
    
def dataPreProcessingTest():
    
    # drop unnecessary columns, these columns won't be useful in analysis and prediction
    titanic_df_test = pd.read_csv('test.csv')    
    ##titanic_df_test = titanic_df_test.drop(["PassengerId", "Name", "Parch", "Ticket", "Cabin", "Embarked", "Fare", "SibSp"], axis = 1) 
    titanic_df_test = titanic_df_test.drop(["PassengerId", "Name", "Parch", "Ticket", "Cabin", "Embarked", "SibSp"], axis = 1)    
    titanic_df_test = processAgeColumn(titanic_df_test, False)
    titanic_df_test = oneHotEncodeSexData(titanic_df_test)
    titanic_df_test = oneHotEncodePclassData(titanic_df_test)
    titanic_df_test = titanic_df_test.drop(["Pclass", "Sex"], axis = 1)
    titanic_df_test = titanic_df_test.drop(["Pclass__2"], axis = 1)
    #print titanic_df_test.columns.values
    titanic_data_test_array = titanic_df_test.as_matrix()
    #print  titanic_df.head()
    #print titanic_data_array.shape
    #print titanic_data_array[0]
    return titanic_data_test_array

titanic_df = dataPreProcessingTrain()
    
