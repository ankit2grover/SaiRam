#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 24 16:22:53 2016

@author: tkmaea9
"""

import os
import numpy as np
from scipy import ndimage
from six.moves import cPickle as pickle

train_file_name = 'notMNIST_large.tar.gz'
test_file_name = 'notMNIST_small.tar.gz'
pixel_depth = 255.0

root = os.path.splitext(os.path.splitext(train_file_name)[0])[0]
print (os.path.isdir(root))
data_folders = []
for d in  (sorted(os.listdir(root))):
    dir_path = os.path.join(root, d)
    if (os.path.isdir(dir_path)):
        data_folders.append(dir_path)
        
print (data_folders)
np.random.seed(133)

def loadImagesofChar():
    #for folder in data_folders:
    folder = data_folders[0]
    image_files = os.listdir(data_folders[0])
    dataset = np.ndarray(shape=(len(image_files), 28, 28),dtype=np.float32)
    image_index = 0
    for image in image_files:
        image_file_path = os.path.join(folder, image)
        try:
            data = (ndimage.imread(image_file_path).astype(float) - (pixel_depth /2)) / pixel_depth
            dataset[image_index, :, :] = data
            image_index = image_index + 1
            
        except IOError as e:
             print('Could not read:', image_file_path, ':', e, '- it\'s ok, skipping.')
    print ("Folder : ", folder, "Images data shape: ", dataset.shape)
    return dataset, folder

def loadDataInPickle(dataset, folder):
    set_filename = folder + "_test.pickle";
    with open(set_filename, 'wb') as f:
        pickle.dump(dataset, f, pickle.HIGHEST_PROTOCOL)
    
    dataset_names = []
    dataset_names.append(set_filename)
    return dataset_names
    
def make_arrays(nb_rows, img_size):
    datasets = np.ndarray((nb_rows, img_size, img_size), dtype = np.float32)
    labels = np.ndarray(nb_rows, dtype=np.int32)
    return datasets, labels
    
#dataset,folder = loadImagesofChar()
#dataset_names = loadDataInPickle(dataset, folder)
train_size = 100000
valid_size = 5000
img_size = 28
num_classes = 10
    
train_dataset, train_labels_dataset = make_arrays(train_size, img_size)
valid_dataset, valid_labels_dataset = make_arrays(valid_size, img_size)
    
## Read data from pickle file and load it into dataset.
def loadDataFromPickle(data_folders):
    v_data_class = valid_size / num_classes
    t_data_class = train_size / num_classes
    start_v, start_t = 0, 0
    end_v = v_data_class
    end_t = t_data_class
    for label, folder in enumerate(data_folders):
        pickle_file = folder + ".pickle"    
        try:
            with open(pickle_file, 'rb') as f:
                data = pickle.load(f)
                np.random.shuffle(data)
                ## Validation dataset
                valid_dataset_class = data[:v_data_class, :, :]
                valid_dataset[start_v:end_v, :, :] = valid_dataset_class
                valid_labels_dataset[start_v:end_v] = label
                start_v += v_data_class
                end_v += v_data_class
                ## Train dataset
                train_dataset_class = data[:t_data_class, :, :]
                train_dataset[start_t:end_t, :, :] = train_dataset_class
                train_labels_dataset[start_t:end_t] = label
                start_t += t_data_class
                end_t += t_data_class
                
        except Exception as e:
            print('Unable to process data from', pickle_file, ':', e)
            raise
        
        return train_dataset,train_labels_dataset,valid_dataset,valid_labels_dataset
     
train_dataset,train_labels_dataset,valid_dataset,valid_labels_dataset = loadDataFromPickle(data_folders)


        
        
        




    
