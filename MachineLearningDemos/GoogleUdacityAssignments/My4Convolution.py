# These are all the modules we'll be using later. Make sure you can import them
# before proceeding further.
from __future__ import print_function
import numpy as np
import tensorflow as tf
from six.moves import cPickle as pickle

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
num_channels = 1

def reformat(dataset, labels):
    dataset = dataset.reshape((-1, image_size, image_size, 1)).astype(np.float32)
    labels = (np.arange(num_labels) == labels[:, None]).astype(np.float32)
    return dataset, labels

train_dataset, train_labels = reformat(train_dataset, train_labels)
valid_dataset, valid_labels = reformat(valid_dataset, valid_labels)
test_dataset, test_labels = reformat(test_dataset, test_labels)

def accuracy(predictions, labels):
    return (100 * np.sum((np.argmax(predictions, axis = 1) == np.argmax(labels, axis = 1)))/ predictions.shape[0])

# Small input batch size as convolution is an expensive operation
batch_size = 16
patch_size = 5
depth = 16
num_neurons = 64

graph = tf.Graph()

with graph.as_default():
    tf_train_dataset = tf.placeholder(tf.float32, shape = (batch_size, image_size, image_size, num_channels))
    tf_train_labels = tf.placeholder(tf.float32, shape = (batch_size, num_labels))
    tf_valid_dataset = tf.constant(valid_dataset)
    tf_test_dataset = tf.constant(test_dataset)

    ## Variables
    ## First convolution Layer weights. of patch or filter size = 5, num_channels = 1 and depth = 16
    layer1_weights = tf.Variable(tf.truncated_normal([patch_size, patch_size, num_channels, depth], stddev = 0.1))
    layer1_biases = tf.Variable(tf.zeros([depth])

    # Second convolution Layer weights. of patch or filter size = 5, num_channels = 16 and depth = 16
    layer2_weights = tf.Variable(tf.truncated_normal([patch_size, patch_size, depth, depth], stddev = 0.1))
    layer2_biases = tf.Variable(tf.constant(1.0, shape = [depth])

    # Connected layer weights, of image_size/4 * image_size/4 * depth, num_neurons, image_size/4 is used as stride of every patch in convolution is of 2.
    layer3_weights = tf.Variable(tf.truncated_normal([image_size / 4 * image_size / 4 * depth, num_neurons], stddev = 0.1))
    layer3_biases = tf.Variable(tf.constant(1.0, shape = [num_neurons])

    # Output layer weights and biases.
    layer4_weights = tf.Variable(tf.truncated_normal([num_neurons, num_labels], stddev = 0.1))
    layer4_biases = tf.Variable(tf.constant(1.0, shape = [num_labels])


def model(data):
    # stride is 2 in convolution layers.
    # Convolution 1 with strides 2 and same padding.
    conv1 = tf.nn.conv2d(data, layer1_weights, [1, 2, 2, 1], padding='SAME')
    conv1_relu = tf.nn.relu(conv + layer1_biases)

    # Convolution 2 with strides 2 and same padding.
    conv2 = tf.nn.conv2d(conv1_relu, layer2_weights, [1, 2, 2, 1], padding='SAME')
    conv2_relu = tf.nn.relu(conv2 + layer2_biases)

    # Connected layer hidden part.
    # Convert output of convolution2_relu into tensor list and then convert it into 2d matrix tensor [batch_size, patch_size * patch_size * depth]
    shape = hidden.get_shape().as_list()
    conn_layer_input = tf.reshape(conv2_relu, [shape[0], shape[1] * shape[2] * shape[3]])
    conn_layer_output = tf.nn.relu(tf.matmul(conn_layer_input, layer3_weights) + layer3_biases)

    ## Output layer softmax
    output_tensor_logits = tf.matmul(conn_layer_output, layer4_weights) + layer4_biases

    return output_tensor

output_tensor_logits = model(tf_train_dataset)

loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(output_tensor_logits, tf_train_labels))

# Optimizer.
optimizer = tf.train.GradientDescentOptimizer(0.05).minimize(loss)

# Predictions for the training, validation, and test data.
train_prediction = tf.nn.softmax(output_tensor_logits)
valid_prediction = tf.nn.softmax(model(tf_valid_dataset))
test_prediction = tf.nn.softmax(model(tf_test_dataset))

num_steps = 1001
with tf.Session(graph=graph) as session:
    tf.initialize_all_variables().run()
    print ("Initialized")
    for step in range(num_steps):
        offset = (step * batch_size) % (train_labels.shape[0] - batch_size)
        batch_input = train_dataset[offset: (offset + batch_size), :, :, :]
        batch_labels = train_labels[offset: (offset + batch_size), :]
        feed_dict = {tf_train_dataset: batch_input, tf_train_labels = batch_output}
        _, loss, predictions = session.run([optimizer, loss, train_prediction], feed_dict=feed_dict)
        if (step % 50 = 0):
            print("Mini batch train loss is %d at step %f" %(loss, step))
            print ("Mini batch train accuracy: %f" %accuracy(predictions, batch_labels))
            print ("Valid accuracy is %f " %accuracy(valid_prediction.eval(), valid_labels))
    print ("Test accuracy is %f " %accuracy(test_prediction.eval(), test_labels))


    

