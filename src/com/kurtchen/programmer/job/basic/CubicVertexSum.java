/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * 8 numbers, check if it's possible to set the numbers to 8 vertex of a cubic.
 * Let v1 + v2 + v3 + v4 = v5 + v6 + v7 + v8 and v1 + v3 + v5 + v7 = v2 + v4 +
 * v6 + v8 and v1 + v2 + v5 + v6 = v3 + v4 + v7 + v8.
 * 
 * @author Kurt
 */
public class CubicVertexSum {

    public static void main(String[] args) {
        int[] numbers = {
                1, 2, 3, 4, 5, 6, 7, 8
        };

        checkCubicVertexSum(numbers);
    }

    private static void checkCubicVertexSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        doCheckCubicVertexSumInternal(numbers, 0);
    }

    private static void doCheckCubicVertexSumInternal(int[] numbers, int index) {
        
        if (index == numbers.length - 1) {
            if(numbers[0] + numbers[1] + numbers[2] + numbers[3] == numbers[4] + numbers[5] + numbers[6] + numbers[7] && 
                    numbers[0] + numbers[2] + numbers[4] + numbers[6] == numbers[1] + numbers[3] + numbers[5] + numbers[7] && 
                    numbers[0] + numbers[1] + numbers[4] + numbers[5] == numbers[2] + numbers[3] + numbers[6] + numbers[7]){
                System.out.print("Find a solution: ");
                
                for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i] + " ");
                }
                
                System.out.println();
            }
            
            return;
        }
        
        
        for (int i = index; i < numbers.length; i++) {
            
            int tmp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = tmp;
            
            doCheckCubicVertexSumInternal(numbers, index + 1);
            
            tmp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = tmp;
        }

    }

}
