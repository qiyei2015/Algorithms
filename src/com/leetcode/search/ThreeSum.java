package com.leetcode.search;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2018/5/29.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 15. 三数之和
 */
public class ThreeSum {

    /**
     * O(n2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        //先对数组进行排序
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       for (int i = 0 ;i < nums.length ; i++){
           int[] array = twoSum(nums,0,0 - nums[i]);
           if (array != null){
               check(result,nums[i],nums[array[0]],nums[array[1]]);
           }
       }
       return result;
    }


    /**
     * 使用map来记录值与索引 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int lo,int target) {

        int[] index = new int[2];

        HashMap<Integer,Integer> record = new HashMap<>();
        for (int i = lo ;i < nums.length ;i++){
            //有找到索引
            if (record.get(target - nums[i]) != null){
                index[0] = Math.min(i,record.get(target - nums[i]));
                index[1] = Math.max(i,record.get(target - nums[i]));
                return index;
            }
            record.put(nums[i],i);
        }
        return null;
    }

    /**
     * 去重
     * @param n
     * @param m
     * @param k
     */
    private void check(List<List<Integer>> listList,int n,int m,int k){
        Integer[] array = new Integer[]{n,m,k};
        boolean flag = false;
        for (List<Integer> list : listList){
            //记录元素出现的频率
            HashMap<Integer,Integer> record = new HashMap<>();
            for (int i = 0 ;i < list.size() ;i++){
                Integer value = record.get(list.get(i));
                if (value == null){
                    value = 0;
                }
                value++;
                record.put(list.get(i),value);
            }

            for (int i = 0 ;i < array.length ;i++){
                Integer value = record.get(array[i]);
                if (value != null){
                    value--;
                    record.put(array[i],value);
                }
            }

            //判断是否清理干净
            for (Map.Entry<Integer,Integer> entry : record.entrySet()){
                if (entry.getValue() != 0){
                    flag = true;
                }
            }
        }

        if (flag || listList.isEmpty()){
            listList.add(Arrays.asList(array));
        }
    }

}
