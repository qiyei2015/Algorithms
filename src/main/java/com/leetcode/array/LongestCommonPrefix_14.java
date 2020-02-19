package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/2/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }

        int[] freq = new int[strs[0].length()];
        String longPrefix = strs[0];

        for (int i = 1; i < strs.length ;i++){
            String s = strs[i];
            if (s == null || s.trim().equals("")){
                return "";
            } else {
                for (int j = 0 ;j < s.length() ;j++){
                    if (j < longPrefix.length() && s.charAt(j) == longPrefix.charAt(j)){
                        freq[j]++;
                    }
                }
            }
        }
        int i = 0;
        for (i = 0 ; i < longPrefix.length() ;i++){
            if (freq[i] != strs.length - 1){
                break;
            }
        }
        return longPrefix.substring(0,i);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }

        for (int i = 0 ;i < strs[0].length() ;i++){
            char prev = strs[0].charAt(i);
            //扫描其他子串，查看是否有相同的
            for (int j = 1;j < strs.length ;j++){
                //某一个字符串相同的位数不相等，就不再找了
                if (i == strs[j].length() || prev != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
