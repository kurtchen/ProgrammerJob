/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.linkedlist;

import com.kurtchen.programmer.job.model.Node;
import com.kurtchen.programmer.job.model.linkedlist.LinkedList;

/**
 * Delete a given node in O(1).
 *
 * @author Kurt
 */
public class DeleteNodeInO1 {

    
    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16"
        };

        LinkedList<String> list = new LinkedList<String>(elements);
        
        list.deleteNode(list.getHead());
        list.dumpList();
        
        list.deleteNode(list.getTail());
        list.dumpList();

        list.deleteNode(list.getHead().getNext().getNext());
        list.dumpList();
        
        list.deleteNode(new Node<String>("8", null));
        list.dumpList();
    }

}
