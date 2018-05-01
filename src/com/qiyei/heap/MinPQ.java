package com.qiyei.heap;

/**
 * @author Created by qiyei2015 on 2018/4/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 最小堆
 */
public class MinPQ<T extends Comparable<T>> extends BaseHeap {
    /**
     * 无参构造方法
     */
    public MinPQ() {
        super();
    }

    /**
     * 创建一个初始容量为max的堆
     * @param n
     */
    public MinPQ(int n) {
        super(n);
    }

    /**
     * 用数组创建堆,时间复杂度 O(N)
     * @param a
     */
    public MinPQ(Comparable[] a){
        super(a);
        for (int i = count/2; i >= 1 ; i--){
            sinkBetter(i);
        }
    }

    /**
     * 插入一个元素
     * @param t
     */
    public void insert(T t){
        pq[++count] = t;
        swimBetter(count);
    }

    /**
     * 删除最小的元素
     * @return
     */
    public T delMin(){
        T t = (T) pq[1];
        exch(1,count);
        pq[count] = null;
        count--;
        sinkBetter(1);
        return t;
    }

    /**
     * 获取最小值
     * @return
     */
    public T getMin(){
        return (T) pq[1];
    }

    /**
     * 改变堆顶元素，并调整堆结构
     * @param t
     */
    public void replaceTop(T t){
        pq[1] = t;
        sinkBetter(1);
    }

    @Override
    public String print() {
        return printMinPQ();
    }

    @Override
    public String toString() {
        return "MinPQ{" +
                "count=" + count +
                ", pq=" + printMinPQ() +
                '}';
    }

    /**
     * 堆的上浮，如果子节点比父节点小，就交换
     * @param k 节点k上浮
     */
    private void swim(int k){
        //子节点比父结点大
        while (k > 1 && less(k,k/2)){
            //交换两个节点
            exch(k/2,k);
            k = k/2;
        }
    }

    /**
     * 堆的上浮，如果子节点比父节点小，就交换。优化堆的上浮过程
     * @param k 节点k上浮
     */
    private void swimBetter(int k){
        Comparable temp =  pq[k];
        //子节点比父结点大
        while (k > 1 && less(k,k/2)){
            //父结点移到子节点 子节点暂存 不用每次都去新建一个临时变量来交换
            pq[k] = pq[k/2];
            pq[k/2] = temp;
            k = k/2;
        }
    }


    /**
     * 堆的下沉 父结点大于子节点,将父节点与较小的子节点交换,并下沉子节点
     * @param k
     */
    private void sink(int k){
        if (k > count){
            return;
        }
        int i = 2 * k;
        if (i > count ){
            return;
        }

        //只有左子节点 i = count;
        if ((i+1) > count){
            if (less(i,k)){
                exch(k,i);
            }
            return;
        }

        //父节点与较小的子节点交换
        if (less(i,k) || less(i+1,k)){
            //将父节点与较小的节点交换
            if (less(i,i+1)){
                exch(k,i);
                sink(i);
            }else {
                exch(k,i+1);
                sink(i+1);
            }
        }
    }


    /**
     * 堆的下沉 父结点大于子节点,将父节点与较小的子节点交换
     * @param k
     */
    private void sinkBetter(int k) {
        Comparable temp = pq[k];
        //判断有左孩子，有孩子就行
        while (2 * k <= count) {
            int j = 2 * k; //此轮循环中 k 与j交换
            if ((j + 1) <= count && less(j+1, j)) {
                j++; //更新为右孩子
            }
            //父结点大于子节点
            if (!less(j, k)) {
                break;
            }

            //将子节点移到父结点,父结点移到子节点 不用每次都去新建一个临时变量来交换
            pq[k] = pq[j];
            pq[j] = temp;
            k = j; //更新k的位置
        }
    }

    private String printMinPQ(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int size = count;
        for (int i = 0 ;i < size ;i++){
            builder.append(delMin() + " ");
        }
        builder.append("]");
        return builder.toString();
    }
}
