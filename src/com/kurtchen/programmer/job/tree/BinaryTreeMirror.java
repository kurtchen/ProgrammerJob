/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.tree;

import com.kurtchen.programmer.job.model.tree.BinarySearchTree;
import com.kurtchen.programmer.job.model.tree.BinaryTreeNode;

/**
 * Get mirror of binary tree.
 *
 * @author Kurt
 */
public class BinaryTreeMirror {

    private static <T> void mirrorBinaryTree(BinaryTreeNode<T> root) {
        if(root == null || root.getLeft() == null && root.getRight() == null) {
            return;
        }
        
        BinaryTreeNode<T> tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
        
        if(root.getLeft() != null) {
            mirrorBinaryTree(root.getLeft());
        }
        
        if(root.getRight() != null) {
            mirrorBinaryTree(root.getRight());
        }
    }

    public static void main(String[] args) {
        //                 8
        //                / \
        //               7   9
        //              /     \
        //             2      14
        //            / \
        //           1   6
        Integer[] tree1Elements = {8,7,9,2,14,6,1};
        
        BinarySearchTree<Integer> tree1 = BinarySearchTree.generateBinarySearchTree(tree1Elements);
        
        tree1.preorder();
        
        mirrorBinaryTree(tree1.getRoot());
        
        tree1.preorder();
    }
}
