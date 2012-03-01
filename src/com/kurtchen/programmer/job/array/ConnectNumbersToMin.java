/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.array;

import com.kurtchen.android.algorithm.sort.ISort;
import com.kurtchen.android.algorithm.sort.SortAlgorithmFactory;
import com.kurtchen.android.algorithm.sort.SortAlgorithmFactory.SortAlgorithmType;

import java.util.Comparator;

/**
 * Here's a number array, find a way to connect the numbers to make it the smallest number. 
 *
 * @author Kurt
 */
public class ConnectNumbersToMin {

    public static void main(String[] args) {
        int[] array = {3,32,321};
        
        String number = connectNumbersToMin(array);
        
        System.out.println(number);
    }

    private static String connectNumbersToMin(int[] array) {
        
        if(array == null || array.length == 0) {
            return null;
        }
        
        String[] strArray = new String[array.length];
        
        for (int i = 0; i < array.length; i++) {
            strArray[i] = String.valueOf(array[i]);
        }
        
        StringNumberComparator comparator = new StringNumberComparator();
        
        ISort sortAlg = SortAlgorithmFactory.getSortAlgorithm(SortAlgorithmType.QUICK);
        sortAlg.sort(strArray, comparator);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
        }
        
        return sb.toString();
    }

}

class StringNumberComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return 0;
        }
        
        String connect1 = s1 + s2;
        String connect2 = s2 + s1;
        
        return connect1.compareTo(connect2);
    }
    
}