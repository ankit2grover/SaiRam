#!/usr/bin/python

""" 
    Starter code for exploring the Enron dataset (emails + finances);
    loads up the dataset (pickled dict of dicts).

    The dataset has the form:
    enron_data["LASTNAME FIRSTNAME MIDDLEINITIAL"] = { features_dict }

    {features_dict} is a dictionary of features associated with that person.
    You should explore features_dict as part of the mini-project,
    but here's an example to get you started:

    enron_data["SKILLING JEFFREY K"]["bonus"] = 5600000
    
"""
from __future__ import division
import pickle


enron_data = pickle.load(open("../final_project/final_project_dataset.pkl", "r"))
total_salary = 0
valid_mails = 0
total_payments = 0
total_poi = 0;

for key, value in enron_data.items():
    salary = value.get('salary')
    email_address = value.get('email_address')
    payment = value.get("total_payments")
    poi = value.get("poi")
    print poi
    #print email_address
    if (salary != 'NaN'):
        total_salary = total_salary + 1
    if (email_address != 'NaN'):
        valid_mails = valid_mails + 1
    if poi:
        total_poi = total_poi + 1
        if(payment == 'NaN'):
            total_payments = total_payments + 1
        
nan_payments_percentile = total_payments/ total_poi

print total_payments
print "Percentile of payments that is NaN = %f" %nan_payments_percentile
    
#print "Total no. of Salary = %d and valid mails = %d" %(total_salary, valid_mails)


        



