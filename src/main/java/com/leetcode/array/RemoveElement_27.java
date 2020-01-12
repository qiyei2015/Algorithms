package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/21.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 27
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement_27 {


    public static void main(String[] args){
        int[] array = new int[]{0,1,0,3,12};

        System.out.println(new RemoveElement_27().removeElement(array,0));

    }


    public int removeElement(int[] nums, int val) {
        //[0..k)记录删除后的元素
        int k = 0;
        for (int i = 0 ;i < nums.length;i++){
            if (nums[i] != val){
                swap(nums,k,i);
                k++;
            }
        }
        return k;
    }

    /**
     * 交换数组
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
