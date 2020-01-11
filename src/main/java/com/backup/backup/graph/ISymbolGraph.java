package com.backup.backup.graph;

/**
 * @author Created by qiyei2015 on 2018/7/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 符号图
 */
public interface ISymbolGraph {

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
    IGraph graph();
}
