/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.model.linkedlist;

import com.kurtchen.programmer.job.model.Node;

/**
 * The linked list.
 * 
 * @author Kurt
 */
public class LinkedList<E> {

    private Node<E> head;

    private Node<E> tail;

    public LinkedList() {

    }

    public LinkedList(E[] elements) {
        if (elements != null && elements.length > 0) {
            for (int i = 0; i < elements.length; i++) {
                insert(elements[i]);
            }
        }
    }

    public void insert(E element) {

        if (element == null) {
            throw new NullPointerException("Element can't be null");
        }

        Node<E> node = new Node<E>();
        node.setValue(element);

        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void deleteNode(Node<E> node) {

        if (head == null || node == null) {
            return;
        }

        if (node.getNext() != null) {
            Node<E> next = node.getNext();

            node.setValue(next.getValue());
            node.setNext(next.getNext());

            next = null;
        } else if (node == head) { // list contains only head, delete it
            head = null;
            node = null;
        } else { // delete tail
            Node<E> tmpNode = head;

            while (tmpNode != null && tmpNode.getNext() != null && tmpNode.getNext() != node) {
                tmpNode = tmpNode.getNext();
            }

            if (tmpNode != null) {
                tmpNode.setNext(null);
                tail = tmpNode;
            }
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        int size = 0;

        Node<E> node = head;

        while (node != null) {
            size++;
            node = node.getNext();
        }

        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public void dumpList() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node<E> node = head;

        while (node != null) {
            System.out.print(node.getValue());
            System.out.print(" ");

            node = node.getNext();
        }

        System.out.println();
    }
}
