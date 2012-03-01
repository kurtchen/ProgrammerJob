/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Ugly number is the number only can be divided by 2,3,5.
 * 
 * Find the Nth ugly number.
 *
 * @author Kurt
 */
public class UglyNumber {

    public static void main(String[] args) {
        int uglyNumber = getUglyNumber(1500);
        System.out.println(uglyNumber);
    }

    private static int getUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int[] uglyNumbers = new int[n];
        
        uglyNumbers[0] = 1;
        
        for (int i = 1; i < uglyNumbers.length; i++) {
            uglyNumbers[i] = Integer.MAX_VALUE;
        }
        
        int next = 0;
        
        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;
        
        while(next < n) {
            int min = min(uglyNumbers[multiply2Index] * 2, uglyNumbers[multiply3Index] * 3, uglyNumbers[multiply5Index] * 5);
            
            uglyNumbers[next] = min;
            
            while(uglyNumbers[multiply2Index] * 2 <= min) {
                multiply2Index++;
            }
            
            while(uglyNumbers[multiply3Index] * 3 <= min) {
                multiply3Index++;
            }
            
            while(uglyNumbers[multiply5Index] * 5 <= min) {
                multiply5Index++;
            }
            
            next++;
        }
        
        return uglyNumbers[next - 1];
    }

    private static int min(int i, int j, int k) {
        int min = Math.min(i, j);
        return Math.min(min, k);
    }

}
