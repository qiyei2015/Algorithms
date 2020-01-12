package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 125
 * 验证回文串 使用双索引技术
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindrome_125 {


    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;

        while (i < j){
            while (!isChar(array[i]) && (i < array.length - 1)){
                i++;
            }
            while (!isChar(array[j]) && (j > 0)){
                j--;
            }

            if (i > j ){
                break;
            }
            if (equalsChar(array[i],array[j])){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean isChar(char c){
        //是字母或者数字
        //字母A:65 Z:90 a:97  z:122
        //48:0 9:57
        if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122){
            return true;
        }else {
            return false;
        }
    }

    private boolean equalsChar(char a,char b){

        if (a == b){
            return true;
        }

        if (a >= 65 && a <= 90){
            if (a + 32 == b){
                return true;
            }
        }

        if (b >= 65 && b <= 90){
            if (b + 32 == a){
                return true;
            }
        }

        return false;
    }
}
