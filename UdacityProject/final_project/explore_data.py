# -*- coding: utf-8 -*-
"""
Created on Wed Oct  5 16:24:33 2016

@author: tkmaea9
"""

import sys
import pickle
sys.path.append("../tools/")


### Task 1: Select what features you'll use.
### features_list is a list of strings, each of which is a feature name.
### The first feature must be "poi".
#features_list = ['poi','salary', 'bonus', 'exercised_stock_options', 'expenses', 'fraction_from_poi','fraction_to_poi', 'long_term_incentive', 'total_payments'] # You will need to use more features
features_list = ['poi,''salary', 'total_payments', 'loan_advances', 'bonus', 'restricted_stock_deferred', 'deferred_income', 'total_stock_value', 'expenses', 'exercised_stock_options', 'other', 'long_term_incentive', 'restricted_stock']
#features_list = ['poi','salary', 'bonus']

### Load the dictionary containing the dataset
with open("final_project_dataset.pkl", "r") as data_file:
    data_dict = pickle.load(data_file)

data_dict.pop("TOTAL", 0 )
def explorePOIData():
    for name in data_dict: 
        data_point = data_dict[name]
        if data_point['poi']:
            print "Name : %s " % (name)
            print data_point
        
#explorePOIData() 

## Visualize the dataset
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
    
visualize()

## Ignore : deferral_payments,exercised_stock_options, restricted_stock, shared_receipt_with_poi, restricted_stock_deferred, loan_advances, director_fees, deferred_income, long_term_incentive

## Imp: Salary, bonus, to_messages,  total_payments, total_stock_value, expenses, from_messages, other, from_this_person_to_poi, from_poi_to_this_person
