/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.bit;

/**
 * Get the number of 1 in bit form of some number.
 *
 * @author Kurt
 */
public class NumberOf1 {

    public static int numberOf1A(int num) {
        if(num < 0) { // Hack for negative numbers
            num = ~num + 1;
        }
        
        int count = 0;
        
        while(num > 0) {
            
            if((num & 1) == 1) {
                count++;
            }
            
            num = num >> 1;
        }
        
        return count;
    }
    
    public static int numberOf1B(int num) {
        if(num < 0) { // Hack for negative numbers
            num = ~num + 1;
        }
        
        int count = 0;
        long flag = 1;
        
        while(flag != 0) {
            
            if((num & flag) == flag) {
                count++;
            }
            
            flag = flag << 1;
        }
        
        return count;
    }
    
    public static int numberOf1C(int num) {
        
        if(num < 0) { // Hack for negative numbers
            num = ~num + 1;
        }
        
        int count = 0;
        
        while(num != 0) {
            count++;
            
            num = num & (num - 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("9 = " + Integer.toBinaryString(9));
        System.out.println("method 1: " + numberOf1A(9));
        
        System.out.println("-9 = " + Integer.toBinaryString(-9));
        System.out.println("method 2: " + numberOf1B(-9));


        System.out.println("9 = " + Integer.toBinaryString(9));
        System.out.println("method 3: " + numberOf1C(-9));

    }

}
