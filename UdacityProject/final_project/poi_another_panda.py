# -*- coding: utf-8 -*-
"""
Created on Fri Oct  7 11:38:17 2016

@author: tkmaea9
"""
from feature_format import featureFormat, targetFeatureSplit
from tester import dump_classifier_and_data

#Imports I'll need during the ML task

import numpy as np
import pandas as pd
import sklearn as sk
from ggplot import *

import matplotlib.pyplot as plt

from  time import time



### Task 1: Select what features you'll use.
### features_list is a list of strings, each of which is a feature name.
### The first feature must be "poi".

#feature selection commentary 

print "\n"+"=="*6 + "feature selection:" + "=="*6 + "\n"
print """

financial features : 
1- I'll have to first rescale the financial data because salary and bonus difference could be big.
2- feature selection : only what matters. POI Def : Since it's a financial scandal, all what motivate
 is the amount of money they will get out of the company in return of the shananigans they will do. 
 Thus, I'll select on : => salary, bonus, total payments (to check what it exactly mean), 
 [total_stock_value, long_term_incentive] 
 ( may be having less than usual because they know the company is shit/ make a new feature out of it)

email features :
POI must communicate privatly a lot between them, thus email insight won't give me a lot of 
pertinent info compared to financial features. 
Assumptions : POI communication should be more intense directly than non direclty. 
meaning they will fraction of direct communication / shared_receipt_with_poi will be more 
pronounced between POI If they are not prudent. 
if not prudent will see the inverse pattern. => computed feature: 
	X1 = from_poi_to_this_person'/'from_messages' and X2 = from_this_person_to_poi/to_messages
focus on : from_poi_to_this_person, from_this_person_to_poi as pure features
"""
print "\n"+"=="*12 +"**"*12 + "\n"

features_list = ['poi','salary','bonus','total_payments','total_stock_value','long_term_incentive', 'from_poi_to_this_person','from_messages','from_this_person_to_poi','to_messages'] # You will need to use more features

### Load the dictionary containing the dataset
with open("final_project_dataset.pkl", "r") as data_file:
	data_dict = pickle.load(data_file)

### Task 2: Remove outliers

print "\n"+"=="*6 + "Removing outliers" + "=="*6 + "\n"

print "setting the data into a dataframe for data mungling ..."
df = pd.DataFrame.from_records(list(data_dict.values()))
persons = pd.Series(list(data_dict.keys()))
#set persons as indexes 

df = df.set_index(persons)

# take only the features I'm interested in
df = df[features_list]

# Convert to numpy nan
df.replace(to_replace='NaN', value=np.nan, inplace=True)

# Count number of NaN's for columns

print "print the numbers of unavailable data per column : ",df.isnull().sum()/df.shape[0]

# DataFrame dimeansion
print "printing the shape of the data: ",df.shape

# removing long term incentive because of insufficient data more than a half don't have data

df = df.drop('long_term_incentive', 1)

#now i must look for extreme data

print "description \n" , df.describe()

print "Printing largest salaries \n" , df['salary'].nlargest(10)

#I can see that there is a caracter 'TOTAL' not a person 

print "dropping TOTAL Data point"
try:
	df = df.drop('TOTAL')
except:
	pass

print "Printing largest from_messages \n" , df['from_messages'].nlargest(10)

#i notice that KAMINSKI WINCENTY J a research guy is a lot present , I could drop him too after


print "Printing largest to_messages \n" , df['to_messages'].nlargest(10)

# i notice that SHAPIRO RICHARD S and KEAN STEVEN J  

columns = list(df.columns.values)
for column in columns :
	try :
		print column
		print df[column].nlargest(5)
	except :
		pass

print "\n"+"=="*12 +"**"*12 + "\n"


### Task 3: Create new feature(s)


print "\n"+"=="*6 + "Create new feature(s)" + "=="*6 + "\n"

# starts here to create new features 

#X1 = from_poi_to_this_person'/'from_messages' and X2 = from_this_person_to_poi/to_messages

df['from_poi_from_messages'] = df['from_poi_to_this_person']*100./df['to_messages']

df['from_person_to_messages'] = df['from_this_person_to_poi']*100./df['from_messages']

# print "from_poi_from_messages \n " ,df['from_poi_from_messages']

# print "from_person_to_messages \n" , df['from_person_to_messages'] 


#if I want to print the data 
# g = ggplot(aes(x='from_poi_from_messages', y='from_person_to_messages', colour='poi'), data=df) + geom_point()
# print g

print "\n"+"=="*12 +"**"*12 + "\n"


# Checking for redondant data


print "\n"+"=="*6 + "Checking for redondant data" + "=="*6 + "\n"

print "data correlation check "
corr_mat = df.corr()
columns = list(corr_mat.columns.values)
for column in columns:
	try:
		print "\n"
		print column
		print corr_mat[column].nlargest(5)
	except:
		pass

# dropping features that are highly correlated corre > 0.55 from the same category (finance or email)
print """

dropping features that are highly correlated corre > 0.55 from the same category (finance or email)

"""
df = df.drop(['total_stock_value','total_payments','to_messages','from_messages','bonus'],axis = 1)


print "data correlation check \n\n "
corr_mat = df.corr()
columns = list(corr_mat.columns.values)
for column in columns:
	try:
		print "\n"
		print column
		print corr_mat[column].nlargest(5)
	except:
		pass

print "\n"+"=="*12 +"**"*12 + "\n"


# looking at the data : final check before working with models
print "\n"+"=="*6 + "Checking for redondant data" + "=="*6 + "\n"

print "Values:", list(df.columns.values)

print "Shape: ", df.shape

print "Number of POI in DataSet: ", (df['poi'] == 1).sum()
print "Number of non-POI in Dataset: ", (df['poi'] == 0).sum()

print "\n"+"=="*12 +"**"*12 + "\n"

# ### Store to my_dataset for easy export below.
my_dataset = data_dict

# ### Extract features and labels from dataset for local testing
# data = featureFormat(my_dataset, features_list, sort_keys = True)
# labels, features = targetFeatureSplit(data)

### Task 4: Try a varity of classifiers
### Please name your classifier clf for easy export below.
### Note that if you want to do PCA or other multi-stage operations,
### you'll need to use Pipelines. For more info:
### http://scikit-learn.org/stable/modules/pipeline.html
print "\n"+"=="*6 + "Try a varity of classifiers" + "=="*6 + "\n"

labels = df['poi'].copy(deep=True).astype(int).as_matrix()
features = (df.drop('poi', axis=1)).fillna(0).copy(deep=True).as_matrix()

print "labels \n",labels.shape
print "features \n ",features.shape

from sklearn import cross_validation
from sklearn.metrics import accuracy_score, precision_score, recall_score , f1_score

# splitting data between training and testing
X_train, X_test, y_train, y_test = cross_validation.train_test_split(features, labels, test_size=0.2)

print "splitting data between training and testing \n"
print "X_train.shape,X_test.shape,y_train.shape,y_test.shape ",(X_train.shape,X_test.shape,y_train.shape,y_test.shape)

# defining my metric function that will have a target to compute the f1 score a 
# mix of precision and recall but have to have a 0.3 min threshold to compute the f1 score for both prec and recall 

from sklearn import metrics

def zouzou(estimator, features_test, labels_test):
	labels_pred = estimator.predict(features_test)
	#precision
	p = precision_score(labels_test, labels_pred)
	#recall
	r = recall_score(labels_test, labels_pred )
	
	#confusion matrix
#     cm = metrics.confusion_matrix(labels_test,labels_test)
#     print(cm)
#     print p,r
	if p > 0.3 and r > 0.3:
		return round(f1_score(labels_test, labels_pred),3)
	return 0

# defining the testing function 
def test_Model(clf, features, labels ):
	#the problem with this method is taht i depend on the part of train test i took
	#so I use cross validation score to test on different parts of the sample and not be depending on the data split randomity
	n_samples = features.shape[0]

	# The test_size impacted the results using 0.3 I did have 0 
	# using 0.2 it went good
	cv = cross_validation.ShuffleSplit(n_samples, n_iter=10, test_size=0.2, random_state=0)
	
	score = cross_validation.cross_val_score(clf, features, labels, cv=cv ,scoring=zouzou)
	print '\n'+ 14*'='
	print clf
	print np.array(score ).mean()
	print '\n'+ 14*'='





#trying a variety of classifiers 

print "trying a variety of classifiers"
t0 =time()
from sklearn import tree
clf = tree.DecisionTreeClassifier() #working good
test_Model(clf, features, labels )

from sklearn.naive_bayes import GaussianNB
clf = GaussianNB()
test_Model(clf, features, labels )

from sklearn import svm
clf = svm.SVC()
test_Model(clf,  features, labels )

clf = svm.LinearSVC() # working good
test_Model(clf,  features, labels )

from sklearn.neighbors import KNeighborsClassifier #working good
clf = KNeighborsClassifier()
# clf = KNeighborsClassifier(n_neighbors=3)
test_Model(clf, features, labels )

from sklearn.ensemble import AdaBoostClassifier
clf = AdaBoostClassifier()
# clf = AdaBoostClassifier(n_estimators=100)
test_Model(clf,  features, labels )
 
from sklearn.ensemble import RandomForestClassifier #working good
clf = RandomForestClassifier()
# clf = RandomForestClassifier(n_estimators=10)
test_Model(clf,  features, labels )



print "testing finished in " + str(round(time()-t0,3)) + " s"

print """
scores : 
AdaBoostClassifier , 0.124
RandomForestClassifier , 0.083
DecisionTreeClassifier , 0.04
GaussianNB , 0.04

I should try GaussianNB after scaling my features !!

"""
print "\n"+"=="*12 +"**"*12 + "\n"

### Task 5: Tune your classifier to achieve better than .3 precision and recall 
### using our testing script. Check the tester.py script in the final project
### folder for details on the evaluation method, especially the test_classifier
### function. Because of the small size of the dataset, the script uses
### stratified shuffle split cross validation. For more info: 
### http://scikit-learn.org/stable/modules/generated/sklearn.cross_validation.StratifiedShuffleSplit.html

print "\n"+"=="*6 + "Tuning the classifier" + "=="*6 + "\n"

# Example starting point. Try investigating other evaluation techniques!
from sklearn.cross_validation import train_test_split
features_train, features_test, labels_train, labels_test = \
	train_test_split(features, labels, test_size=0.3, random_state=42)


from sklearn.metrics import classification_report 
# for the purposes of validation
# I ll work on DecisionTreeClassifier because it's the one I understand
from sklearn.grid_search import GridSearchCV



ranges= range(1,50,5)


scores = ['precision', 'recall','f1']

for score in scores:

	# ranges= range(1,50,5)
	#     parameters = {'min_samples_split': ranges }
	#     clf = tree.DecisionTreeClassifier()
	#     clf = GridSearchCV(clf, parameters, cv=, scoring = score)

	#     ranges= range(1,50,5)
	#     parameters = {'leaf_size': ranges,'weights':['uniform','distance'],'n_neighbors':ranges }
	#     clf = KNeighborsClassifier()
	#     clf = GridSearchCV(clf, parameters, cv=3, scoring = score)

	print "Best Model for: " + score
	range1 = range(1,200,20)
	range2 = [1.,1.5,2.,2.5]
	parameters = {'n_estimators':range1,'learning_rate':range2}
	clf = AdaBoostClassifier()
	clf = GridSearchCV(clf, parameters, cv=3, scoring = score)
	
	clf.fit(features_train, labels_train)
	
	print("Best parameters on development set:")

	print(clf.best_params_)
	
print """
Choosing :

Best parameters on development set:
{'n_estimators': 81, 'learning_rate': 2.0}


""" 
#finale model :

# clf = tree.DecisionTreeClassifier(min_samples_split=6)

# clf = KNeighborsClassifier(n_neighbors= 1, weights= 'uniform', leaf_size= 1)

print "setting the model and the data I needed in order to test it with the tester of UDACITY \n"
clf = AdaBoostClassifier(n_estimators= 81, learning_rate= 2.0)

list_cols = list(df.columns.values)
list_cols.remove('poi')
list_cols.insert(0, 'poi')
data = df[list_cols].fillna(0).to_dict(orient='records')
enron_data_sub = {}
counter = 0
for item in data:
	enron_data_sub[counter] = item
	counter += 1

print "testing the model ..."
t0=time()

from tester import test_classifier, dump_classifier_and_data

test_classifier(clf, enron_data_sub, list_cols)

print "test ended in " + str(round(time()-t0,2)) + " s"


print "\n"+"=="*12 +"**"*12 + "\n"

### Task 6: Dump your classifier, dataset, and features_list so anyone can
### check your results. You do not need to change anything below, but make sure
### that the version of poi_id.py that you submit can be run on its own and
### generates the necessary .pkl files for validating your results.

print "\n"+"=="*6 + "Dumping " + "=="*6 + "\n"

print "dumping the data ... "
dump_classifier_and_data(clf, my_dataset, features_list)

my_dataset = enron_data_sub
features_list = list_cols
dump_classifier_and_data(clf, my_dataset, features_list)
