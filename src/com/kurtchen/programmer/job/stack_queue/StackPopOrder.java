/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.stack_queue;

import java.util.Stack;

/**
 * Check if some sequence is stack pop order.
 *
 * @author Kurt
 */
public class StackPopOrder {

    
    private static <T> boolean isPopOrder(T[] pushOrder, T[] popOrder) {
        if (pushOrder == null || pushOrder.length == 0 || popOrder == null || popOrder.length == 0) {
            return false;
        }
        
        int nextPush = 0;
        int nextPop = 0;
        
        Stack<T> stack = new Stack<T>();
        
        while(nextPop < popOrder.length) {
            
            while(stack.size() == 0 || !stack.peek().equals(popOrder[nextPop])) {
                
                if(nextPush >= pushOrder.length) {
                    break;
                }
                
                stack.push(pushOrder[nextPush]);
                nextPush++;
            }
            
            if(!popOrder[nextPop].equals(stack.peek())) {
                break;
            }
            
            stack.pop();
            nextPop++;
        }
        
        if(stack.size() == 0 && nextPop == popOrder.length) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        Integer[] pushOrder = {1,2,3,4,5};
        Integer[] popOrder = {4,5,3,2,1};
        
        boolean isPopOrder = isPopOrder(pushOrder, popOrder);
        System.out.println("->" + isPopOrder);
        
        Integer[] popOrder1 = {4,3,5,1,2};
        isPopOrder = isPopOrder(pushOrder, popOrder1);
        System.out.println("->" + isPopOrder);
    }

}
