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
 * Get the middle of the linked list.
 * 
 * @author Kurt
 */
public class GetMiddleOfLinkedList {

    public static <T> Node<T> getMiddleOfLinkedList(LinkedList<T> list) {
        if (list == null || list.getHead() == null) {
            return null;
        }

        Node<T> fast = list.getHead();
        Node<T> slow = list.getHead();

        while (fast != null) {
            fast = fast.getNext();
            
            if (fast == null) {
                break;
            }
            
            fast = fast.getNext();

            slow = slow.getNext();
        }
        
        return slow;
    }

    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                /*"16"*/
        };

        LinkedList<String> list = new LinkedList<String>(elements);
        
        System.out.println(getMiddleOfLinkedList(list).getValue());
    }

}
