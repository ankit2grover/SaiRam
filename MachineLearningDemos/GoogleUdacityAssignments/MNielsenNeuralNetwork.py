# -*- coding: utf-8 -*-
"""
Created on Wed Jul  6 01:51:39 2016

@author: tkmaea9
"""
"""
Code is taken from http://neuralnetworksanddeeplearning.com/chap1.html
Github of the original code https://github.com/mnielsen/neural-networks-and-deep-learning/blob/master/src/network.py
"""

import numpy as np
import random
# Network class containing neural network functionality. Constructor is having 
# sizes as list containing number of neurons in each layer.
class MNielsenNeuralNetwork:
    def __init__(self, sizes):
        self.num_layers = len(sizes)
        self.sizes = sizes
        self.biases = [np.random.randn(indexY, 1) for indexY in sizes[1:]]
        self.weights = [np.random.randn(indexY, indexX) 
                        for indexX, indexY in zip(sizes[:-1], sizes[1:])]

    def feedForward(self, a):
        """ Return the output of the network if a is input. """
        for bias, weight in zip(self.biases, self.weights):
            a = sigmoid(np.dot(weight, a) + bias)
        return a
    
    def SGD(self, training_data, epochs, mini_batch_size, eta, test_data= None):
        """Train the neural network using mini-batch stochastic
        gradient descent.  The "training_data" is a list of tuples
        "(x, y)" representing the training inputs and the desired
        outputs.  The other non-optional parameters are
        self-explanatory.  If "test_data" is provided then the
        network will be evaluated against the test data after each
        epoch, and partial progress printed out.  This is useful for
        tracking progress, but slows things down substantially."""
        if test_data: no_test = len(test_data)
        no_train_data = len(training_data)
        for no_iteration in xrange(epochs):
            random.shuffle(training_data)
            mini_batches = [
                training_data[k: k+ mini_batch_size]
                for k in xrange(0, no_train_data, mini_batch_size)]
            for mini_batch in mini_batches:
                self.update_mini_batch(mini_batch, eta)
            if test_data:
                print "Epochs {0} : {1} / {2}". format(
                    no_iteration, self.evaluate(test_data), len(test_data)) 
    
    def update_mini_batch(self, mini_batch, eta):
        """Update the network's weights and biases by applying
        gradient descent using backpropagation to a single mini batch.
        The "mini_batch" is a list of tuples "(x, y)", and "eta"
        is the learning rate."""
        zero_bias =  [np.zeros(bias_layer.shape) 
            for bias_layer in self.biases]
        zero_weight =  [np.zeros(weight_layer.shape) 
            for weight_layer in self.weights]
        for x, y in mini_batch:
            delta_bias, delta_weight = self.backprop(x, y)
            updated_bias = [zb+deltab 
                for zb, deltab in zip(zero_bias, delta_bias)]
            updated_weight = [zW +deltaW 
                for zW, deltaW in zip(zero_weight, delta_weight)]
        self.biases = [(b - ((eta/len(mini_batch)) * nb)) 
                for b, nb in zip(self.biases, updated_bias)]
        self.weights = [(w - ((eta/len(mini_batch)) * nw)) 
                for w, nw in zip(self.weights, updated_weight)]
    
    def backprop(self, x, y):
        """Return a tuple ``(nabla_b, nabla_w)`` representing the
        gradient for the cost function C_x.  ``nabla_b`` and
        ``nabla_w`` are layer-by-layer lists of numpy arrays, similar
        to ``self.biases`` and ``self.weights``."""
        nabla_b = [np.zeros(b.shape) for b in self.biases]
        nabla_w = [np.zeros(w.shape) for w in self.weights]
        # feedforward
        activation = x
        activations = [x] # list to store all the activations, layer by layer
        zs = [] # list to store all the z vectors, layer by layer
        for b, w in zip(self.biases, self.weights):
            z = np.dot(w, activation)+b
            zs.append(z)
            activation = sigmoid(z)
            activations.append(activation)
        # backward pass
        delta = self.cost_derivative(activations[-1], y) * \
            sigmoid_prime(zs[-1])
        nabla_b[-1] = delta
        nabla_w[-1] = np.dot(delta, activations[-2].transpose())
        # Note that the variable l in the loop below is used a little
        # differently to the notation in Chapter 2 of the book.  Here,
        # l = 1 means the last layer of neurons, l = 2 is the
        # second-last layer, and so on.  It's a renumbering of the
        # scheme in the book, used here to take advantage of the fact
        # that Python can use negative indices in lists.
        for l in xrange(2, self.num_layers):
            z = zs[-l]
            sp = sigmoid_prime(z)
            delta = np.dot(self.weights[-l+1].transpose(), delta) * sp
            nabla_b[-l] = delta
            nabla_w[-l] = np.dot(delta, activations[-l-1].transpose())
        return (nabla_b, nabla_w)
        
    def cost_derivative(self, output_activations, y):
        """Return the vector of partial derivatives \partial C_x /
        \partial a for the output activations."""
        return (output_activations-y)
        
    def evaluate(self, test_data):
        """Return the number of test inputs for which the neural
        network outputs the correct result. Note that the neural
        network's output is assumed to be the index of whichever
        neuron in the final layer has the highest activation."""
        test_results = [(np.argmax(self.feedForward(x)),y)
                        for x, y in test_data]
        return sum(int(x == y) for x, y in test_results)

def sigmoid(z):
        return 1.0/(1.0+np.exp(-z))

def sigmoid_prime(z):
        """Derivative of the sigmoid function."""
        return sigmoid(z)*(1-sigmoid(z))