package com.kurtchen.programmer.job.tree;

import com.kurtchen.programmer.job.model.tree.BinarySearchTree;
import com.kurtchen.programmer.job.model.tree.BinaryTreeNode;

/**
 * @author kurt
 */
public class BST2DobuleLinkedList {

    public static void main(String[] args) {
        //                 10
        //                /  \
        //               6    14
        //              / \   / \
        //             4   8 12  16
        Integer[] tree1Elements = {10,6,14,4,8,12,16};
        
        BinarySearchTree<Integer> tree = BinarySearchTree.generateBinarySearchTree(tree1Elements);
        
        BinaryTreeNode<Integer> head = convertBST2DoubleLinkedList(tree.getRoot());
        
        while(head != null) {
            System.out.print(head.getValue());
            System.out.print(" ");
            
            head = head.getRight();
        }
        
        System.out.println();
    }

    private static <T> BinaryTreeNode<T> convertBST2DoubleLinkedList(BinaryTreeNode<T> root) {
        
        BinaryTreeNode<T> head = convertBST2DoubleLinkedListInternal(root, null);

        BinaryTreeNode<T> prev = head;
        
        while (head != null) {
            prev = head;
            head = head.getLeft();
        }
        
        return prev;
    }

    private static <T> BinaryTreeNode<T> convertBST2DoubleLinkedListInternal(
            BinaryTreeNode<T> root, BinaryTreeNode<T> previousNode) {
        
        if(root == null) {
            return previousNode;
        }
        
        BinaryTreeNode<T> current = root;
        
        if(root.getLeft() != null) {
            previousNode = convertBST2DoubleLinkedListInternal(root.getLeft(), previousNode);
        }
        
        current.setLeft(previousNode);
        
        if(previousNode != null) {
            previousNode.setRight(current);
        }
        
        previousNode = current;
        
        if(root.getRight() != null) {
            previousNode = convertBST2DoubleLinkedListInternal(root.getRight(), previousNode);
        }
        
        return previousNode;
    }

}