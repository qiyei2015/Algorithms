package com.qiyei.heap;

/**
 * @author Created by qiyei2015 on 2018/3/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 索引最大堆
 */
public class IndexMaxHeap<T extends Comparable<T>> extends BaseHeap{

    /**
     * 索引 记录原始数组pq[]中数据的索引
     */
    private int[] indexArray;

    public IndexMaxHeap() {
        super();
        indexArray = new int[0];
    }

    public IndexMaxHeap(int max) {
        super(max);
        indexArray = new int[max + 1];
    }

    public IndexMaxHeap(Comparable[] array) {
        super(array);
//        System.arraycopy(array,0,in,1,array.length);
    }

    /**
     * 插入元素
     * @param i 从0 开始计算
     * @param t
     */
    public void insert(int i,T t){
        if (i < 0 || i >= N){
            return;
        }
        i += 1;
        //记录数据
        pq[i] = t;
        //记录索引位置 从1开始记录索引
        indexArray[++count] = i;
        swimIndex(count);
    }


    /**
     * 删除最大的元素
     * @return
     */
    public T delMax(){
        //先找到索引,根据索引找到数
        int index = indexArray[1];
        T t = (T) pq[index];
        exch(indexArray[count],index);
        count--;
        sinkIndex(index);
        return t;
    }


    /**
     * 堆的上浮，解决子节点比父结点大的问题,少交换，优化堆的上浮过程
     * @param k 节点k上浮
     */
    private void swimIndex(int k){
        Comparable temp = pq[indexArray[k]];
        //子节点比父结点大
        while (k > 1 && less(indexArray[k/2],indexArray[k])){
            //父结点移到子节点 子节点暂存 不用每次都去新建一个临时变量来交换
            pq[indexArray[k]] = pq[indexArray[k/2]];
            pq[indexArray[k/2]] = temp;
            k = k/2;
        }
    }

    /**
     * 堆的下沉 父结点小于子节点,将父节点与交大的子节点交换
     * @param k
     */
    private void sinkIndex(int k) {
        Comparable temp = pq[indexArray[k]];
        //判断有左孩子，有孩子就行
        while (2 * k <= count) {
            int j = 2 * k; //此轮循环中 k 与j交换
            if ((j + 1) <= count && less(indexArray[j], indexArray[j + 1])) {
                j++; //更新为右孩子
            }
            //父结点大于子节点
            if (!less(indexArray[k], indexArray[j])) {
                break;
            }

            //将子节点移到父结点,父结点移到子节点 不用每次都去新建一个临时变量来交换
            pq[indexArray[k]] = pq[indexArray[j]];
            pq[indexArray[j]] = temp;
            k = j; //更新k的位置
        }
    }


}
