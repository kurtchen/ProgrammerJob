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
 * Check if one tree is sub tree of another one.
 *
 * @author Kurt
 */
public class CheckSubTree {

    private static <T extends Comparable<T>> boolean hasSubTree(BinaryTreeNode<T> root1,
            BinaryTreeNode<T> root2) {
        
        boolean result = false;
        
        if (root1 == null || root2 == null) {
            return result;
        }
        
        T value1 = root1.getValue();
        T value2 = root2.getValue();
        
        if(value1 != null && value1.equals(value2)) {
            result = hasSubTreeInternal(root1, root2);
        }
        
        if(!result) {
            result = hasSubTree(root1.getLeft(), root2);
        }
        
        if(!result) {
            result = hasSubTree(root1.getRight(), root2);
        }
        
        return result;
    }
    
    private static <T extends Comparable<T>> boolean hasSubTreeInternal(BinaryTreeNode<T> root1,
            BinaryTreeNode<T> root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        T value1 = root1.getValue();
        T value2 = root2.getValue();

        if (value1 == null && value2 != null || value1 != null && !value1.equals(value2)) {
            return false;
        }

        return hasSubTreeInternal(root1.getLeft(), root2.getLeft())
                && hasSubTreeInternal(root1.getRight(), root2.getRight());
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
        
        //             2
        //            / \
        //           1   6
        Integer[] tree2Elements = {2,1,6};
        
        BinarySearchTree<Integer> tree2 = BinarySearchTree.generateBinarySearchTree(tree2Elements);
        
        tree2.preorder();
        
        boolean hasSub = hasSubTree(tree1.getRoot(), tree2.getRoot());
        
        System.out.println("->" + hasSub);
        
        //             7
        //            / \
        //           2   8
        Integer[] tree3Elements = {7,2,8};
        
        BinarySearchTree<Integer> tree3 = BinarySearchTree.generateBinarySearchTree(tree3Elements);
        
        tree3.preorder();
        
        boolean hasSub1 = hasSubTree(tree1.getRoot(), tree3.getRoot());
        
        System.out.println("->" + hasSub1);
    }

}
