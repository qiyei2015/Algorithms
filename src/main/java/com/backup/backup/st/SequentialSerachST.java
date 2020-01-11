package com.backup.backup.st;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/5/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 继续链表的顺序表
 */
public class SequentialSerachST<K extends Comparable<K>,V> extends ST<K,V>{

    /**
     * 头结点
     */
    private Node<K,V> mFirst;
    /**
     * 最后一个节点
     */
    private Node<K,V> mLast;
    /**
     * 个数
     */
    private int mCount;

    /**
     * 链表节点
     * @param <K>
     * @param <V>
     */
    private class Node<K extends Comparable<K>,V> {
        public K key;
        public V value;
        public Node<K,V> next;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 构造方法
     */
    public SequentialSerachST() {
        super();
        mFirst = null;
        mLast = null;
        mCount = 0;
    }

    @Override
    public void put(K key, V value) {
        //存在key，直接找到替换
        if (contains(key)){
            for (Node node = mFirst ; node != null ; node = node.next){
                if (node.key == key){
                    node.value = value;
                }
            }
            return;
        }
        mCount++;
        /**
         * 第一个节点
         */
        if (mFirst == null){
            mFirst = new Node<>(key,value);
            mLast = mFirst;
        }else {
            Node<K,V> priv = mFirst;
            Node<K,V> insertNode = new Node<>(key,value);

            for (Node<K,V> node = mFirst ; node != null ; node = node.next){
                //找到合适的位置
                if (!less(node.key, key)) {
                    //新节点结点指向本节点
                    insertNode.next = node;
                    if (node == mFirst){
                        //上一个节点指向新节点
                        mFirst = insertNode;
                    }else {
                        //上一个节点指向新节点
                        priv.next = insertNode;
                    }
                    return;
                }
                priv = node;
            }
            priv.next = insertNode;
            mLast = insertNode;
        }
    }

    @Override
    public V get(K key) {
        for (Node node = mFirst ; node != null ; node = node.next){
            if (node.key == key){
                return (V) node.value;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        put(key,null);
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return mCount;
    }

    /**
     * 最小key值
     * @return
     */
    public K min(){
        return mFirst.key;
    }

    /**
     * 最大key值
     * @return
     */
    @Override
    public K max(){
        return mLast.key;
    }

    /**
     * 小于等于key的最大值
     * @param key
     * @return
     */
    @Override
    public K floor(K key){
        return null;
    }

    /**
     * 大于等于key的最小值
     * @param key
     * @return
     */
    @Override
    public K ceil(K key){
        return null;
    }

    /**
     * 排名，小于key的键的数量
     * @param key
     * @return
     */
    @Override
    public int rank(K key){
        return -1;
    }

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    @Override
    public K select(int k){
        return null;
    }

    /**
     * [lo,hi]之间所有键的集合，已排序
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<K> keys(K lo,K hi){
        List<K> list = new ArrayList<>();
        for (Node<K,V> node = mFirst ; node != null ; node = node.next){
            if (!less(node.key,lo) && !less(hi,node.key)){
                list.add(node.key);
            }
        }
        return list;
    }

    @Override
    public Iterable<K> keys() {
        List<K> list = new ArrayList<>();
        for (Node<K,V> node = mFirst ; node != null ; node = node.next){
            list.add(node.key);
        }
        return list;
    }

}
