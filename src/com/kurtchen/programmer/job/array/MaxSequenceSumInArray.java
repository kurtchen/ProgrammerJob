/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.array;

/**
 * Get the max sum of a sequence of numbers in an array.
 * 
 * @author Kurt
 */
public class MaxSequenceSumInArray {

    public static void main(String[] args) {

        int[] array = {
                1, -2, 3, 10, -4, 7, 2, -5
        };

        int maxSum = maxSequenceSumInArray(array);
        
        System.out.println(maxSum);
    }

    private static int maxSequenceSumInArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < array.length; i++) {
            
            if(curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if(curSum > maxSum) {
                maxSum = curSum;
            }
        }
        
        return maxSum;
    }

}
