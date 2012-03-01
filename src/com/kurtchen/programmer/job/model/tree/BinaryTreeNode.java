/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 * 
 */

package com.kurtchen.programmer.job.model.tree;

import com.kurtchen.programmer.job.model.Node;

/**
 * Node for tree.
 * 
 * @author kurt
 */
public class BinaryTreeNode<T> extends Node<T> {

    private BinaryTreeNode<T> left; // the right child is in parent class

    public BinaryTreeNode() {
        
    }
    
    public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        super(value, right);
        
        this.left = left;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return (BinaryTreeNode<T>)getNext();
    }

    public void setRight(BinaryTreeNode<T> right) {
        setNext(right);
    }

}
