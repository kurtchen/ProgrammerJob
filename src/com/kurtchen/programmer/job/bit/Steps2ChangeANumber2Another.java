/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.bit;

/**
 * 10: 1010, 13: 1101, need to change 3 bits.
 *
 * @author Kurt
 */
public class Steps2ChangeANumber2Another {

    public static int steps2ChangeANumber2Another(int m, int n){
        if(m < 0) { // Hack for negative numbers
            m = ~m + 1;
        }
        
        if(n < 0) { // Hack for negative numbers
            n = ~n + 1;
        }
        
        int xor = m ^ n;
        
        return NumberOf1.numberOf1C(xor);
    }
    
    public static void main(String[] args) {
        System.out.println("10 -> 13 steps:" + steps2ChangeANumber2Another(10, 13));
    }

}
