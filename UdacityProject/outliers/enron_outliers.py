#!/usr/bin/python

import pickle
import sys
sys.path.append("../tools/")
from feature_format import featureFormat, targetFeatureSplit
import matplotlib.pyplot as plt

### read in data dictionary, convert to numpy array
data_dict = pickle.load( open("../final_project/final_project_dataset.pkl", "r") )
data_dict.pop("TOTAL", 0 )
data_dict.pop("LAY KENNETH L", 0)
data_dict.pop("SKILLING JEFFREY K", 0)
features = ["bonus", "salary"]
data, keys_list = featureFormat(data_dict, features)
max_bonus = 0
key_max_index = 0

for index in  range(len(data)):
    item = data[index]
    bonus_item = item[0]
    if max_bonus < bonus_item:
        max_bonus = bonus_item
        key_max_index = index
    salary_item = item[1]
    if (salary_item > 1000000 and bonus_item > 5000000):
        print keys_list[index]
    #print "Salary %f and bonus %f and key is %s" %(salary_item, bonus_item, keys_list[index])
    plt.scatter(salary_item, bonus_item, color ="blue")
    plt.xlabel("salary")
    plt.ylabel("bonus")
    
plt.show()    
target, features = targetFeatureSplit(data)
print key_max_index
print max_bonus
print keys_list[key_max_index]



### your code below
from sklearn.cross_validation import train_test_split
features_train, features_test, target_train, target_test = train_test_split(features, target, test_size=0.33, random_state=42)


from sklearn import linear_model
reg = linear_model.LinearRegression()
reg = reg.fit(features_train, target_train)


predict_test = reg.predict(features_test)



plt.scatter(features_train, target_train, color ="blue")
plt.plot(features_test, predict_test, color="black")
plt.scatter(features_test, target_test, color = "red")

plt.xlabel("salary")
plt.ylabel("bonus")
plt.show()

print reg.coef_
print reg.intercept_
print reg.score(features_test, target_test)

