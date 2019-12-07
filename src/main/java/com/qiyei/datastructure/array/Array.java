package com.qiyei.datastructure.array;

/**
 * @author Created by qiyei2015 on 2018/4/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 动态数组
 */
public class Array<E> {

    /**
     * 默认容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 保存元素的数组
     */
    private E[] element;
    /**
     * 元素个数大小
     */
    private int size;

    /**
     * 容量大小
     */
    private int capacity;

    /**
     * 默认构造函数
     */
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造方法
     * @param capacity
     */
    public Array(int capacity){
        this.capacity = capacity;
        size = 0;
        element = (E[])new Object[capacity];
    }

    /**
     * 添加元素
     * @param t
     */
    public void addFirst(E t){
        add(0,t);
    }

    /**
     * 添加元素
     * @param t
     */
    public void addLast(E t){
        add(size,t);
    }

    /**
     *
     * @param index
     * @param t
     */
    public void add(int index,E t){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("index illegal");
        }
        if (size == capacity){
            resize(2 * capacity);
        }
        //右移一位
        for (int i = size - 1; i >= index ;i--){
            element[i+1] = element[i];
        }
        element[index] = t;
        size++;
    }

    /**
     * 删除第0个
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除末尾元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除元素
     * @param index
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        E e = element[index];
        //左移一位,注意不要从index开始，否则可能数组越界
        for (int i = index + 1;i < size;i++){
            element[i - 1] = element[i];
        }
        size--;
        element[size] = null;
        //缩容到一半，防止震荡
        if ((size == capacity / 4) && ((capacity / 2) != 0)){
            resize(capacity / 2);
        }
        return e;
    }


    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取该元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        return element[index];
    }

    /**
     * 修改
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index illegal");
        }
        element[index] = e;
    }

    /**
     * 判断是否为null
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 返回大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 容量大小
     * @return
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * 调整数组大小
     * @param n
     */
    private void resize(int n) {
        E[] newData = (E[]) new Object[n];

        //拷贝元素
        System.arraycopy(element,0,newData,0,size);
        element = newData;
        capacity = element.length;
    }

    /**
     * 交换两个元素
     * @param index1
     * @param index2
     */
    public void swap(int index1,int index2){
        if ((index1 < size && index1 >= 0) && (index2 < size && index2 >= 0)){
            E temp = element[index1];
            element[index1] = element[index2];
            element[index2] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:size=%d,capacity=%d\n",size,capacity));
        builder.append("[");
        for (int i = 0 ; i < size ; i++){
            builder.append(element[i]);
            if (i != size - 1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
