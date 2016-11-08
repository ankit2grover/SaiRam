from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

import gzip
import os
import tempfile

import numpy
from six.moves import urllib
from six.moves import xrange  # pylint: disable=redefined-builtin
from tensorflow.examples.tutorials.mnist import input_data
import tensorflow as tf

## MNIST data
mnist = input_data.read_data_sets("MNIST_data", one_hot=True)
## Input placeholder 
x = tf.placeholder(tf.float32, [None, 784])
## Weight of the network
W = tf.Variable(tf.zeros([784, 10]))
## Bias of the network
b = tf.Variable(tf.zeros([10]))
## Predicted output
y = tf.nn.softmax(tf.matmul(x,W) + b)
## Actual Output placeholder
y_ = tf.placeholder(tf.float32, [None, 10])
## Calculate cross entropy
cross_entropy = -tf.reduce_sum(y_* tf.log(y))
train_step = tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)

## Initialize and launch tensorflow
init = tf.initialize_all_variables()
sess = tf.Session()
sess.run(init)

## Train the tensor flow.
for i in range(1000):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})
    
## Test tensor flow.
correct_prediction = tf.equal(tf.argmax(y,1), tf.argmax(y_,1))
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
print (sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
