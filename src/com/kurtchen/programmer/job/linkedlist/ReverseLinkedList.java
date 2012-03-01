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
 * Reverse a linked list.
 * 
 * @author Kurt
 */
public class ReverseLinkedList {

    public static <T> Node<T> reverseLinkedList(Node<T> head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        Node<T> prev = null;
        Node<T> node = head;

        while (node != null) {
            Node<T> next = node.getNext();

            node.setNext(prev);

            prev = node;

            if (next == null) {
                return node;
            }

            node = next;
        }

        return null;
    }

    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16"
        };

        LinkedList<String> list = new LinkedList<String>(elements);

        Node<String> newHead = reverseLinkedList(list.getHead());
        
        list.setTail(list.getHead());
        list.setHead(newHead);

        while (newHead != null) {
            System.out.print(newHead.getValue());
            System.out.print(" ");
            
            newHead = newHead.getNext();
        }
    }

}
