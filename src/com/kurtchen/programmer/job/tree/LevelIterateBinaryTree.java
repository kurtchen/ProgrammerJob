/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.tree;

import com.kurtchen.programmer.job.model.tree.BinarySearchTree;
import com.kurtchen.programmer.job.model.tree.BinaryTree;

/**
 * Iterate binary tree in level order.
 *
 * @author Kurt
 */
public class LevelIterateBinaryTree {

    
    public static void main(String[] args) {
        //                 8
        //                / \
        //               7   9
        //              /     \
        //             2      14
        //            / \
        //           1   6
        Integer[] tree1Elements = {8,7,9,2,14,6,1};
        
        BinaryTree<Integer> tree1 = BinarySearchTree.generateBinarySearchTree(tree1Elements);
        
        tree1.levelOrder();

    }

}
