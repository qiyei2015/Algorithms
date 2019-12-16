package com.qiyei.algorithms.sort;

/**
 * @author Created by qiyei2015 on 2019/12/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 依次从数组中选择最小的元素排在前面
 *
 */
public class SelectionSort extends BaseSort {


    @Override
    protected String getTag() {
        return "SelectionSort";
    }

    @Override
    public void sort(Comparable[] array) {
        super.sort(array);

        for (int i = 0 ;i < array.length ;i++){
            int min = i;
            //选择a[i+1,...]中最小的元素,并记录其索引
            for (int j = i + 1;j < array.length;j++){
                if (array[j].compareTo(array[min]) < 0){
                    min = j;
                }
            }
            //交换i与最小的元素，使其最小的元素排在最前面
            swap(array,i,min);
        }
    }


}
