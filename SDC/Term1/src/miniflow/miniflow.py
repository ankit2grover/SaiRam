
import numpy as np
class Node(object):

    def __init__(self, inbound_nodes = []):
        self.inbound_nodes = inbound_nodes
        self.outbound_nodes = []
        self.value = None
        for node in inbound_nodes:
            node.outbound_nodes.append(self)

    def forward(self):
        raise NotImplemented


class Input(Node):

    def __init__(self):

        Node.__init__(self)

    def forward(self, value = None):
        if value is not None:
            self.value = value


class Add(Node):

    def __init__(self, inbound_nodes):
        Node.__init__(self, inbound_nodes)


    def forward(self):
        self.value = 0
        for node in self.inbound_nodes:
            self.value += node.value


class Multiply(Node):

    def __init__(self, inbound_nodes):
        Node.__init__(self, inbound_nodes)

    def forward(self):
        self.value = 1
        for node in self.inbound_nodes:
            self.value = self.value * node.value

class Linear(Node):

    def __init__(self, inputs, weights, bias):
        Node.__init__(self, [inputs, weights, bias])

    def forward(self):
        self.value = np.dot(self.inbound_nodes[0].value, self.inbound_nodes[1].value) + self.inbound_nodes[2].value

class Sigmoid(Node):
    def __init__(self, linear_input):
        Node.__init__(self, [linear_input])

    def _sigmoid(self, x):
        return (1 / (1 + np.exp(-x)))

    def forward(self):
        node_value = self.inbound_nodes[0].value
        self.value = self._sigmoid(node_value)

class MSE(Node):
    def __init__(self, y, a):
        Node.__init__(self, [y,a])

    def forward(self):
        y = self.inbound_nodes[0].value.reshape(-1, 1)
        a = self.inbound_nodes[1].value.reshape(-1, 1)
        self.value = np.sum(np.square(y - a), axis=0) / y.size

def topological_sort(feed_dict):
    """
    Sort generic nodes in topological order using Kahn's Algorithm.

    `feed_dict`: A dictionary where the key is a `Input` node and the value is the respective value feed to that node.

    Returns a list of sorted nodes.
    """

    input_nodes = [n for n in feed_dict.keys()]

    G = {}
    nodes = [n for n in input_nodes]
    while len(nodes) > 0:
        n = nodes.pop(0)
        if n not in G:
            G[n] = {'in': set(), 'out': set()}
        for m in n.outbound_nodes:
            if m not in G:
                G[m] = {'in': set(), 'out': set()}
            G[n]['out'].add(m)
            G[m]['in'].add(n)
            nodes.append(m)

    L = []
    S = set(input_nodes)
    while len(S) > 0:
        n = S.pop()

        if isinstance(n, Input):
            n.value = feed_dict[n]

        L.append(n)
        for m in n.outbound_nodes:
            G[n]['out'].remove(m)
            G[m]['in'].remove(n)
            # if no other incoming edges add to S
            if len(G[m]['in']) == 0:
                S.add(m)
    return L


def forward_pass(output_node, sorted_nodes):
    for node in sorted_nodes:
        node.forward()

    return output_node.value


