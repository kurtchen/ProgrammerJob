/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 * 
 */

package com.kurtchen.programmer.job.model;

/**
 * Node for linked list.
 * 
 * @author Kurt
 */
public class Node<T> {

    private T value;

    private Node<T> next;

    public Node() {
        
    }
    
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}