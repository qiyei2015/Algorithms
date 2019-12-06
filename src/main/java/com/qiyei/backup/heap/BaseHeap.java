package com.qiyei.backup.heap;

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

    /**
     * 容量 pq[1....N]
     */
    protected int N;
    /**
     * 堆中元素个数
     */
    protected int count;

    /**
     * 构造方法
     */
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

    /**
     * 数组创建
     * @param array
     */
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

    /**
     * 返回堆中元素个数
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 打印数组,从小到大
     * @return
     */
    public String print(){
        return null;
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
