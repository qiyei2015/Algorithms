package com.leetcode.string;

/**
 * @author Created by qiyei2015 on 2020/2/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().equals("")){
            return 0;
        }

        int j = s.length();
        int i = s.length() - 1;
        while (s.charAt(i) == ' '){
            j--;
            i--;
        }

        for (; i >= 0;i--){
            if (s.charAt(i) == ' '){
                break;
            }
        }
        int len = j - i - 1;
        if (len > s.length()){
            return 0;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord_58().lengthOfLastWord("a "));
    }
}
