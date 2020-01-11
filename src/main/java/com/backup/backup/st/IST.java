package com.backup.backup.st;

/**
 * @author Created by qiyei2015 on 2018/5/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 符号表接口
 */
public interface IST<K,V> {

    /**
     * 插入
     * @param key
     * @param value
     */
    void put(K key,V value);

    /**
     * 获取
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除
     * @param key
     */
    void delete(K key);

    /**
     * 是否包含
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 是否为NULL
     * @return
     */
    boolean isEmpty();

    /**
     * 大小
     * @return
     */
    int size();

    /**
     * 迭代key
     * @return
     */
    Iterable<K> keys();

}
