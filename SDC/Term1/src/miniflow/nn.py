
from miniflow import *

x, y, z = Input(), Input(), Input()
inputs = [x, y, z]

#f = Add(inputs)

#f_mult = Multiply(inputs)

#feed_dict = {x: 10, y: 5, z : 11}

#graph = topological_sort(feed_dict)

#output = forward_pass(f, graph)

#output_multiply = forward_pass(f_mult, graph)

#print("{} + {} + {} = {} (according to miniflow)".format(feed_dict[x], feed_dict[y], feed_dict[z], output))

#print ("{} * {} * {} = {}(according to multiply node in miniflow)".format(feed_dict[x], feed_dict[y], feed_dict[z], output_multiply))

import numpy as np
from miniflow import *

X, W, b = Input(), Input(), Input()

f = Linear(X, W, b)

X_ = np.array([[-1., -2.], [-1, -2]])
W_ = np.array([[2., -3], [2., -3]])
b_ = np.array([-3., -5])

feed_dict = {X: X_, W: W_, b: b_}

graph = topological_sort(feed_dict)
output = forward_pass(f, graph)

"""
Output should be:
[[-9., 4.],
[-9., 4.]]
"""
print(output)
