/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.bit;

/**
 * Check if a number is 2 power n. 
 *
 * @author Kurt
 */
public class Is2power {

    public static boolean is2power(int num) {
        if(num < 0) { // Hack for negative numbers
            num = ~num + 1;
        }
        
        if ((num & (num - 1)) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("16 " + is2power(16));
        System.out.println("216 " + is2power(216));
        System.out.println("512 " + is2power(512));
        System.out.println("-1000 " + is2power(-1000));
        System.out.println("-2048 " + is2power(-2048));
    }

}
