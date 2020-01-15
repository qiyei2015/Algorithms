package com.leetcode.search;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Created by qiyei2015 on 2018/5/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII_350 {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        //记录数据出现的频率
        HashMap<Integer,Integer> record = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0 ;i < nums1.length ;i++){
            Integer value = record.getOrDefault(nums1[i],0);
            value++;
            record.put(nums1[i],value);
        }

        for (int i = 0 ;i < nums2.length ;i++){
            Integer value = record.get(nums2[i]);
            if (value != null && value > 0){
                list.add(nums2[i]);
                //更新Value值
                value--;
                record.put(nums2[i],value);
            }
        }

        int[] array = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            array[i] = list.get(i);
        }
        return array;
    }

}
