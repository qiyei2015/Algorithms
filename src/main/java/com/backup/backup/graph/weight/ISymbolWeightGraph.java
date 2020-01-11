package com.backup.backup.graph.weight;

/**
 * @author Created by qiyei2015 on 2018/7/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public interface ISymbolWeightGraph<T extends Number & Comparable<T>> {

    /**
     * 顶点数
     * @return
     */
    int size();

    /**
     * 是否包含key
     * @param key
     * @return
     */
    boolean contains(String key);

    /**
     * key的索引
     * @param key
     * @return
     */
    int index(String key);

    /**
     * index处的T值
     * @param index
     * @return
     */
    String name(int index);

    /**
     * 所对应的图
     * @return
     */
    IWeightGraph<T> graph();

    /**
     * 字符索引转index
     * @param str
     * @return
     */
    int[] toIndex(String[] str);

    /**
     * index转symbol
     * @param array
     * @return
     */
    String[] toSymbol(int[] array);
}
