package com.qiyei.sort;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/3/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public abstract class BaseSort {
    
    /**
     * 排序算法
     * @param array
     */
    public abstract void sort(Comparable[] array);

    /**
     * 比较两个的大小
     * @param i
     * @param j
     * @return
     */
    public boolean less(Comparable i,Comparable j){
        return i.compareTo(j) < 0;
    }

    /**
     * 交换两个数
     * @param array
     * @param i
     * @param j
     */
    public void exch(Comparable[] array,int i,int j){
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 判断数组是否排序
     * @param array
     * @return
     */
    public boolean isSort(Comparable[] array){
        for (int i = 0 ;i < array.length ; i++){
            if (!less(array[i],array[i+1])){
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     * @param array
     */
    public void print(Comparable[] array){
        for (int i = 0 ;i < array.length ; i++){
            LogUtil.print(array[i] + " ");
            //每10个数换一行
            if ((i + 1) % 10 == 0){
                LogUtil.print("\n");
            }
        }
        LogUtil.print("\n");
    }

}
