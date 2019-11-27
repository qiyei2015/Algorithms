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
     * 用数组创建堆,时间复杂度 O(N)
     * @param a
     */
    public MaxPQ(Comparable[] a){
        super(a);
        //最后一个父结点是 count / 2 [count/2...1]这个结点区间的结点都下沉，就是堆了
        for (int i = count/2; i >= 1 ; i--){
            sinkBetter(i);
        }
    }

    /**
     * 插入一个元素，并上浮
     * @param t
     */
    public void insert(T t){
        pq[++count] = t;
        swimBetter(count);
    }

    /**
     * 删除最大的元素
     * @return
     */
    public T delMax(){
        T t = (T) pq[1];
        //删除最大的，然后将末尾元素交换，并下沉
        exch(1,count);
        pq[count] = null;
        count--;
        sinkBetter(1);
        return t;
    }

    /**
     * 获取最大值
     * @return
     */
    public T getMax(){
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
        return printMaxPQ();
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "count=" + count +
                ", pq=" + printMaxPQ() +
                '}';
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
     * 堆的上浮，解决子节点比父结点大的问题,少交换，优化堆的上浮过程
     * @param k 节点k上浮
     */
    private void swimBetter(int k){
        Comparable temp =  pq[k];
        //子节点比父结点大
        while (k > 1 && less(k/2,k)){
            //父结点移到子节点 子节点暂存 不用每次都去新建一个临时变量来交换
            pq[k] = pq[k/2];
            pq[k/2] = temp;
            k = k/2;
        }
    }


    /**
     * 堆的下沉 父结点小于子节点,将父节点与较大的子节点交换
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
        if ((i + 1 ) > count){
            if (less(k,i)){
                exch(k,i);
            }
            return;
        }
        //两个孩子都大于父节点
        if (less(k,i) || less(k,i + 1)){
            if (less(i,i+1)){
                exch(k,i+1);
                sink(i+1);
            }else {
                exch(k,i);
                sink(i);
            }
        }

//        //判断有左孩子，有孩子就行
//        while (2 * k <= N){
//            int j = 2 * k; //此轮循环中 k 与j交换
//            if ((j +1) <= N && less(j,j+1)){
//                j++; //更新为右孩子
//            }
//            //父结点大于子节点
//            if (!less(k,j)){
//                break;
//            }
//            exch(k,j);
//            k = j; //更新k的位置
//        }

    }


    /**
     * 堆的下沉 父结点小于子节点,将父节点与较大的子节点交换
     * @param k
     */
    private void sinkBetter(int k) {
        Comparable temp = pq[k];
        //判断有左孩子，有孩子就行
        while (2 * k <= count) {
            int j = 2 * k; //此轮循环中 k 与j交换
            if ((j + 1) <= count && less(j, j + 1)) {
                j++; //更新为右孩子
            }
            //父结点大于子节点
            if (!less(k, j)) {
                break;
            }

            //将子节点移到父结点,父结点移到子节点 不用每次都去新建一个临时变量来交换
            pq[k] = pq[j];
            pq[j] = temp;
            k = j; //更新k的位置
        }
    }

    private String printMaxPQ(){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int size = count;
        for (int i = 0 ;i < size ;i++){
            builder.append(delMax() + " ");
        }
        builder.append("]");
        return builder.toString();
    }

}
