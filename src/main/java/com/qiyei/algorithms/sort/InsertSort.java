package com.qiyei.algorithms.sort;

/**
 * @author Created by qiyei2015 on 2019/12/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 插入排序，依次比较当前元素与前一个元素，并交换位置(之前的元素已经是排好序)
 */
public class InsertSort extends BaseSort {

    @Override
    protected String getTag() {
        return "InsertSort";
    }

    @Override
    public void sort(Comparable[] array) {
        super.sort(array);
        //从a[i]开始考察，因为我们默认a[0]处已经有序了
        for (int i = 1; i < array.length ;i++){
            //比较与其前一个元素，如果较小，就交换位置
            for (int j = i ; j > 0 ;j--){
                if (array[j].compareTo(array[j-1]) < 0){
                    swap(array,j,j-1);
                } else {
                    //提前结束本轮循环，已经j的数据已经有序了
                    break;
                }
            }
        }
    }

    public void sort2(Comparable[] array) {
        super.sort(array);
        //从a[i]开始考察，因为我们默认a[0]处已经有序了
        int j = 0;
        for (int i = 1; i < array.length ;i++){
            //比较与其前一个元素，如果较小，就交换位置
            Comparable temp = array[i];
            for (j = i ; j > 0 && temp.compareTo(array[j-1]) < 0;j--){
                //后移一位
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }
}
