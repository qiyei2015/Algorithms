package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 438
 */
public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        char[] array = s.toCharArray();
        char[] pArr = p.toCharArray();

        int left = 0;
        int right = pArr.length - 1;// [left..right] 初始化长度为p的长度

        while (left < array.length && right < array.length){
            if (isAnagrams(array,left,right,pArr)){
                list.add(left);
            }
            left++;
            right++;
        }
        return list;
    }


    private boolean isAnagrams(char[] array, int left, int right, char[] pArr) {



        return true;
    }

}
