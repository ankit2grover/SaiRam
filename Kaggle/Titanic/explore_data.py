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
from sklearn.preprocessing import StandardScaler

#import seaborn as sns
#sns.set_style('whitegrid')


def explorePOIData():
    ### Load the dictionary containing the dataset
    with open("final_project_dataset.pkl", "r") as data_file:
        data_dict = pickle.load(data_file)
    data_dict.pop("TOTAL", 0 )
    for name in data_dict: 
        data_point = data_dict[name]
        if data_point['poi']:
            print "Name : %s " % (name)
            print data_point
        
#explorePOIData() 

## Visualize the dataset
def visualizeScatter(xPoints, yPoints, data_frame):
    #sns.lmplot(xPoints, yPoints, data_frame, fit_reg=False)
    for index, xpoint in enumerate(xPoints):
        yPoint = yPoints[index]
        if (xpoint == 'NaN'):
            xpoint = 0
        if (yPoint == 'NaN'):
            yPoint = 0
        
        #if (xpoint > 7):
            #print data_frame.ix[index]
        plt.scatter(xpoint, yPoint, color ="blue")
    plt.xlabel("X label")
    plt.ylabel("Y label")
    plt.show() 
    
def visualizeHist(x_values):
    plt.hist(x_values)
    plt.title("Histogram")
    plt.xlabel("X Values")
    plt.ylabel("Frequesncy")
    plt.show()
    
def missing_values_table(df): 
        mis_val = df.isnull().sum()
        mis_val_percent = 100 * df.isnull().sum()/len(df)
        mis_val_table = pd.concat([mis_val, mis_val_percent], axis=1)
        mis_val_table_ren_columns = mis_val_table.rename(
        columns = {0 : 'Missing Values', 1 : '% of Total Values'})
        return mis_val_table_ren_columns 


def exploreFareData(titanic_df):
    ## Data understanding for Fare and found that median of 26 results in survival and median of 10 results in non- survival, also 3 fares are more than 512
    titanic_df["Fare"] = titanic_df["Fare"].astype(int)
    # only for test_df, since there is a missing "Fare" values
    titanic_df["Fare"].fillna(0, inplace=True)
    #dummy_df = titanic_df[["Fare", "Survived"]]
    #print dummy_df.head()
    #sns.rugplot(titanic_df["Fare"])
    survived_df = titanic_df["Fare"][titanic_df["Survived"] == 1]
    non_survived_df = titanic_df["Fare"][titanic_df["Survived"] == 0]
    print "Survived median %f" %survived_df.median()
    print "Not Survived median %f" %non_survived_df.median()
    print "Original median %f " %titanic_df["Fare"].median()
    print "Std : %f" %titanic_df["Fare"].std()
    visualizeScatter(titanic_df["Fare"], titanic_df["Survived"], titanic_df)
    

def exploreSibSpData(titanic_df):
    ## Data understanding for Fare and found that median of 26 results in survival and median of 10 results in non- survival, also 3 fares are more than 512
    #titanic_df["SibSp"] = titanic_df["SibSp"].astype(int)
    sib_df = titanic_df["SibSp"]
    # only for test_df, since there is a missing "Fare" values
    #titanic_df["SibSp"].fillna(0, inplace=True)
    #dummy_df = titanic_df[["Fare", "Survived"]]
    #print dummy_df.head()
    #sns.rugplot(titanic_df["Fare"])
    #survived_df = sib_df[titanic_df["Survived"] == 1]
    #non_survived_df = sib_df[titanic_df["Survived"] == 0]
    #print "Survived median %f" %survived_df.median()
    #print "Not Survived median %f" %non_survived_df.median()
    #print "Original median %f " %titanic_df["SibSp"].median()
    #print "Std : %f" %titanic_df["SibSp"].std()
    #print "Null SibSp sum : %d " %sib_df.isnull().sum()
    #print sib_df
    #visualizeScatter(sib_df, titanic_df["Survived"], titanic_df)
    
def exploreAgeData(df):
     ## Data understanding for Age 
    titanic_df["Age"] = titanic_df["Age"].astype(int)
    age_df = df["Age"]
    #age_df.fillna(0, inplace=True)
    #dummy_df = titanic_df[["Fare", "Survived"]]
    #print dummy_df.head()
    #sns.rugplot(titanic_df["Fare"])
    
    survived_df = age_df[df["Survived"] == 1]
    non_survived_df = age_df[df["Survived"] == 0]
    print "Survived median %f" %survived_df.mean()
    print "Not Survived median %f" %non_survived_df.mean()
    print "Original median %f " %age_df.mean()
    #print "Std : %f" %age_df.std()
    #print "Null Age sum : %d " %age_df.isnull().sum()
    #print pd.isnull(age_df)
    ## Null values like in index 5, 19, 28, 29
    #print titanic_df.ix[29]

    ## Filter outliers in which age = 'NaN', sex = male and survived = 0, it means remove men outliers whose age= "NaN"
    for index, row in df.iterrows():
        #print row["Age"]
        if (pd.isnull(row["Age"]) and row["Survived"] == 0):
            #print row
            df = df.drop(index, axis = 0)
    
    
    df.fillna(df["Age"].mean(), inplace=True)
    #scaler = StandardScaler()
    #scaled_ages_array = scaler.fit_transform(df[["Age"]])
    #scaled_ages_df = pd.DataFrame({'Scaled Ages':scaled_ages_array[:,0]})
    #print scaled_ages_df.info()
    #df = df.join(scaled_ages_df)
    #print scaled_ages_df
        #elif (pd.isnull(row["Age"]) and row["Sex"] == "male" and row["Survived"] == 1):
            #print df.ix[index]
    #visualizeScatter(age_df, titanic_df["Survived"], titanic_df)
    #visualizeHist(age_df)
    return df
    
def oneHotEncodeSex(df):
    dummy_ranks = pd.get_dummies(df['Sex'], prefix='Sex_')
    new_df = df.join(dummy_ranks)
    return new_df
    
def oneHotEncodePclass(df):
    dummy_ranks = pd.get_dummies(df['Pclass'], prefix='Pclass_')
    new_df = df.join(dummy_ranks)
    return new_df

def dataMungling():
    
    # drop unnecessary columns, these columns won't be useful in analysis and prediction
    titanic_df = pd.read_csv('train.csv')    
    titanic_df = titanic_df.drop(["PassengerId", "Name", "Parch", "Ticket", "Cabin", "Embarked", "Fare", "SibSp"], axis = 1)    
    
    # Observe 5 head items of the dataframe    
    #print (data_frame.head())
    
    # Describe data various properties like count, mean, std etc.
    #print (data_frame.describe())
    
    
    # drop following outlieres based on analysis through visualization tools.
    
    # Get information from the data like dtype, columns names etc.
    #print (train_df.info())
    
    # only in titanic_df, fill the two missing values with the most occurred value, which is "S".
    #train_df["Embarked"] = train_df["Embarked"].fillna("S")
    #sns.factorplot('Embarked','Survived', data=titanic_df, size= 4, aspect = 3)
    #visualize()
    #fig, (axis1,axis2,axis3) = plt.subplots(1,3,figsize=(15,5))
    #sns.countplot(x='Embarked', data=titanic_df, ax=axis1)
    #sns.countplot(x='Survived', hue="Embarked", data=titanic_df, order=[1,0], ax=axis2)
    
    # group by embarked, and get the mean for survived passengers for each value in Embarked
    #embark_perc = titanic_df[["Embarked", "Survived"]].groupby(['Embarked'],as_index=False).mean()
    #sns.barplot(x='Embarked', y='Survived', data=embark_perc,order=['S','C','Q'],ax=axis3)
    #embark_dummies_titanic  = pd.get_dummies(titanic_df['Embarked'])
    #print embark_dummies_titanic
    
    
    #print titanic_df
    
    titanic_df = exploreAgeData(titanic_df)
    titanic_df = oneHotEncodeSex(titanic_df)
    titanic_df = oneHotEncodePclass(titanic_df)
    
    
    titanic_df = titanic_df.drop(["Pclass", "Sex"], axis = 1)
    #titanic_df = exploreSibSpData(titanic_df)
    #print titanic_df.columns.values
    #print (titanic_df.describe())
    #print (titanic_df.head())
    print titanic_df
    return titanic_df

titanic_df = dataMungling()
    
## Ignore : deferral_payments,exercised_stock_options, restricted_stock, shared_receipt_with_poi, restricted_stock_deferred, loan_advances, director_fees, deferred_income, long_term_incentive

## Imp: Salary, bonus, to_messages,  total_payments, total_stock_value, expenses, from_messages, other, from_this_person_to_poi, from_poi_to_this_person
