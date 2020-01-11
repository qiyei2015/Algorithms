package com.leetcode.array;

import com.backup.backup.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LeetCodeArrayTest {

    public static void main(String[] args){
//        testReverseString();
//        testValidPalindrome();

//        testReverseVowels();
        testFindAllAnagrams();
    }

    private static void testReverseString() {
        String s6 = "hello";
        LogUtil.println("" + new ReverseString().reverseString(s6));
    }

    private static void testValidPalindrome() {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "0P";
        String s3 = "Zeus was deified, saw Suez.";
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s1));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s2));
        LogUtil.println("" + new ValidPalindrome().isPalindrome(s3));
    }


    private static void testReverseVowels(){
        String s = "hello";
        String s1 = "leetcode";
        LogUtil.println("" + new ReverseVowels().reverseVowels(s));
        LogUtil.println("" + new ReverseVowels().reverseVowels(s1));

    }

    private static void testFindAllAnagrams(){
        String s = "baa";
        String p = "aa";

        LogUtil.println("" + new FindAllAnagrams().findAnagrams(s,p));

    }
}
