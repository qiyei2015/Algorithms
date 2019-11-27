package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2018/5/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 167
 * 可以考虑采用二分搜索法
 */
public class TwoSumII {

    /**
     * 使用双索引技术,题目保证只有一个解
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        int i = 0;
        int j = numbers.length - 1;

        while (i < j){
            if (numbers[i] + numbers[j] == target){
                indexs[0] = i+1;
                indexs[1] = j+1;
                break;
            }else if (numbers[i] + numbers[j] > target){
                //大于目标值，j--，因为最后数比较大
                j--;
            }else {
                //小于目标值，i++，因为最后数比较大
                i++;
            }
        }
        return indexs;
    }

    /**
     * 使用二分搜索法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum0(int[] numbers, int target) {
        int[] indexs = new int[2];
        int i = 0;

        for (i = 0 ;i < numbers.length ;i++){
            int j = binarySearch(numbers,i+1,numbers.length-1,target - numbers[i]);
            if ( j != -1){
                indexs[0] = i + 1;
                indexs[1] = j + 1;
                break;
            }
        }

        return indexs;
    }

    /**
     * 二分搜索
     * @param arr
     * @param lo
     * @param hi
     * @param target
     * @return
     */
    private int binarySearch(int[] arr,int lo,int hi,int target){
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo)/2;
        if (arr[mid] == target){
            return mid;
        }else if (arr[mid] < target){
            return binarySearch(arr,mid + 1,hi,target);
        }else {
            return binarySearch(arr,lo,mid - 1 ,target);
        }
    }

    /**
     * 二分搜索
     * @param arr
     * @param lo
     * @param hi
     * @param target
     * @return
     */
    private int binarySearch2(int[] arr,int lo,int hi,int target){
        int mid = 0;
        while (lo <= hi){
            mid = lo + (hi - lo)/2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }



}
