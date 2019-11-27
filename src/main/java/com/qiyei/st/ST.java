package com.qiyei.st;

/**
 * @author Created by qiyei2015 on 2018/5/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有序符号表
 */
public abstract class ST<K extends Comparable<K>,V> implements IST<K,V>{

    /**
     * 构造方法
     */
    public ST() {
    }


    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void delete(K key) {
        put(key,null);
    }

    @Override
    public boolean contains(K key) {
        return get(key) == null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    /**
     * 最小key值
     * @return
     */
    public K min(){
        return null;
    }

    /**
     * 最大key值
     * @return
     */
    public K max(){
        return null;
    }

    /**
     * 小于等于key的最大值
     * @param key
     * @return
     */
    public K floor(K key){
        return null;
    }

    /**
     * 大于等于key的最小值
     * @param key
     * @return
     */
    public K ceil(K key){
        return null;
    }

    /**
     * 排名，小于key的键的数量
     * @param key
     * @return
     */
    public int rank(K key){
        return -1;
    }

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    public K select(int k){
        return null;
    }

    /**
     * 删除最小的键
     */
    public void deleteMin(){
        delete(min());
    }

    /**
     * 删除最大的键
     */
    public void deleteMax(){
        delete(max());
    }

    /**
     * [lo hi]之间的的键的个数
     * @param lo
     * @param hi
     * @return
     */
    public int size(K lo,K hi){
        if (hi.compareTo(lo) < 0){
            return 0;
        }else if (contains(hi)){
            //包含的话，需要计算hi
            return rank(hi) - rank(lo) + 1;
        }else {
            return rank(hi) - rank(lo);
        }

    }

    /**
     * [lo,hi]之间所有键的集合，已排序
     * @param lo
     * @param hi
     * @return
     */
    public Iterable<K> keys(K lo,K hi){
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return keys(min(),max());
    }

    /**
     * lo小于hi
     * @param lo
     * @param hi
     * @return
     */
    protected boolean less(K lo,K hi){
        return lo.compareTo(hi) < 0;
    }

}
