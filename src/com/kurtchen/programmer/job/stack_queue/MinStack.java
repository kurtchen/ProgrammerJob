/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.stack_queue;

import java.util.Stack;

/**
 * A stack supports MIN function.
 *
 * @author Kurt
 */
public class MinStack<E extends Comparable<E>> {
    
    private Stack<E> mStack;
    private Stack<E> mMinStack;
    
    public MinStack() {
        mStack = new Stack<E>();
        mMinStack = new Stack<E>();
    }
    
    public void push(E element){
        if(element == null) {
            return;
        }
        
        mStack.push(element);
        
        if(mMinStack.size() == 0 || element.compareTo(mMinStack.peek()) < 0) {
            mMinStack.push(element);
        } else {
            mMinStack.push(mMinStack.peek());
        }
    }
    
    public E pop() {
        mMinStack.pop();
        return mStack.pop();
    }
    
    public E min() {
        return mMinStack.peek();
    }

    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack<Integer>();
        stack.push(3);
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.push(4);
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.push(2);
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.push(1);
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.pop();
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.pop();
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
        stack.push(1);
        
        System.out.println("min=" + stack.min());
        stack.dump();
        
    }

    private void dump() {
        System.out.print("mStack:");
        
        for (int i = 0; i < mStack.size(); i++) {
            System.out.print(mStack.get(i));
            System.out.print(" ");
        }
        
        System.out.println();
        
        System.out.print("mMinStack:");
        
        for (int i = 0; i < mMinStack.size(); i++) {
            System.out.print(mMinStack.get(i));
            System.out.print(" ");
        }
        
        System.out.println();
    }

}
