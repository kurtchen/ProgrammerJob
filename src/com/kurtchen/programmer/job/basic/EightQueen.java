/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.basic;

/**
 * The eight queens problem.
 * 
 * @author Kurt
 */
public class EightQueen {

    public static void main(String[] args) {
        
        int[] columns = {
                0, 1, 2, 3, 4, 5, 6, 7
        };
        
        findEightQueens(columns);
    }

    private static void findEightQueens(int[] columns) {
        if(columns == null || columns.length != 8) {
            return;
        }
        
        doFindEightQueensInternal(columns, 0);
    }

    private static void doFindEightQueensInternal(int[] columns, int index) {
        if(index == columns.length - 1) {
            // Check here
            for (int i = 0; i < columns.length; i++) {
                for (int j = 0; j < columns.length; j++) {
                    if(i != j) {
                        if(i - j == columns[i] - columns[j]) {
                            return;
                        }
                    }
                }
            }
            
            System.out.print("Find a solution:");
            for (int i = 0; i < columns.length; i++) {
                System.out.print(columns[i]);
                System.out.print(" ");
            }
            System.out.println();
            
            return;
        }
        
        for (int i = index; i < columns.length; i++) {
            int tmp = columns[index];
            columns[index] = columns[i];
            columns[i] = tmp;
            
            doFindEightQueensInternal(columns, index + 1);
            
            tmp = columns[index];
            columns[index] = columns[i];
            columns[i] = tmp;
        }
    }

}
