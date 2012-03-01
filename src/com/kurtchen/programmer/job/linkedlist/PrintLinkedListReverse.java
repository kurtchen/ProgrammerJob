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
 * 
 *
 * @author Kurt
 */
public class PrintLinkedListReverse {

    public static <T> void printLinkedListReverse(Node<T> node){
        if(node != null) {
            printLinkedListReverse(node.getNext());
            
            System.out.print(node.getValue());
            System.out.print(" ");
        }
    }
    
    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16"
        };

        LinkedList<String> list = new LinkedList<String>(elements);

        printLinkedListReverse(list.getHead());
    }

}
