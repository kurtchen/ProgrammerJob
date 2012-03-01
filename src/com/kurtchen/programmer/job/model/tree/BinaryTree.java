/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.model.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary tree.
 * 
 * @author Kurt
 */
public class BinaryTree<E> {
    
    protected BinaryTreeNode<E> root;

    public BinaryTree() {

    }

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public void preorder() {
        preorder(root);
        
        System.out.println();
    }

    private void preorder(BinaryTreeNode<E> node) {
        if (node != null) {
            visit(node);

            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void inorder() {
        inorder(root);
        
        System.out.println();
    }

    private void inorder(BinaryTreeNode<E> node) {
        if (node != null) {
            inorder(node.getLeft());

            visit(node);

            inorder(node.getRight());
        }
    }

    public void postorder() {
        postorder(root);
        
        System.out.println();
    }

    private void postorder(BinaryTreeNode<E> node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());

            visit(node);
        }
    }

    private void visit(BinaryTreeNode<E> node) {
        if (node != null) {
            System.out.print(node.getValue());
            System.out.print(" ");
        }
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public void levelOrder() {
        levelOrder(root);
    }
    
    private void levelOrder(BinaryTreeNode<E> node) {
        
        if(node == null) {
            return;
        }
        
        Queue<BinaryTreeNode<E>> queue = new LinkedList<BinaryTreeNode<E>>();
        
        queue.offer(node);
        
        while(queue.size() > 0){
            BinaryTreeNode<E> parent = queue.poll();
            
            visit(parent);
            
            if(parent.getLeft() != null) {
                queue.offer(parent.getLeft());
            }
            
            if(parent.getRight() != null) {
                queue.offer(parent.getRight());
            }
        }
    }

}
