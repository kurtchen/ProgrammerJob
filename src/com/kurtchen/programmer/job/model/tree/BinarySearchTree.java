/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 * 
 */

package com.kurtchen.programmer.job.model.tree;

/**
 * Binary search tree.
 * 
 * @author Kurt
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{

    public BinarySearchTree() {

    }

    public BinarySearchTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public void insert(E value) {
        root = insert(root, value);
    }

    private BinaryTreeNode<E> insert(BinaryTreeNode<E> node, E value) {
        
        if (node == null) {
            return new BinaryTreeNode<E>(value, null, null);
        }

        int compare = value.compareTo(node.getValue());

        if (compare < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compare > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            // ignore the equal ones
        }
        
        return node;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public static <T extends Comparable<T>> BinarySearchTree<T> generateBinarySearchTree(
            T[] elements) {

        if (elements == null || elements.length == 0) {
            return null;
        }

        BinarySearchTree<T> tree = new BinarySearchTree<T>();

        for (int i = 0; i < elements.length; i++) {
            tree.insert(elements[i]);
        }

        return tree;
    }
}
