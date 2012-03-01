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
 * Find nth element in a linked list.
 * 
 * @author Kurt
 */
public class NThElementInLinkedList {

    public static <T> T findNThElement(Node<T> head, int n) {
        if (head == null) {
            throw new NullPointerException("list can't be null");
        }

        if (n <= 0) {
            throw new IllegalArgumentException("n must > 0");
        }

        Node<T> fast = head;
        Node<T> slow = head;

        // Let fast pointer move ahead with n elements
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();

            if (i < n - 1 && fast == null) {
                throw new IllegalArgumentException("n is greater than list size!");
            }

            // It's the tail element
            if (i == n - 1 && fast == null) {
                return slow.getValue();
            }
        }

        // Move slow pointer together with the fast pointer
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow.getValue();
    }

    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16"
        };

        LinkedList<String> list = new LinkedList<String>(elements);

        String found = null;
        try {
            found = NThElementInLinkedList.findNThElement(list.getHead(), 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found != null) {
            System.out.println(found);
        }

        found = null;
        try {
            found = NThElementInLinkedList.findNThElement(list.getHead(), 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found != null) {
            System.out.println(found);
        }

        found = null;
        try {
            found = NThElementInLinkedList.findNThElement(list.getHead(), 16);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found != null) {
            System.out.println(found);
        }

        found = null;
        try {
            found = NThElementInLinkedList.findNThElement(list.getHead(), 17);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found != null) {
            System.out.println(found);
        }

        found = null;
        try {
            found = NThElementInLinkedList.findNThElement(list.getHead(), 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (found != null) {
            System.out.println(found);
        }
    }
}
