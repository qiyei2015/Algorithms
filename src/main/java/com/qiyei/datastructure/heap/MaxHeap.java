package com.qiyei.datastructure.heap;

import com.qiyei.datastructure.array.Array;

/**
 * @author Created by qiyei2015 on 2019/12/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 堆是一个完全二叉树，最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 存储堆中元素,index[0]开始存储
     * 也可以考虑从index[1]开始存储，那么 父结点与子结点的索引算法需要修改
     */
    private Array<E> data;


    public MaxHeap() {
        data = new Array<>(10);
    }

    /**
     * 返回元素个数
     * @return
     */
    public int size(){
        return data.size();
    }

    /**
     * 堆中元素是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树中数组表示中，index索引的父结点索引
     * @param index
     * @return
     */
    private int indexParent(int index){
        if (index <= 0){
            throw new IllegalArgumentException("index can not < 0");
        }

        return (index - 1) / 2;
    }

    /**
     * 左子结点的索引
     * @param index
     * @return
     */
    private int indexLeftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 右子结点的索引
     * @param index
     * @return
     */
    private int indexRightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(size() - 1);
    }

    /**
     * 堆的上浮
     * 当子结点比父节点大时，交换结点与父节点，使其保持堆的结构
     * @param index
     */
    private void siftUp(int index){
        while (index > 0 && (data.get(index).compareTo(data.get(indexParent(index))) > 0)){
            data.swap(index,indexParent(index));
            index = indexParent(index);
        }
    }

    /**
     * 移除最大的元素
     * @return
     */
    public E extractMax(){
        E e = findMax();

        //1 将最后一个结点和最大结点交换
        data.swap(0,size() - 1);
        //2 移除最后一个结点
        data.removeLast();
        //3 下沉index为0的元素
        siftDown(0);
        return e;
    }

    /**
     * 找到堆中最大的元素，对于最大堆就是索引为0
     * 的元素
     * @return
     */
    public E findMax(){
        return data.getFirst();
    }

    /**
     * 堆的下沉
     * 当父结点比子结点小时，交换较大的子结点与父节点，重复递归下去
     * @param index
     */
    private void siftDown(int index){

        //index的左子树结点必须小于总结点个数，否则index已经是根节点了
        while (indexLeftChild(index) < size()){
            int j = indexLeftChild(index);
            //存在右子结点,并且右子结点大于左子结点
            if (j + 1 < size() && data.get(j + 1 ).compareTo(data.get(j)) > 0){
                j++;
            }

            //考虑相等的情况
            if (data.get(index).compareTo(data.get(j)) >= 0){
                break;
            }

            data.swap(index,j);
            index = j;
        }
    }

    /**
     * 将堆中最大元素替换成e,并保持堆的结构不变
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
