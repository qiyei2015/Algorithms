package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 344
 * 反转字符串
 */
public class ReverseString {



    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;

        while (i < j){
            exch(array,i,j);
            i++;
            j--;
        }
        return new String(array);
    }

    private void exch(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
