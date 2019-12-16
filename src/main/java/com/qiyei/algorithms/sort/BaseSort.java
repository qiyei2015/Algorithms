package com.qiyei.algorithms.sort;

/**
 * @author Created by qiyei2015 on 2019/12/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public abstract class BaseSort {

    /**
     * 排序算法
     * @param array
     */
    public void sort(Comparable[] array){
        if (array == null){
            throw new IllegalArgumentException("array is null");
        }
    }

    /**
     * 比较两个的大小
     * @param i
     * @param j
     * @return
     */
    protected boolean less(Comparable i,Comparable j){
        return i.compareTo(j) < 0;
    }


    /**
     * 交换两个数
     * @param array
     * @param i
     * @param j
     */
    protected void swap(Comparable[] array, int i, int j){
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
        if (array == null || array.length <= 1){
            return true;
        }
        for (int i = 1 ;i < array.length ; i++){
            if (array[i - 1].compareTo(array[i]) > 0){
                System.out.println("array[i - 1]=" + array[i-1] + ",array[i]=" + array[i]);
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     * @param tag
     * @param array
     */
    public void print(String tag,Comparable[] array){
        if (array == null){
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(tag + "\n");
        for (int i = 0 ;i < array.length ; i++){
            builder.append(array[i]);
            if (i != array.length - 1){
                builder.append(",");
            }
            //每10个数换一行
            if ((i + 1) % 20 == 0 && (i != array.length - 1)){
                builder.append("\n");
            }
        }
        System.out.println(builder.toString());
    }


    /**
     * 打印数组
     * @param array
     */
    public void print(Comparable[] array){
        print(getTag(),array);
    }

    /**
     * 获取tag
     * @return
     */
    protected abstract String getTag();
}
