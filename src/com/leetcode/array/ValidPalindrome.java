package com.leetcode.array;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 125
 * 验证回文串 使用双索引技术
 */
public class ValidPalindrome {



    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "0P";
        String s3 = "Zeus was deified, saw Suez.";
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s1));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s2));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s3));
    }


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
            LogUtil.println("i: " + array[i] + " j: " + array[j]);
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
