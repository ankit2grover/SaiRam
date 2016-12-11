#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov 11 01:26:29 2016

@author: admin
"""

# These are all the modules we'll be using later. Make sure you can import them
# before proceeding further.
from __future__ import print_function
import numpy as np
import tensorflow as tf
from six.moves import cPickle as pickle
from six.moves import range

pickle_file = 'notMNIST.pickle'

def loadMNISTData():
    try:
        with open(pickle_file, 'rb') as f:
            save = pickle.load(f)
            train_dataset = save['train_dataset']
            train_labels = save['train_labels']
            valid_dataset = save['valid_dataset']
            valid_labels = save['valid_labels']
            test_dataset = save['test_dataset']
            test_labels = save['test_labels']
            
            del save  # hint to help gc free up memory
            print('Training set', train_dataset.shape, train_labels.shape)
            print('Validation set', valid_dataset.shape, valid_labels.shape)
            print('Test set', test_dataset.shape, test_labels.shape)
            return train_dataset, train_labels, valid_dataset, valid_labels, test_dataset, test_labels
    except Exception as e:
        print('Unable to read data from ', pickle_file, ':', e)
    raise
    
    
train_dataset, train_labels, valid_dataset, valid_labels, test_dataset, test_labels = loadMNISTData()

num_labels = 10
image_size = 28

def reformat(dataset, labels):
    dataset = dataset.reshape((-1, image_size * image_size)).astype(np.float32)
    labels = (np.arange(num_labels) == labels[:, None]).astype(np.float32)
    return dataset, labels

train_dataset, train_labels = reformat(train_dataset, train_labels)
valid_dataset, valid_labels = reformat(valid_dataset, valid_labels)
test_dataset, test_labels = reformat(test_dataset, test_labels)



# With gradient descent training, even this much data is prohibitive.
# Subset the training data for faster turnaround.
train_subset = 10000



graph = tf.Graph()
with graph.as_default():
    # Input data.
    # Load the training, validation and test data into constants that are
    # attached to the graph.
    tf_train_dataset = tf.constant(train_dataset[: train_subset, :])
    tf_train_labels = tf.constant(train_labels[: train_subset])
    tf_valid_dataset = tf.constant(valid_dataset)
    tf_valid_labels = tf.constant(valid_labels)
    tf_test_dataset = tf.constant(test_dataset)
    
    # Variables.
    # These are the parameters that we are going to be training. The weight
    # matrix will be initialized using random values following a (truncated)
    # normal distribution. The biases get initialized to zero.
    weights = tf.Variable(tf.truncated_normal([image_size * image_size, num_labels]))
    biases = tf.Variable(tf.zeros([num_labels]))
  
    # Variables.
    # These are the parameters that we are going to be training. The weight
    # matrix will be initialized using random values following a (truncated)
    # normal distribution. The biases get initialized to zero.
    logits = tf.matmul(tf_train_dataset, weights) + biases
    loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits, tf_train_labels))
    
    #print (logits)
    #print (loss)
    # Optimizer.
    # We are going to find the minimum of this loss using gradient descent.
    optimizer = tf.train.GradientDescentOptimizer(0.5).minimize(loss)
  
    # Predictions for the training, validation, and test data.
    # These are not part of training, but merely here so that we can report
    # accuracy figures as we train.
    train_prediction = tf.nn.softmax(logits)
    valid_prediction = tf.nn.softmax(tf.matmul(tf_valid_dataset, weights) + biases)
    test_prediction = tf.nn.softmax(tf.matmul(tf_test_dataset, weights) + biases)
    #print (train_prediction)
    

num_steps = 801


def accuracy(predictions, labels):
    return (100 * np.sum((np.argmax(predictions, axis = 1) == np.argmax(labels, axis = 1)))/ predictions.shape[0])
    


## Gradient Descent algorithm computation, slow but accurate.

with tf.Session(graph=graph) as session:
    # This is a one-time operation which ensures the parameters get initialized as
    # we described in the graph: random weights for the matrix, zeros for the
    # biases.
    tf.initialize_all_variables().run()
    ##tf.global_variables_initializer().run()
    for step in range(num_steps):
        # Run the computations. We tell .run() that we want to run the optimizer,
        # and get the loss value and the training predictions returned as numpy
        # arrays.
        op, new_loss, new_train_pred = session.run([optimizer, loss, train_prediction])
        if ((step % 100) == 0):
            print ("Loass %.2f at step %d" %(new_loss, step))
            print("Train accuracy %.2f" %accuracy(new_train_pred, train_labels[:train_subset, :]))
            print("Validation accuracy %.2f" %accuracy(valid_prediction.eval(), valid_labels))
    
    print("Test accuracy %.2f" %accuracy(test_prediction.eval(), test_labels))


## Stochastic gradient descent algorithm computation, in which we will consider batches of inputs. It is faster than GD, but not as accurate.

batch_size = 128

with graph.as_default():
    # Input data.
    # Load the training, validation and test data into constants that are
    # attached to the graph.
    tf_train_dataset = tf.placeholder(tf.float32,
                                    shape=(batch_size, image_size * image_size))
    tf_train_labels = tf.placeholder(tf.float32,
                                    shape=(batch_size, num_labels))
    tf_valid_dataset = tf.constant(valid_dataset)
    tf_valid_labels = tf.constant(valid_labels)
    tf_test_dataset = tf.constant(test_dataset)
    
    # Variables.
    # These are the parameters that we are going to be training. The weight
    # matrix will be initialized using random values following a (truncated)
    # normal distribution. The biases get initialized to zero.
    weights = tf.Variable(tf.truncated_normal([image_size * image_size, num_labels]))
    biases = tf.Variable(tf.zeros([num_labels]))
  
    # Variables.
    # These are the parameters that we are going to be training. The weight
    # matrix will be initialized using random values following a (truncated)
    # normal distribution. The biases get initialized to zero.
    logits = tf.matmul(tf_train_dataset, weights) + biases
    loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits, tf_train_labels))
    
    #print (logits)
    #print (loss)
    # Optimizer.
    # We are going to find the minimum of this loss using gradient descent.
    optimizer = tf.train.GradientDescentOptimizer(0.5).minimize(loss)
  
    # Predictions for the training, validation, and test data.
    # These are not part of training, but merely here so that we can report
    # accuracy figures as we train.
    train_prediction = tf.nn.softmax(logits)
    valid_prediction = tf.nn.softmax(tf.matmul(tf_valid_dataset, weights) + biases)
    test_prediction = tf.nn.softmax(tf.matmul(tf_test_dataset, weights) + biases)
    


    ## Stochastic gradient descent algorithm computation, steps increased and training data is reduced to batches.


num_steps = 3001
with tf.Session(graph=graph) as session:
    # This is a one-time operation which ensures the parameters get initialized as
    # we described in the graph: random weights for the matrix, zeros for the
    # biases.
    tf.initialize_all_variables().run()
    ##tf.global_variables_initializer().run()
    for step in range(num_steps):
        # Pick an offset within the training data, which has been randomized.
        # Note: we could use better randomization across epochs.
        offset = (step * batch_size) % (train_labels.shape[0] - batch_size)
        # Generate a minibatch.
        batch_data = train_dataset[offset:(offset + batch_size), :]
        batch_labels = train_labels[offset:(offset + batch_size), :]
        # Prepare a dictionary telling the session where to feed the minibatch.
        # The key of the dictionary is the placeholder node of the graph to be fed,
        # and the value is the numpy array to feed to it.
        feed_dict = {tf_train_dataset : batch_data, tf_train_labels : batch_labels}
        op, new_loss, new_train_pred = session.run([optimizer, loss, train_prediction], feed_dict = feed_dict)
        if ((step % 500) == 0):
            print ("Stochastic Loss %.2f at step %d" %(new_loss, step))
            print("Stochastic Train accuracy %.2f" %accuracy(new_train_pred, batch_labels))
            print("Stochastic Validation accuracy %.2f" %accuracy(valid_prediction.eval(), valid_labels))

    print("Stochastic Test accuracy %.2f" %accuracy(test_prediction.eval(), test_labels))
        



  


