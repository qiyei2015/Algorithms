package com.qiyei.graph;

/**
 * @author Created by qiyei2015 on 2018/4/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有权图
 */
public interface IWeightGraph<T extends Number & Comparable<T>> {

    /**
     * 返回顶点数
     * @return
     */
    int V();

    /**
     * 返回边数
     * @return
     */
    int E();

    /**
     * 是否为有向图
     * @return
     */
    boolean isDirected();

    /**
     * 是否有边
     * @return
     */
    boolean hasEdge(int v,int w);

    /**
     * 在v,w之间添加一条边
     * @param v
     * @param w
     */
    void addEdge(int v,int w,Edge<T> edge);

    /**
     * 返回v相邻的顶点
     * @param v
     * @return
     */
    Iterable<Edge<T>> adj(int v);

}
