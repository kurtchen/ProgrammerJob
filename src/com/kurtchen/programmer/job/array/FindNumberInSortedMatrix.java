/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.array;

/**
 * In a matrix, the numbers in row are sorted, the numbers in column are also sorted.
 * Find if a number is in the matrix.
 *
 * @author Kurt
 */
public class FindNumberInSortedMatrix {

    public static boolean findInMatrix(int[][] matrix, int rows, int columns, int number){
        boolean found = false;
        
        if(matrix == null || rows <= 0 || columns <= 0) {
            return false;
        }
        
        int row = 0;
        int column = columns -1;
        
        while(row < rows && columns >= 0){
            if(matrix[row][column] == number) {
                found = true;
                break;
            } else if(matrix[row][column] > number){
                column--;
            } else {
                row++;
            }
        }
        
        return found;
    }
    
    public static void main(String[] args) {
        
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        
        System.out.println(findInMatrix(matrix, 4, 4, 7));
        
        System.out.println(findInMatrix(matrix, 4, 4, 16));
    }

}
