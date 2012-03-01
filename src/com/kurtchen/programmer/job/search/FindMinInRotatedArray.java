/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.search;

/**
 * [3,4,5,1,2] is a rotation of [1,2,3,4,5], find the MIN number, it's 1 in this
 * case.
 * 
 * @author Kurt
 */
public class FindMinInRotatedArray {

    public static int findMinInRotatedArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array can't be empty");
        }

        if (array.length == 1) {
            return array[0];
        }

        int p1 = 0;
        int p2 = array.length - 1;
        int mid = p1;

        while (array[p1] >= array[p2]) {
            if (p2 - p1 == 1) {
                mid = p2; // find it
                break;
            }

            mid = (p1 + p2) / 2;

            if (array[p1] == array[mid] && array[mid] == array[p2]) {
                return min(array, p1, p2);
            } else if (array[mid] >= array[p1]) {
                p1 = mid;
            } else if (array[mid] <= array[p2]) {
                p2 = mid;
            }
        }

        return array[mid];
    }

    private static int min(int[] array, int p1, int p2) {

        if (array != null && p1 < array.length && p2 < array.length) {
            
            int result = array[p1];
            
            for (int i = p1; i <= p2; i++) {
                
                if (result > array[i]) {
                    result = array[i];
                }
            }
            
            return result;
        }
        
        throw new ArrayIndexOutOfBoundsException("internal error when find the min number");
    }

    public static void main(String[] args) {
        int [] array = {3,4,5,1,2};
        System.out.println(findMinInRotatedArray(array));

        int [] array1 = {1,2,3,4,5};
        System.out.println(findMinInRotatedArray(array1));
        
        int [] array2 = {1,0,1,1,1};
        System.out.println(findMinInRotatedArray(array2));
        
    }

}
