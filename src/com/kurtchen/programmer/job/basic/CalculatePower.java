/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Calculate the power of some number.
 *
 * @author Kurt
 */
public class CalculatePower {

    public static double calculatePower(double base, int exponent){
        if(base == 0) {
            return 0;
        }
        
        int positiveExponent = exponent;
        
        if(exponent < 0) {
            positiveExponent = -exponent;
        }
        
        double result = calculate(base, positiveExponent);
        
        if(exponent < 0) {
            result = 1 / result;
        }
        
        return result;
    }
    
    private static double calculate(double base, int exponent){
        if(exponent == 0) {
            return 1;
        }
        
        if(exponent == 1) {
            return base;
        }
        
        double result = calculate(base, exponent >> 1);
        
        result = result * result;
        
        if((exponent & 1) == 1) {
            result = result * base;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(calculatePower(2, 4));
        System.out.println(calculatePower(2, -1));
        System.out.println(calculatePower(2, 0));
        System.out.println(calculatePower(0, 0));
    }

}
