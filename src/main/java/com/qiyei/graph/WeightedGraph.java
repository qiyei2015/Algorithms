package com.qiyei.graph;

/**
 * @author Created by qiyei2015 on 2020/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有权图
 */
public interface WeightedGraph<T extends Comparable> extends Graph {
    /**
     * 获取v - w 边的权值
     * @param v
     * @param w
     * @return
     */
    T getWeight(int v, int w);


    void addEdge(int v, int w,T weight);

    @Override
    WeightedGraph<T> clone();
}
