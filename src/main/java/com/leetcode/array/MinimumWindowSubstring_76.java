package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 76
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring_76 {


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(new MinimumWindowSubstring_76().minWindow(s,p));
    }


    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
     *
     * 示例：
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     *
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.length() == 0){
            return "";
        }
        int left = -1;
        int right = -1;
        int l = 0;
        // [l..r] 为考察的区间
        int r = 0;
        int min = s.length() + 1;

        Map<Character,Integer> minWindowRecord = new HashMap<>();
        Map<Character,Integer> recordT = new HashMap<>();

        for (int i = 0 ;i < t.length() ;i++){
            Integer value = recordT.getOrDefault(t.charAt(i),0);
            recordT.put(t.charAt(i),++value);
        }

        int sizeT = recordT.size();
        //用于判断是否可能满足最小窗口
        int freq = 0;

        while (r < s.length()){

            char keyR = s.charAt(r);
            Integer valueR = minWindowRecord.getOrDefault(keyR,0);
            minWindowRecord.put(keyR,++valueR);

            //满足一个字符了
            if (recordT.containsKey(keyR) && (recordT.get(keyR).intValue() == minWindowRecord.get(keyR).intValue())){
                freq++;
            }

            //当freq 与sizeT相等，说明有可能是最小窗口了
            while (l <= r && (freq == sizeT)){
                if (min > (r - l + 1)){
                    min = r - l + 1;
                    left = l;
                    right = r;
                }
                //移动l
                char keyL = s.charAt(l);
                Integer valueL = minWindowRecord.getOrDefault(keyL,0);
                minWindowRecord.put(keyL,--valueL);
                l++;
                //不再是子串了，freq--
                if (recordT.containsKey(keyL) && minWindowRecord.get(keyL).intValue() < recordT.get(keyL).intValue()){
                    freq--;
                }
            }

            r++;
        }
        if (min == s.length() + 1){
            return "";
        }
        return s.substring(left,right + 1);
    }

    /**
     * 时间复杂度O(nm)
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }
        int left = -1;
        int right = -1;

        char[] array = s.toCharArray();

        int l = 0;
        // [l..r] 初始化长度为p的长度
        int r = t.length() - 1;

        int min = s.length() + 1;

        //相等
        if (s.length() == t.length()){
            if (isMinWindow(array,l,r,t)){
                if (min > r - l + 1){
                    left = l;
                    right = r;
                    min = r - l + 1;
                }
                return s.substring(left,right + 1);
            }
        }

        //l可以去掉最后一个是[0..array.length - t.length()]
        while (l < array.length - t.length() + 1 &&(t.length() <= r - l +1)){
            //如果包含
            if (isMinWindow(array,l,r,t)){
                if (min > r - l + 1){
                    left = l;
                    right = r;
                    min = r - l + 1;
                }
                l++;
            }else if ((r+1) < array.length){
                r ++;
            } else {
                l++;
            }

            if (r >= array.length && !isMinWindow(array,l,r,t)){
                break;
            }
        }
        if (min == array.length + 1){
            return "";
        }
        return s.substring(left,right + 1);
    }

    /**
     * 包含字符串t
     * @param array
     * @param l
     * @param r
     * @param t
     * @return
     */
    private boolean isMinWindow(char[] array, int l, int r, String t) {
        if (t.length() > (r - l + 1)){
            return false;
        }
        int[] freq = new int[256];

        for (int i = 0 ;i < t.length() ;i++){
            freq[t.charAt(i)]++;
        }

        //对应频率减1，没有减到的或者没有减完的一定有大于0的
        for (int i = l;i <= r;i++){
            freq[array[i]]--;
        }

        for (int i = 0 ;i < freq.length ;i++){
            if (freq[i] > 0){
                return false;
            }
        }

        return true;
    }




}
