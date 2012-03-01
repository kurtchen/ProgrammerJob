/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Consider big numbers.
 * 
 * @author Kurt
 */
public class Print1ToMaxOfNDigits {

    public static void Print1ToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];

        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        while (!increment(number)) {
            printNumber(number);
        }
    }

    private static void printNumber(char[] number) {
        boolean started = false;

        for (int i = 0; i < number.length; i++) {

            if (number[i] != '0' && !started) {
                started = true;
            }

            if (started) {
                System.out.print(number[i]);
            }
        }

        System.out.println();
    }

    private static boolean increment(char[] number) {
        boolean overflow = false;

        int carry = 0;

        for (int i = number.length - 1; i >= 0; i--) {
            int sum = number[i] - '0';

            if (i == number.length - 1) {
                sum += 1;
            } else {
                sum += carry;
            }

            if (sum >= 10) {

                if (i == 0) {
                    overflow = true;
                    break;
                }

                sum -= 10;
                carry = 1;

                number[i] = (char)('0' + sum);

            } else {
                number[i] = (char)('0' + sum);
                break;
            }
        }

        return overflow;
    }

    // Method 2, character permutation
    public static void Print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];

        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }

        for (int i = 0; i < 10; i++) {
            number[0] = (char)('0' + i);
            
            Print1ToMaxOfNDigits2Recurse(number, 0);
        }
    }

    private static void Print1ToMaxOfNDigits2Recurse(char[] number, int index) {
        
        if(index == number.length - 1) {
            printNumber(number);
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)('0' + i);
            
            Print1ToMaxOfNDigits2Recurse(number, index + 1);
        }
        
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits1(3);
        Print1ToMaxOfNDigits2(3);
    }

}
