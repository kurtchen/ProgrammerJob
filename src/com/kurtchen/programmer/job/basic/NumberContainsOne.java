/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Find the times appeared of the numbers contain 1 from 1 to N.
 *
 * @author Kurt
 */
public class NumberContainsOne {

    public static void main(String[] args) {
        int num = numberContainsOne(21345);
        System.out.println(num);
    }

    private static int numberContainsOne(int n) {
        if(n <= 0) {
            return 0;
        }
        
        char[] strN = String.valueOf(n).toCharArray();
        
        return numberContainsOneInternal(strN, 0);
    }

    private static int numberContainsOneInternal(char[] strN, int index) {
        
        if(index >= strN.length || strN[index] < '0' || strN[index] > '9') {
            return 0;
        }
        
        int first = strN[index] - '0';
        int length = strN.length - index;
        
        if(length == 1 && first == 0) {
            return 0;
        }
        
        if(length == 1 && first > 0) {
            return 1;
        }
        
        int numFirstDigit = 0;
        
        // 10000~19999
        if(first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if(first == 1) {
            numFirstDigit = (strN[index + 1] - '0') + 1;
        }
        
        // 1346~21345 exclude numFirstDigit
        int numOtherDigit = first * (length - 1) * powerBase10(length - 2);
        
        // 0~1345
        int numRecursive = numberContainsOneInternal(strN, index + 1);
        
        return numFirstDigit + numOtherDigit + numRecursive;
    }

    private static int powerBase10(int n) {
        int result = 1;
        
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        
        return result;
    }

}
