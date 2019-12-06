package com.qiyei.backup.heap;

import com.qiyei.backup.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/4/19.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 索引最小堆indexArray[]构成堆  最大特点，比较是比较pq[]的值，交换是交换indexArray[]的值
 */
public class IndexMinHeap<T extends Comparable<T>> extends BaseHeap {

    /**
     * 索引 indexArray的值是pq[]的下标
     */
    private int[] indexArray;

    public IndexMinHeap() {
        super();
        indexArray = new int[0];
    }

    public IndexMinHeap(int max) {
        super(max);
        indexArray = new int[max + 1];
    }

//    public IndexMinHeap(Comparable[] array) {
//        super(array);
//    }

    /**
     * 插入元素到最小索引堆
     * @param i 从0 开始计算
     * @param t
     */
    public void insert(int i,T t){
        if (i < 0 || i >= N){
            return;
        }
        i += 1;
        //记录数据 pq[] 下标i为t
        pq[i] = t;
        //记录索引位置 从1开始记录索引
        count = count + 1;
        indexArray[count] = i;
        //上浮count
        swimIndex(count);
    }

    /**
     * 删除最小的元素 从最小堆取出堆顶元素
     * @return
     */
    public T delMin(){
        //先找到索引,根据索引找到数
        int index = indexArray[1];
        T t = (T) pq[index];
        exchIndex(1,count);
        count--;
        //下沉堆顶元素
        sinkIndex(1);
        return t;
    }

    /**
     * 获取最小的堆顶的元素
     * @return
     */
    public T getMin(){
        return (T) pq[indexArray[1]];
    }

    /**
     * 从堆中取出最小元素的索引,不删除元素
     * @return
     */
    public int getIndexMin(){
        return indexArray[1] - 1;
    }

    /**
     * 取出最小堆堆顶元素，并删除该元素
     * @return
     */
    public int extractIndexMin(){
        int index = indexArray[1] - 1;
        //交换索引
        exchIndex(1,count);
        count--;
        //下沉
        sinkIndex(1);
        return index;
    }

    /**
     * 获取最大索引堆索引为i的元素的值
     * @param i
     * @return
     */
    public T getItemIndex(int i){
        return (T) pq[indexArray[i+1]];
    }

    /**
     * 将堆中索引为i的元素值替换为t
     * @param i
     * @param t
     */
    public void replace(int i , T t){
        i++;
        pq[i] = t;
        for (int j = 0 ; j < count ; j++){
            if (indexArray[j] == i){
                sinkIndex(j);
                swimIndex(j);
                return;
            }
        }
    }

    /**
     * 是否包含w结点
     * @param w
     * @return
     */
    public boolean contains(int w){
        w++;
        if (w >= 1 && w <= count){
            return true;
        }
        return false;
    }

    /**
     * 堆的上浮，解决子节点比父结点小的问题,少交换，优化堆的上浮过程
     * 比较是比较pq[]的值，交换是交换indexArray[]的值
     * @param k 节点k上浮
     */
    private void swimIndex(int k){
        //取索引数组的值，然后得到pq的索引
        int temp = indexArray[k];
        //如果子节点比父节点小，就交换二者的索引数组
        while (k > 1 && less(indexArray[k],indexArray[k/2])){
            //父结点移到子节点 子节点暂存 不用每次都去新建一个临时变量来交换
            indexArray[k] = indexArray[k/2];
            indexArray[k/2] = temp;
            k = k/2;
        }
    }

    /**
     * 堆的下沉 父结点大于子节点,将父节点与较小的子节点交换
     * 比较是比较pq[]的值，交换是交换indexArray[]的值
     * @param k
     */
    private void sinkIndex(int k) {
        int temp = indexArray[k];
        //判断有左孩子，有孩子就行
        while (2 * k <= count) {
            int j = 2 * k; //此轮循环中 k 与j交换 交换较小的孩子
            if ((j + 1) <= count && less(indexArray[j+1], indexArray[j])) {
                j++; //更新为右孩子
            }
            //父结点小于子节点
            if (less(indexArray[k], indexArray[j])) {
                break;
            }

            //将子节点移到父结点,父结点移到子节点 不用每次都去新建一个临时变量来交换
            indexArray[k] = indexArray[j];
            indexArray[j] = temp;
            k = j; //更新k的位置
        }
    }

    /**
     * 交换索引位置
     * @param i
     * @param j
     */
    private void exchIndex(int i, int j) {
        int temp = indexArray[i];
        indexArray[i] = indexArray[j];
        indexArray[j] = temp;
    }

    /**
     * 打印数组
     */
    public void printData(){
        for (int i = 1 ; i < pq.length ;i++){
            LogUtil.println("data:[ " + (i - 1) + " " + pq[i] + " ]");
        }
    }
}
