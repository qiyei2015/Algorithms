package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 3
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     *
     * 示例: 
     *
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * 进阶:
     *
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
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
                freq[array[right + 1]]++;
                right++;
            }else {
                //消除重复的字符串array[left]
                freq[array[left]]--;
                left++;
            }

            res = Math.max(res,right - left + 1);
        }

        return res;
    }

}
