package com.qiyei.heap;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class HeapTest {



    static Integer[] array = new Integer[100];
    static Random random = new Random();



    public static void main(String[] args){
        testHeap();
        testIndexMaxHeap();
    }




    /**
     * 测试对
     */
    private static void testHeap() {
        for (int i = 0 ; i < 100;i++){
            array[i] = random.nextInt(100);
        }

        MinPQ<Integer> minPQ = new MinPQ<>(array);
        MaxPQ<Integer> maxPQ = new MaxPQ<>(array);
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(minPQ.delMin() + " ");
        }
        LogUtil.println("");
        for (int i = 0 ; i < 100 ;i++){
            LogUtil.print(maxPQ.delMax() + " ");
        }
        LogUtil.println("");
    }


    /**
     * 测试最大索引堆
     */
    private static void testIndexMaxHeap(){
        //索引堆测试
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(100);
        for (int i = 0 ; i < 100;i++){
            indexMaxHeap.insert(i,random.nextInt(100));
        }
        LogUtil.println("indexMaxHeap size:" + indexMaxHeap.size());
        LogUtil.println("indexMaxHeap getIndexMax():" + indexMaxHeap.getIndexMax());
        LogUtil.println("indexMaxHeap getMax:" + indexMaxHeap.getMax());

        LogUtil.println("indexMaxHeap getItemIndex(5):" + indexMaxHeap.getItemIndex(5));

        for (int i = 0 ; i < 100;i++){
            LogUtil.println("[ " + indexMaxHeap.getIndexMax() + " " + indexMaxHeap.delMax() + " ]");
        }
    }

}
