/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.array;

/**
 * Median is the number appears in an array for more than half array length
 * times.
 * 
 * @author Kurt
 */
public class FindMedianInArray {

    public static void main(String[] args) {

        Integer[] array = {
                1, 2, 3, 2, 2, 2, 5, 4, 2
        };

        Integer result = findMedianInArray(array);
        System.out.println(result);
    }

    private static <T> T findMedianInArray(T[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }

        int count = 1;
        T result = array[0];

        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count = 1;
            } else if (array[i].equals(result)) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }

}
