package com.qiyei.heap;

/**
 * @author Created by qiyei2015 on 2018/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 最大堆
 */
public class MaxPQ<T extends Comparable<T>> extends BaseHeap{

    /**
     * 无参构造方法
     */
    public MaxPQ() {
        super();
    }

    /**
     * 创建一个初始容量为max的堆
     * @param max
     */
    public MaxPQ(int max) {
        super(max);
    }

    /**
     * 用数组创建堆
     * @param a
     */
    public MaxPQ(Comparable[] a){
        super(a);
    }

    /**
     * 插入一个元素
     * @param t
     */
    public void insert(T t){
        pq[++N] = t;
        swim(N);
    }

    /**
     * 删除最大的元素
     * @return
     */
    public T delMax(){
        T t = (T) pq[1];
        exch(1,N);
        pq[N] = null;
        N--;
        sink(1);
        return t;
    }

    /**
     * 堆的上浮，解决子节点比父结点大的问题
     * @param k 节点k上浮
     */
    private void swim(int k){
        //子节点比父结点大
        while (k > 1 && less(k/2,k)){
            //交换两个节点
            exch(k/2,k);
            k = k/2;
        }
    }

    /**
     * 堆的下沉 父结点小于子节点,将父节点与交大的子节点交换
     * @param k
     */
    private void sink(int k){
        if (k > N){
            return;
        }
        int i = 2 * k;
        if (i > N || (i+1) > N){
            return;
        }
        if (less(i,i+1)){
            exch(k,i+1);
            sink(i+1);
        }else {
            less(k,i);
            sink(i);
        }

//        while (2 * k <= N){
//            int j = 2 * k;
//            if (j < N && less(j,j+1)){
//                j++;
//            }
//            if (!less(k,j)){
//                break;
//            }
//            exch(k,j);
//            k = j;
//        }

    }

}
