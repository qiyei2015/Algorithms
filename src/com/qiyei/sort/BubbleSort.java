package com.qiyei.sort;

/**
 * @author Created by qiyei2015 on 2018/3/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 冒泡排序，依次比较两个元素，最大的就慢慢靠后
 */
public class BubbleSort extends BaseSort{

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {

        for (int i = 0 ; i < array.length ; i++){
            //每一次会排好一个数，因此需要减i
            for (int j = 0; j < array.length - i - 1;j++){
                if (less(array[j+1],array[j])){
                    exch(array,j,j+1);
                }
            }
        }

    }

    /**
     * 从后往前扫描，每次把最大的元素排好序
     * @param array
     */
    public void sortBackToFace(Comparable[] array) {
        for (int i = array.length - 1 ; i >= 0 ; i--){
            //每一次会排好一个数，因此需要减i
            for (int j = 0; j <= i - 1;j++){
                if (less(array[j+1],array[j])){
                    exch(array,j,j+1);
                }
            }
        }
    }
}
