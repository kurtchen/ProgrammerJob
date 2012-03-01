/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.matrix;

/**
 * Print matrix clockwise.
 *
 * @author Kurt
 */
public class PrintMatrixClockwise {

    private static <T> void printMatrixClockwise(T[][] matrix, int rows, int columns) {
        if(matrix == null || rows <= 0 || columns <= 0) {
            return;
        }
        
        int start = 0;
        
        while(rows > start * 2 && columns > start * 2) {
            printMatrix(matrix, rows, columns, start);
            
            start++;
        }
        
        System.out.println();
    }

    private static <T> void printMatrix(T[][] matrix, int rows, int columns, int start) {
        
        int endX = columns - start - 1;
        int endY = rows - start - 1;
        
        for (int i = start; i <= endX ; i++) {
            System.out.print(matrix[start][i]);
            System.out.print(" ");
        }
        
        if(start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(matrix[i][endX]);
                System.out.print(" ");
            }
        }
        
        if(start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.print(matrix[endY][i]);
                System.out.print(" ");
            }
        }
        
        if(start < endY - 1 && start < endX) {
            for (int i = endY - 1; i > start; i--) {
                System.out.print(matrix[i][start]);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        // 1  2  3  4
        // 5  6  7  8
        // 9  10 11 12
        // 13 14 15 16
        Integer[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        printMatrixClockwise(matrix, 4, 4);
        
        // 1  2  3  4
        // 5  6  7  8
        Integer[][] matrix1 = {{1,2,3,4},{5,6,7,8}};
        
        printMatrixClockwise(matrix1, 2, 4);
        
        // 1  2  
        // 3  4
        // 5  6  
        // 7  8
        Integer[][] matrix2 = {{1,2},{3,4},{5,6},{7,8}};
        
        printMatrixClockwise(matrix2, 4, 2);
        
        
    }
}
