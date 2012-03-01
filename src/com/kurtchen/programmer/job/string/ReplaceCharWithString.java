/*
 * Copyright (C) 2012 kurtchen.com
 * All Rights Reserved.
 * kurtchen.com Confidential Restricted.
 *
 */

package com.kurtchen.programmer.job.string;

/**
 * Replace a char with a string.
 * 
 * e.g. replace the whitespace with %20
 *
 * @author Kurt
 */
public class ReplaceCharWithString {

    public static int replaceCharWithString(char[] source, int oldLength, char c, String pattern) {
        if(source == null || source.length == 0 || pattern == null || pattern.length() == 0) {
            return oldLength;
        }
        
        int count = 0;
        
        for (int i = 0; i < source.length; i++) {
            if(source[i] == c) {
                count++;
            }
        }
        
        int newLength = oldLength + count * (pattern.length() - 1);
        
        if(newLength > source.length) {
            return oldLength;
        }
        
        int oldIndex = oldLength - 1;
        int newIndex = newLength - 1;
        
        while(oldIndex >= 0 && newIndex >= oldIndex) {
            if(source[oldIndex] == c) {
                for (int i = pattern.length() - 1; i >= 0 ; i--) {
                    source[newIndex] = pattern.charAt(i);
                    newIndex--;
                }
            } else {
                source[newIndex] = source[oldIndex];
                newIndex--;
            }
            
            oldIndex--;
        }
        
        return newLength;
    }
    
    public static void main(String[] args) {
        char[] source = new char[100];
        String oldString = "Who is the hero?";
        char c = ' ';
        String pattern = "%20";
        
        for (int i = 0; i < oldString.length(); i++) {
            source[i] = oldString.charAt(i);
        }
        
        int newLength = replaceCharWithString(source, oldString.length(), c, pattern);
        
        for (int i = 0; i < newLength; i++) {
            System.out.print(source[i]);
        }
    }

}
