package com.qiyei.algorithms.search;

/**
 * @author Created by qiyei2015 on 2018/2/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分搜索
 */
public class BinarySearch {

    /**
     * 二分法搜索
     * @param key 查找key值
     * @param array 已升序排好的数组
     */
    public static int search(int key, int[] array){
        int left = 0;
        int right = array.length - 1;
        int mid = -1;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (key == array[mid]){
                return mid;
            }else if (key < array[mid]){
                //在left查找
                right = mid - 1;
            }else {
                //在right查找
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分法搜索
     * @param key 查找key值
     * @param array 已升序排好的数组
     */
    public static int search2(int key,int[] array){
        return search(key,array,0,array.length - 1);
    }

    /**
     * 二分法搜索
     * @param key 查找key值,含有重复的key,
     * @param array 已升序排好的数组
     * @return 返回最后一个key
     */
    public static int search3(int key,int[] array){
        int left = 0;
        int right = array.length - 1;
        int mid = -1;
        int index = -1;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (key == array[mid]){
                index = mid;
                break;
            }else if (key < array[mid]){
                //在left查找
                right = mid - 1;
            }else {
                //在right查找
                left = mid + 1;
            }
        }
        //找寻最后一个元素
        if (index != -1){
            //考察index下一个元素
            while (((index+1) >= 0 && (index + 1) <= array.length -1) && array[index+1] == key){
                index++;
            }
        }
        return index;
    }


    /**
     * 搜索关键字key 递归方式
     * @param key
     * @param array
     * @param lo
     * @param hi
     * @return key的index
     */
    private static int search(int key,int[] array,int lo,int hi){
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo)/2;
        //在a[lo..hi]数组中查找
        if (key == array[mid]){
            return mid;
        }else if (key < array[mid]){
            //在a[lo..mid-1]中找
            return search(key,array,lo,mid - 1);
        }else {
            //在a[mid+1..hi]中找
            return search(key,array,mid + 1,hi);
        }
    }

    public static void main(String[] args){

        int[] array = {0,1,2,3,4,5,6,7,8,9,10};

        System.out.println(search(1,array));

    }

}
