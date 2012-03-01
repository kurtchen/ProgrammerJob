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
 * Merge two sorted linked list.
 * 
 * @author Kurt
 */
public class MergeLinkedList {

    public static <T extends Comparable<T>> Node<T> mergeLinedList(Node<T> head1, Node<T> head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node<T> p1 = head1;
        Node<T> p2 = head2;

        Node<T> newHead = null;
        
        if (p1.getValue().compareTo(p2.getValue()) < 0) {
            newHead = p1;
            p1 = p1.getNext();
        } else {
            newHead = p2;
            p2 = p2.getNext();
        }
        
        Node<T> pNew = newHead;

        while(p1 != null && p2 != null) {
            if (p1.getValue().compareTo(p2.getValue()) < 0) {
                pNew.setNext(p1);
                pNew = p1;
                p1 = p1.getNext();
            } else {
                pNew.setNext(p2);
                pNew = p2;
                p2 = p2.getNext();
            }
        }
        
        if(p1 != null) {
            pNew.setNext(p1);
        } else if(p2 != null) {
            pNew.setNext(p2);
        }
        
        return newHead;
    }
    
    public static <T extends Comparable<T>> Node<T> mergeLinedListRecurse(Node<T> head1, Node<T> head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        
        Node<T> newHead = null;
        
        if (head1.getValue().compareTo(head2.getValue()) < 0) {
            newHead = head1;
            newHead.setNext(mergeLinedListRecurse(newHead.getNext(), head2));
        } else {
            newHead = head2;
            newHead.setNext(mergeLinedListRecurse(head1, newHead.getNext()));
        }
        
        return newHead;
    }

    public static void main(String[] args) {
        Integer[] elements1 = {
                1, 3, 5, 7, 9, 11, 13, 15
        };

        LinkedList<Integer> list1 = new LinkedList<Integer>(elements1);
        
        Integer[] elements2 = {
                2, 4, 6, 8, 10, 12, 14, 16
        };
        
        LinkedList<Integer> list2 = new LinkedList<Integer>(elements2);
        
//        Node<Integer> newHead = mergeLinedList(list1.getHead(), list2.getHead());
        Node<Integer> newHead = mergeLinedListRecurse(list1.getHead(), list2.getHead());
        
        while (newHead != null) {
            System.out.print(newHead.getValue());
            System.out.print(" ");
            
            newHead = newHead.getNext();
        }
    }

}
