/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.string;

/**
 * Converting between string and integer.
 * 
 * @author Kurt
 */
public class String2Integer {

    public static int string2Integer(String str) {
        if (str == null) {
            throw new NullPointerException("String can't be null");
        }

        str = str.trim();

        if (str.length() == 0) {
            throw new IllegalArgumentException("Empty string");
        }

        boolean negative = false;

        int index = 0;

        if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) == '-') {
            negative = true;
            index++;
        }

        int value = 0;

        int tmp = 0;
        
        for (int i = index; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                tmp = value * 10 + (str.charAt(i) - '0');
                
                // check number overflow
                if(tmp < value) {
                    throw new IllegalArgumentException("invalid number string, overflow");
                }
                
                value = tmp;
            } else {
                throw new NumberFormatException("invalid number string" + str);
            }
        }

        if (negative) {
            value = 0 - value;
        }

        return value;
    }

    public static void main(String[] args) {
        // Testing string to integer
        System.out.println(String2Integer.string2Integer("213434"));
        System.out.println(String2Integer.string2Integer("-43645"));
        System.out.println(String2Integer.string2Integer("9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    }

}
