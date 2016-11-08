# -*- coding: utf-8 -*-
"""
Created on Mon Jul 18 02:11:48 2016

@author: tkmaea9
"""

import tensorflow as tf

x = tf.placeholder(tf.float32, [None, 784])
## Weight of the network
W = tf.Variable(tf.zeros([784, 10]))
b = tf.Variable(tf.zeros([10]))
## Predicted output
y = tf.nn.softmax(tf.matmul(W,x) + b)
