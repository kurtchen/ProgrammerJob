/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.string;

import java.util.Stack;

/**
 * Get the combination of a char array.
 * 
 * @author Kurt
 */
public class StringCombination {

    private static void doStringCombination(char[] string) {
        
        if (string == null || string.length == 0) {
            return;
        }

        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 1; i <= string.length; i++) {
            stack.clear();
            
            doStringCombinationInternal(string, 0, i, stack);
        }
    }

    private static void doStringCombinationInternal(char[] string, int index, int num, Stack<Character> stack) {
        
        if(num == 0) {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i));
            }
            System.out.println();
            
            return;
        }
        
        if(index == string.length) {
            return;
        }
        
        // Select this char
        stack.push(string[index]);
        doStringCombinationInternal(string, index + 1, num - 1, stack);
        
        // Don't select this char
        stack.pop();
        doStringCombinationInternal(string, index + 1, num, stack);
    }

    public static void main(String[] args) {

        char[] string = {
                'a', 'b', 'c'
        };

        doStringCombination(string);
    }
}
