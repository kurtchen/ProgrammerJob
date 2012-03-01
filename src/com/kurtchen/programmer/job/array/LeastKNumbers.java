/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.array;

/**
 * Find K least numbers in an array.
 * 
 * @author Kurt
 */
public class LeastKNumbers {

    public static void main(String[] args) {

        Integer[] array = {
                4, 5, 1, 6, 2, 7, 3, 8
        };

        Integer[] result = new Integer[4];

        findLeastNumbers(array, 4, result);

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        if (findLeastNumbersSolution2(array, 4)) {

            for (int i = 0; i < 4; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static <T extends Comparable<T>> boolean findLeastNumbersSolution2(T[] array, int k) {
        if (array == null || array.length < k) {
            return false;
        }
        
        int start = 0;
        int end = array.length - 1;
        
        int index = partition(array, start, end);
        
        while(index != k -1) {
            if(index < k - 1) {
                
                start = index + 1;
                index = partition(array, start, end);
            } else {
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        
        return true;
    }

    private static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
        T pivot = array[end];
        
        int i = start;
        
        for (int j = start; j <= end; j++) {
            if(array[j].compareTo(pivot) <= 0) {
                
                T tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                
                i++;
            }
        }
        
        if (i < end) {
            T tmp = array[i];
            array[i] = array[end];
            array[end] = tmp;
            
            return i;
        }
        
        return end;
    }

    private static <T extends Comparable<T>> void findLeastNumbers(T[] array, int k, T[] result) {
        if (array == null || array.length < k || result == null || result.length != k) {
            return;
        }

        int currentIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (currentIndex < k) {
                result[currentIndex] = array[i];
                currentIndex++;
            } else {

                for (int j = result.length / 2; j >= 0; j--) {
                    maxHeapify(result, j);
                }

                if (result[0].compareTo(array[i]) > 0) {
                    result[0] = array[i];
                }
            }
        }
    }

    private static <T extends Comparable<T>> void maxHeapify(T[] array, int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        int max = index;

        if (left < array.length && array[left].compareTo(array[max]) > 0) {
            max = left;
        }

        if (right < array.length && array[right].compareTo(array[max]) > 0) {
            max = right;
        }

        if (max != index) {
            T tmp = array[max];
            array[max] = array[index];
            array[index] = tmp;

            maxHeapify(array, max);
        }
    }

}
