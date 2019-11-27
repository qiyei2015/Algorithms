package com.qiyei.array;

/**
 * @author Created by qiyei2015 on 2018/4/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 动态数组
 */
public class DynamicArray<T> {

    /**
     * 默认容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 保存元素的数组
     */
    private T[] element;
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
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造方法
     * @param capacity
     */
    public DynamicArray(int capacity){
        this.capacity = capacity;
        size = 0;
        element = (T[])new Object[capacity];
    }

    /**
     * 添加元素
     * @param t
     */
    public void add(T t){
        up(size+1);
        element[size++] = t;
    }


    /**
     * 删除末尾元素
     */
    public void remove(){
        size--;
        down(size);
        element[size] = null;
    }

    /**
     * 删除元素
     * @param index
     */
    private void remove(int index){
        size--;
        down(size);
        element[index] = null;
    }

    /**
     * 获取该元素
     * @param index
     * @return
     */
    public T get(int index){
        return element[index];
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

    @Override
    public String toString() {
        return "DynamicArray{ " +
                "size=" + size +
                ", capacity=" + capacity +
                " }" +
                "\n" +
                "element=" + printElement();
    }

    /**
     * 增长
     * @param n
     */
    private void up(int n){
        if (n > capacity){
            capacity = capacity * 2;
            resize(capacity);
        }
    }

    /**
     * 降低
     * @param n
     */
    private void down(int n){
        if (n < capacity / 4){
            capacity = capacity / 2;
            resize(capacity);
        }
    }

    /**
     * 调整数组大小
     * @param n
     */
    private void resize(int n) {
        T[] temp = (T[]) new Object[n];
        //拷贝元素
        System.arraycopy(element,0,temp,0,size);
        element = temp;
    }

    /**
     * 打印数组元素
     * @return
     */
    private String printElement(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0 ; i < size ; i++){
            stringBuilder.append(element[i]);
            stringBuilder.append(", ");
        }
        //删除最后两个字符
        stringBuilder.delete(stringBuilder.length() - 2,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
