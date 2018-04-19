package com.qiyei.heap;

/**
 * @author Created by qiyei2015 on 2018/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class BaseHeap<T extends Comparable<T>> {

    /**
     * 长度需N + 1
     */
    protected Comparable[] pq;

    protected int N;

    protected int count;


    public BaseHeap() {
        pq = new Comparable[0];
    }

    /**
     * 创建一个初始容量为max的堆
     * @param max
     */
    public BaseHeap(int max) {
        pq = new Comparable[max + 1];
        count = 0;
        N = max;
    }


    public BaseHeap(Comparable[] array) {
        this.pq = new Comparable[array.length + 1];
        System.arraycopy(array,0,pq,1,array.length);
        N = array.length;
        count = N;
    }

    /**
     * 时候为null
     * @return
     */
    public boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }

    /**
     * 比较 i < j
     * @param i
     * @param j
     * @return
     */
    protected boolean less(int i ,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换两个数
     * @param i
     * @param j
     */
    protected void exch(int i,int j){
        Comparable temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }


}
