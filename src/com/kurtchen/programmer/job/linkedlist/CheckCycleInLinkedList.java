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
 * Check cycle in linked list.
 * 
 * @author Kurt
 */
public class CheckCycleInLinkedList {

    public static <T> boolean isThereCycleInLinkedList(LinkedList<T> list) {
        if (list == null || list.getHead() == null) {
            return false;
        }

        Node<T> fast = list.getHead();
        Node<T> slow = list.getHead();

        while (fast != null) {
            fast = fast.getNext();

            if (fast == null) {
                return false;
            }

            fast = fast.getNext();

            slow = slow.getNext();

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static <T> Node<T> findLoopPoint(LinkedList<T> list) {
        if (list == null || list.getHead() == null) {
            return null;
        }

        Node<T> fast = list.getHead();
        Node<T> slow = list.getHead();

        while (fast != null) {
            fast = fast.getNext();

            if (fast == null) {
                return null;
            }

            fast = fast.getNext();

            slow = slow.getNext();

            if (fast == slow) {
                break;
            }
        }

        slow = list.getHead();

        while (slow != fast) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {
        String[] elements = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16"
        };

        LinkedList<String> list = new LinkedList<String>(elements);

        list.getTail().setNext(list.getHead().getNext().getNext().getNext().getNext().getNext());

        System.out.println(isThereCycleInLinkedList(list));

        System.out.println(findLoopPoint(list).getValue());
    }

}
