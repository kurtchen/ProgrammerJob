/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.tree;

import com.kurtchen.programmer.job.model.tree.BinaryTree;
import com.kurtchen.programmer.job.model.tree.BinaryTreeNode;

/**
 * Rebuild tree from pre-order and in-order result.
 * 
 * @author Kurt
 */
public class ReBuildTree {

    public static BinaryTreeNode<Integer> rebuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        return rebuildTreeInternal(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static BinaryTreeNode<Integer> rebuildTreeInternal(int[] preorder, int preorderStart,
            int preorderEnd, int[] inorder, int inorderStart, int inorderEnd) {

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.setValue(preorder[preorderStart]);

        if (preorderStart == preorderEnd) {
            if (inorderStart == inorderEnd && preorder[preorderStart] == inorder[inorderStart]) {
                return root;
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        }

        int rootInorder = -1;

        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == root.getValue()) {
                rootInorder = i;
            }
        }

        if (rootInorder < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int leftTreeLength = rootInorder - inorderStart;
        int rightPreoder = preorderStart + leftTreeLength;

        if (leftTreeLength > 0) {
            root.setLeft(rebuildTreeInternal(preorder, preorderStart + 1, rightPreoder, inorder,
                    inorderStart, rootInorder - 1));
        }

        if (leftTreeLength < preorderEnd - preorderStart) {
            root.setRight(rebuildTreeInternal(preorder, rightPreoder + 1, preorderEnd, inorder,
                    rootInorder + 1, inorderEnd));
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {
                1, 2, 4, 7, 3, 5, 6, 8
        };
        int[] inorder = {
                4, 7, 2, 1, 5, 3, 8, 6
        };

        BinaryTreeNode<Integer> root = null;
        
        try {
            root = rebuildTree(preorder, inorder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(root != null) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
            tree.preorder();
            System.out.println();
            tree.inorder();
            System.out.println();
            tree.postorder();
        }
    }

}
