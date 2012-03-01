/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * Put all the odd numbers before all the even numbers.
 * 
 * @author Kurt
 */
public class ArrayPartition {

    public static void arrayPartition(Partitionable[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int pointer1 = 0;
        int pointer2 = array.length - 1;

        while (pointer1 < pointer2) {
            while (pointer1 < array.length && array[pointer1].isFirstHalfPartition()) {
                pointer1++;
            }

            while (pointer2 >= 0 && !array[pointer2].isFirstHalfPartition()) {
                pointer2--;
            }

            if (pointer1 < pointer2) {
                Partitionable tmp = array[pointer1];
                array[pointer1] = array[pointer2];
                array[pointer2] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        OddEvenNumber[] oddEvenNumbers = new OddEvenNumber[10];
        
        for (int i = 0; i < oddEvenNumbers.length; i++) {
            oddEvenNumbers[i] = new OddEvenNumber(i);
        }
        
        arrayPartition(oddEvenNumbers);
        
        for (int i = 0; i < oddEvenNumbers.length; i++) {
            System.out.print(oddEvenNumbers[i].getValue());
        }
    }

}

interface Partitionable {
    boolean isFirstHalfPartition();
}

class OddEvenNumber implements Partitionable {
    private int value;

    public OddEvenNumber() {
        
    }
    
    public OddEvenNumber(int value) {
        this.value = value;
    }

    @Override
    public boolean isFirstHalfPartition() {
        return (value & 1) == 1 ? true : false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
