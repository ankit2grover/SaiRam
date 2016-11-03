# -*- coding: utf-8 -*-
"""
Created on Fri Oct 14 13:19:59 2016

@author: tkmaea9
"""

"""Count words."""

from copy import deepcopy
from collections import OrderedDict
import sys
sys.setrecursionlimit(100000) # 10000 is an example, try with different values


def mergeDescSort(start, end, list):
    if (start < end ):
        mid = (end - start) / 2
        list = mergeDescSort(start, mid, list)
        list = mergeDescSort(mid+ 1, end, list)
        return merge(start, mid, end, list)
    return list

def merge(start, mid, end, list):
    left = start
    right = mid + 1
    new_list = []
    while (left <= mid and right <= end):
        leftValue = list[left][1]
        rightValue = list[right][1]
        rightKey = list[right][0]
        leftKey = list[left][0]
        if (leftValue > rightValue):
            item = (leftKey, leftValue)
            new_list.append(item)
            left = left + 1
        else :
            item = (rightKey, rightValue)
            new_list.append(item)
            right += 1
      
        
    while (left <= mid):
        leftValue = list[left][1]
        leftKey = list[left][0]
        item = (leftKey, leftValue)
        new_list.append(item)
        left +=1
        
    while (right <= end):
        rightValue = list[right][1]
        rightKey = list[right][0]
        item = (rightKey, rightValue)
        new_list.append(item)
        right += 1
        
    index = 0
    for list_item in new_list:
        key = list_item[0]
        value = list_item[1]
        list[index] = (key, value)
        index +=1 
        
    return list
        
        
        
def count_words(s, n):
    """Return the n most frequently occuring words in s."""
    words = s.split()
    count_dict = {}
    for word in words:
        if word in count_dict:
            count_dict[word] += 1
        else:
            count_dict[word] = 1
    
    #list_key_value = [(k,v) for k, v in count_dict.items() ]
    print count_dict 
    
    #list = mergeDescSort(0, len(count_dict) - 1, list_key_value)
    #print list
    # TODO: Count the number of occurences of each word in s
    
    # TODO: Sort the occurences in descending order (alphabetically in case of ties)
    #from collections import OrderedDict    
    ordered_dict = sorted(count_dict.items(), key=lambda t: t[0])
    ordered_dict = sorted(ordered_dict, key=lambda t: t[1], reverse=True)
    #ordered_dict = sorted(count_dict.values(), reverse=True)
    
    print ordered_dict
    # TODO: Return the top n words as a list of tuples (<word>, <count>)
    #items = ordered_dict.items()
    
    top_n = ordered_dict[: n]
    return top_n


def test_run():
    """Test count_words() with some inputs."""
    print count_words("cat bat mat cat bat cat", 3)
    print count_words("betty bought a bit of butter but the butter was bitter", 3)


if __name__ == '__main__':
    test_run()