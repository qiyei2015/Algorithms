package com.qiyei.algorithms.sort;

/**
 * @author Created by qiyei2015 on 2019/12/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 冒泡排序
 * 每次依次比较两个元素，如果前一个元素比后面的元素大，就交换，这样一轮下来就排好了一个元素
 */
public class BubbleSort extends BaseSort {

    @Override
    protected String getTag() {
        return "BubbleSort";
    }

    @Override
    public void sort(Comparable[] array) {
        super.sort(array);
        //进行n轮循环
        for (int i = 0 ; i < array.length ;i++){
            //每轮依次比较和交换a[0..n-i-1]这个区间的元素
            for (int j = 1; j < array.length - i;j++){
                if (array[j-1].compareTo(array[j]) > 0){
                    swap(array,j - 1 ,j);
                }
            }
        }
    }


    public void sort2(Comparable[] array) {
        super.sort(array);
        //首次
        int size = array.length;
        int swapIndex = 1;
        while (swapIndex > 0){
            swapIndex = 0;
            for (int i = 1 ; i < size;i++){
                if (array[i - 1].compareTo(array[i]) > 0){
                    swap(array,i ,i -1);
                    //记录最后依次交换的位置，a[i...n-1]之后的数据已经有序了
                    swapIndex = i;
                }
            }
            //更新循环条件，上次交换index之后的数据不用考虑了，已经有序了
            size = swapIndex;
        }
    }
}
