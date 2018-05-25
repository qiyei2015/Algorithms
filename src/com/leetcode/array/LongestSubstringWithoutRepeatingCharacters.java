package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 3
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        //定义256是因为 字符编码从0到256 freq[i] = 1 表示有重复的字符串i freq[i] == 0 表示没有重复的字符串i
        int[] freq = new int[256];

        int left = 0;
        int right = -1;
        int res = 0;

        while (left < array.length){

            if (right + 1 < array.length && freq[array[right + 1]] == 0){
                //表明没有重复字符串 array[right+1]
                freq[array[right + 1]] = 1;
                right++;
            }else {
                //消除重复的字符串array[left]
                freq[array[left]] = 0;
                left++;
            }

            res = Math.max(res,right - left + 1);
        }

        return res;
    }

}
