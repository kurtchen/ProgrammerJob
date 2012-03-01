/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.linkedlist;

/**
 * Clone a complex linked list.
 * 
 * @author Kurt
 */
public class ComplexLinkedListClone {

    public static void main(String[] args) {

        ComplexLinkedListNode orgListHead = generateComplexLinkedList();

        printList(orgListHead);
        
        ComplexLinkedListNode list = cloneNode(orgListHead);
        
        printList(list);
        
        list = connectSiblingNodes(list);
        
        printList(list);
        
        list = reconnectNodes(list);
        
        printList(list);
        
        printList(orgListHead);
    }

    private static void printList(ComplexLinkedListNode head) {
        while (head != null) {
            System.out.print("[" + head.value + "," + (head.sibling == null ? "" : head.sibling.value) + "]");
            System.out.print(" ");
            
            head = head.next;
        }
        
        System.out.println();
    }

    private static ComplexLinkedListNode reconnectNodes(ComplexLinkedListNode head) {

        if (head == null) {
            return null;
        }

        ComplexLinkedListNode node = head;
        ComplexLinkedListNode newHead = head.next;
        ComplexLinkedListNode newNode = head.next;

        while (node != null) {
            node.next = newNode.next;
            
            if(node.next != null) {
                newNode.next = node.next.next;
            }

            node = node.next;
            newNode = newNode.next;
        }

        return newHead;
    }

    private static ComplexLinkedListNode connectSiblingNodes(ComplexLinkedListNode head) {
        if (head == null) {
            return null;
        }

        ComplexLinkedListNode node = head;

        while (node != null) {

            if (node.sibling != null) {
                node.next.sibling = node.sibling.next;
            }
            
            node = node.next.next;
        }

        return head;
    }

    private static ComplexLinkedListNode cloneNode(ComplexLinkedListNode orgListHead) {
        if (orgListHead == null) {
            return null;
        }

        ComplexLinkedListNode node = orgListHead;

        while (node != null) {
            ComplexLinkedListNode newNode = new ComplexLinkedListNode();
            newNode.value = node.value;
            newNode.next = node.next;

            node.next = newNode;

            node = newNode.next;
        }

        return orgListHead;
    }

    private static ComplexLinkedListNode generateComplexLinkedList() {
        // Create the complex linked list
        ComplexLinkedListNode orginalListHead = null;

        ComplexLinkedListNode prev = null;

        for (int i = 0; i < 10; i++) {

            ComplexLinkedListNode node = new ComplexLinkedListNode();
            node.value = i;

            if (i == 0) {
                orginalListHead = node;
                prev = orginalListHead;
            }

            if (prev != null) {
                prev.next = node;
            }
            
            if(i > 0) {
                prev = node;
            }
        }

        orginalListHead.sibling = orginalListHead.next.next;
        orginalListHead.next.sibling = orginalListHead.next.next.next.next;
        orginalListHead.next.next.next.sibling = orginalListHead.next;

        return orginalListHead;
    }

}

class ComplexLinkedListNode {

    int value;

    ComplexLinkedListNode next;

    ComplexLinkedListNode sibling;
}
