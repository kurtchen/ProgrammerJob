/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.tree;

import com.kurtchen.programmer.job.model.tree.BinarySearchTree;
import com.kurtchen.programmer.job.model.tree.BinaryTreeNode;

import java.util.Stack;

/**
 * Find all the path in a tree which the sum is a given value.
 *
 * @author Kurt
 */
public class TreePathInSpecificSum {
    
    private static void findTreePathInSpecificSum(BinaryTreeNode<Integer> root, int expectedSum) {
        if(root == null) {
            return;
        }
        
        Stack<BinaryTreeNode<Integer>> nodesStack = new Stack<BinaryTreeNode<Integer>>();
        
        findTreePathInSpecificSumInternal(root, expectedSum, nodesStack, 0);
        
    }

    private static void findTreePathInSpecificSumInternal(BinaryTreeNode<Integer> root,
            int expectedSum, Stack<BinaryTreeNode<Integer>> nodesStack, int currentSum) {
        
        currentSum += root.getValue();
        nodesStack.push(root);
        
        if(root.getLeft() == null && root.getRight() == null && currentSum == expectedSum) {
            System.out.print("A path is found:");
            
            for (int i = 0; i < nodesStack.size(); i++) {
                System.out.print(nodesStack.get(i).getValue());
                System.out.print(" ");
            }
            
            System.out.println();
        }
        
        if(root.getLeft() != null) {
            findTreePathInSpecificSumInternal(root.getLeft(), expectedSum, nodesStack, currentSum);
        }
        
        if(root.getRight() != null) {
            findTreePathInSpecificSumInternal(root.getRight(), expectedSum, nodesStack, currentSum);
        }
        
        currentSum -= root.getValue();
        nodesStack.pop();
    }

    public static void main(String[] args) {
        //                 10
        //                / \
        //               5   12
        //              / \    
        //             4   7     
        Integer[] tree1Elements = {10,5,12,4,7};
        
        BinarySearchTree<Integer> tree = BinarySearchTree.generateBinarySearchTree(tree1Elements);
        
        findTreePathInSpecificSum(tree.getRoot(), 22);
    }

}
