package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2020/1/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 438. 找到字符串中所有字母异位词
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString_438 {


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(new FindAllAnagramsInAString_438().findAnagrams(s,p));
        s = "abab";
        p = "ab";
        System.out.println(new FindAllAnagramsInAString_438().findAnagrams(s,p));
    }


    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int length = p.length();
        //[l..r] 作为与p比较的子序列
        int l = 0;
        int r = length - 1;

        char[] array = s.toCharArray();
        char[] array2 = p.toCharArray();

        while (r < s.length()){
            if (match(array,l,r,array2)){
                list.add(l);
            }
            l++;
            r++;
        }
        return list;
    }

    /**
     * 比较两个字符串是字母异位词
     * 对字符串的比较，如果比较频率，可以考虑定义数组
     * 也可以利用hash表比较
     * @param arr1
     * @param l
     * @param r
     * @param arr2
     * @return
     */
    private boolean match(char[] arr1,int l,int r,char[] arr2){
        int[] freq = new int[256];

        for (int i = 0 ;i < arr2.length ;i++){
            freq[arr2[i]]++;
        }

        for (int i = l;i <= r;i++){
            freq[arr1[i]]--;
        }

        for (int i = 0 ;i < freq.length ;i++){
            if (freq[i] != 0){
                return false;
            }
        }

        return true;
    }

    private boolean match2(char[] arr1,int l,int r,char[] arr2){

        Map<Character,Integer> record1 = new HashMap<>();
        Map<Character,Integer> record2 = new HashMap<>();

        for (int i = 0 ;i < arr2.length ;i++){
            Integer value = record2.getOrDefault(arr2[i],0);
            record2.put(arr2[i],++value);
        }

        for (int i = l;i <= r;i++){
            Integer value = record1.getOrDefault(arr1[i],0);
            record1.put(arr1[i],++value);
        }

        if (record1.size() != record2.size()){
            return false;
        }

        for (Map.Entry<Character,Integer> entry:record1.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            //相等才是对的
            if (!record2.containsKey(key) || !(record2.get(key).intValue() == value)){
                return false;
            }
        }

        return true;
    }
}
