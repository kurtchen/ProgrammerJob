/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Fibonacci.
 *
 * @author Kurt
 */
public class Fibonacci {

    public static int fibonacciRecursive(int n){
        if(n <= 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }
        
        int n1 = 0;
        int n2 = 1;
        int tmp = 0;
        
        for (int i = 2; i <= n; i++) {
            tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
        }
        
        return n2;
    }
    
    public static void main(String[] args) {
        System.out.println("recurse:" + fibonacciRecursive(15));
        System.out.println("iterative:" + fibonacci(15));
    }

}
