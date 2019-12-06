package com.qiyei.backup.p001;

/**
 * @author Created by qiyei2015 on 2018/2/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分搜索
 */
public class BinarySerach {

    /**
     * 二分法搜索
     * @param key 查找key值
     * @param array 已升序排好的数组
     */
    public static int rank(int key,int[] array){
        int left = 0;
        int right = array.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right){
            if (key == array[mid]){
                //System.out.println("index:" + mid);
                return mid;
            }else if (key < array[mid]){ //在left查找
                right = mid - 1;
                mid = left + (right - left) / 2;
            }else { //在right查找
                left = mid + 1;
                mid = left + (right - left) / 2;
            }
        }
        //System.out.println("not find " + key);
        return -1;
    }

    /**
     * 二分法搜索
     * @param key 查找key值
     * @param array 已升序排好的数组
     */
    public static int rank2(int key,int[] array){
        return serach(key,array,0,array.length - 1);
    }

    /**
     * 搜索关键字key 递归方式
     * @param key
     * @param array
     * @param lo
     * @param hi
     * @return key的index
     */
    private static int serach(int key,int[] array,int lo,int hi){
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo)/2;
        //在a[lo..hi]数组中查找
        if (key == array[mid]){
            return mid;
        }else if (key < array[mid]){
            //在a[lo..mid-1]中找
            return serach(key,array,lo,mid - 1);
        }else {
            //在a[mid+1..hi]中找
            return serach(key,array,mid + 1,hi);
        }
    }

    public static void main(String[] args){

        int[] array = {0,1,2,3,4,5,6,7,8,9,10};

        rank(1,array);

    }

}
