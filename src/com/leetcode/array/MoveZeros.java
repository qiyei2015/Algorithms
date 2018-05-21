package com.leetcode.array;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/5/21.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 283
 */
public class MoveZeros {


    public static void main(String[] args){
        int[] array = new int[]{0,1,0,3,12};
        new MoveZeros().moveZeroes(array);
        LogUtil.printArray(args);

    }


    public void moveZeroes(int[] nums) {
//        solution1(nums);
        solution2(nums);
    }

    /**
     * 直接遍历非0数字，然后赋值
     */
    private void solution1(int[] nums){
        int[] noneZeros = new int[nums.length];
        int j = 0 ;
        for (int i = 0 ;i < nums.length ;i++){
            if (nums[i] != 0){
                noneZeros[j] = nums[i];
                j++;
            }
        }
        nums = noneZeros;
    }

    /**
     * 遍历非0的，然后移动到前面
     * @param nums
     */
    private void solution2(int[] nums){
        int j = 0 ;
        int length = nums.length;
        for (int i = 0 ;i < length ;i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j ;i <length ;i++){
            nums[i] = 0;
        }
    }

    /**
     * 遍历非0的，然后与第一个元素交换
     * @param nums
     */
    private void solution3(int[] nums){
        int j = 0 ;
        int length = nums.length;
        for (int i = 0 ;i < length ;i++){
            if (nums[i] != 0){
                //与第j个元素交换
                exch(nums,i,j);
                j++;
            }
        }
    }

    /**
     * 交换数组
     * @param array
     * @param i
     * @param j
     */
    public void exch(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
