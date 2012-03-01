/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.tree;

/**
 * Verify if some sequence is post order of a binary search tree.
 *
 * @author Kurt
 */
public class VerifyPostOrderOfBinarySearchTree {
    
    private static <T extends Comparable<T>> boolean isPostOrderOfBinarySearchTree(T[] postOrder, int start, int end) {
        if (postOrder == null || postOrder.length == 0 || start < 0 || start > postOrder.length - 1
                || end < 0 || end > postOrder.length) {
            return false;
        }
        
        T root = postOrder[end];
        
        int i = start;
        
        for (; i < end; i++) {
            if(postOrder[i].compareTo(root) > 0) {
                break;
            }
        }
        
        for (int j = i; j < end; j++) {
            if(postOrder[j].compareTo(root) < 0) {
                return false;
            }
        }
        
        boolean left = true;
        
        if(i > 0) {
            left = isPostOrderOfBinarySearchTree(postOrder, 0 , i - 1);
        }
        
        boolean right = true;
        
        if(i < end - 1) {
            right = isPostOrderOfBinarySearchTree(postOrder, i , end - 1);
        }
        
        return left & right;
    }

    public static void main(String[] args) {
        Integer[] postOrder = {5,7,6,9,11,10,8};
        
        boolean isPostOrder = isPostOrderOfBinarySearchTree(postOrder, 0, postOrder.length - 1);
        System.out.println("->" + isPostOrder);
        
        Integer[] postOrder1 = {7,4,6,5};
        isPostOrder = isPostOrderOfBinarySearchTree(postOrder1, 0, postOrder1.length - 1);
        System.out.println("->" + isPostOrder);
    }

}
