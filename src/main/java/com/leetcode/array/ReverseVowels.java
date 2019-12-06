package com.leetcode.array;

import com.qiyei.backup.array.ArrayUtil;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 345 反转元音字母
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        //元音字符是 a e i o u
        char[] array = s.toCharArray();

        int i = 0;
        int j = array.length - 1;

        while (i < j){
            while (i < array.length && !isVowels(array[i])){
                i++;
            }
            while (j > 0 && !isVowels(array[j])){
                j--;
            }

            if (i > j){
                break;
            }
            ArrayUtil.exch(array,i,j);
            i++;
            j--;
        }
        return new String(array);
    }

    /**
     * 判断是否为元音
     * @param ch
     * @return
     */
    private boolean isVowels(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }


}
