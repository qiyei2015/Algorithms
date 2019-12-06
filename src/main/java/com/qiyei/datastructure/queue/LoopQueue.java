package com.qiyei.datastructure.queue;


/**
 * @author Created by qiyei2015 on 2019/11/30.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 循环队列实现
 */
public class LoopQueue<E> implements IQueue<E> {

    /**
     * 数据元素
     */
    private E[] data;
    /**
     * 大小
     */
    private int size;
    /**
     * 指向队首元素
     */
    private int front;
    /**
     * 队尾元素，指向下一个入队的元素
     */
    private int tail;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity){
        //循环队列会浪费一个存储空间，因此这里多分配一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        //更新tail
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty,can not dequeue");
        }
        E e = data[front];
        data[front] = null;

        //更新front
        front = (front + 1) % data.length;
        size--;
        int capacity = getCapacity();
        if (size == capacity / 4 && (capacity / 2 != 0 )){
            resize(capacity / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty,can not dequeue");
        }
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue:size=%d,capacity=%d\n",size,getCapacity()));
        builder.append("front [");
        //遍历
        for (int i = front ; i != tail ; i = (i + 1) % data.length){
            builder.append(data[i]);
            //最后一个元素 (i+1) % data.length == tail
            if (((i+1) % data.length) != tail){
                builder.append(",");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }

    /**
     * 队列是否满了
     * @return
     */
    private boolean isFull(){
        return (tail + 1) % data.length == front;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity + 1];
        //迁移数据到新数组中
        for (int i = 0 ;i < size ;i++){
            //旧数组中第一个元素front
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        //更新front和tail
        front = 0;
        tail = size;
    }

}
