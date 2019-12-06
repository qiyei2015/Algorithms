package com.qiyei.backup.graph.weight;

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
     * 在图中添加一条边 顶点是v - w
     * @param edge
     */
    void addEdge(Edge<T> edge);

    /**
     * 返回 v - w 对应的权值
     * @param v
     * @param w
     * @return
     */
    T getWeight(int v,int w);

    /**
     * 返回v连接的边
     * @param v
     * @return
     */
    Iterable<Edge<T>> adj(int v);

    /**
     * 遍历路径权重
     * @param path
     * @return
     */
    T getWeightFor(int[] path);

}
