# -*- coding: utf-8 -*-
"""
Created on Mon Jan 11 00:07:27 2016

@author: tkmaea9
"""

# Package imports
import matplotlib.pyplot as plt
import numpy as np
import sklearn
import sklearn.datasets
import sklearn.linear_model
import matplotlib

# Display plots inline and change default figure size
matplotlib.rcParams['figure.figsize'] = (10.0, 8.0)
# Generate a dataset and plot it
np.random.seed(0)
X, y = sklearn.datasets.make_moons(200, noise=0.20)
plt.scatter(X[:,0], X[:,1], s=60, c=y, cmap=plt.cm.spring)
num_examples = len(X)
input_dim = 2
output_dim = 2
grad_desc_alpha = 0.01
reg_alpha = 0.01


# This function learns parameters for the neural network and returns the model.
# - nn_hdim: Number of nodes in the hidden layer
# - num_passes: Number of passes through the training data for gradient descent
# - print_loss: If True, print the loss every 1000 iterations
def build_model(nn_dim = 3, num_passes=20000, print_loss=False):
    np.random.seed(0)
    theta1 = np.random.randn(input_dim, nn_dim) / np.sqrt(input_dim)
    const1 = np.zeros((1, nn_dim))
    theta2 = np.random.randn(nn_dim, output_dim) / np.sqrt(nn_dim)
    const2 = np.zeros((1, output_dim))
    
    # Gradient descent. For each batch..
    for i in xrange(0, num_passes):
        z1 = X.dot(theta1) + const1
        a1 = np.tanh(z1)
        z2 = a1.dot(theta2) + const2
        exp_scores = np.exp(z2)
        probs = exp_scores / np.sum(exp_scores, axis=1, keepdims=True)
        delta3 = probs
        #print(probs)
        #delta3 = probs - y
        #print(y)
        delta3[range(num_examples), y] -= 1
        difftheta2 = (a1.T).dot(delta3)
        diffconst2 = np.sum(delta3, axis=0, keepdims=True)
        delta2= delta3.dot(theta2.T)* (1- np.power(a1, 2))
        difftheta1 = np.dot(X.T, delta2)
        diffconst1 = np.sum(delta2, axis=0)
        
    
        # Add regularization terms to differential theta2 and theta1
        difftheta2 += reg_alpha * theta2
        difftheta1 += reg_alpha * theta1
        
        theta1 += -grad_desc_alpha * difftheta1
        theta2 += -grad_desc_alpha * difftheta2
        const1 += -grad_desc_alpha * diffconst1
        const2 += -grad_desc_alpha * diffconst2
        
        model = {'theta1':theta1, 'theta2':theta2, 'const1':const1, 'const2':const2}
        loss = calc_loss(model)
        if (i % 1000 == 0):
            print "Interaction %i and loss is  %f " %(i, loss)
        #print (model)
        
        
def calc_loss(model):
    theta1 = model['theta1']
    const1 = model['const1']
    theta2 = model['theta2']
    const2 = model['const2']
    #print('theta1' , theta1)
    #print ('theta2' , theta2)
    z1 = X.dot(theta1) + const1
    a1 = np.tanh(z1)
    z2 = a1.dot(theta2) + const2
    #print(z1)
    #print(a1)
    #print(z2)
    exp_scores = np.exp(z2)
    probs = exp_scores / np.sum(exp_scores, axis=1, keepdims=True)
    #print(probs)
    log_probs = -np.log(probs[range(num_examples), y])
    #print(log_probs)
    data_loss = np.sum(log_probs)
    
    data_loss += reg_alpha/2 * (np.sum(np.square(theta1)) + np.sum(np.square(theta2)))
    #print(data_loss)
    loss = 1./num_examples * data_loss
    return loss
        
        
        
        
    
        


build_model()
        
        
    