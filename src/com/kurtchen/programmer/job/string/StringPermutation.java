/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.string;

/**
 * Permutation of a char array.
 * 
 * @author Kurt
 */
public class StringPermutation {

    private static void doStringPermutation(char[] string) {
        
        if(string == null || string.length == 0) {
            return;
        }
        
        doStringPermutationInternal(string, 0);
    }

    private static void doStringPermutationInternal(char[] string, int index) {
        
        if(index == string.length - 1) {
            System.out.println(string);
            return;
        }
        
        for (int i = index; i < string.length; i++) {
            char tmp = string[index];
            string[index] = string[i];
            string[i] = tmp;
            
            doStringPermutationInternal(string, index + 1);
            
            tmp = string[index];
            string[index] = string[i];
            string[i] = tmp;
        }
        
    }

    public static void main(String[] args) {
        
        char[] string = {
                'a', 'b', 'c'
        };
        
        doStringPermutation(string);
    }
}
