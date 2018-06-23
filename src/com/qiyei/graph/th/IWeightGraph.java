package com.qiyei.graph.th;


/**
 * @author Created by qiyei2015 on 2018/6/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: T结点泛型参数 W权重泛型参数
 */
public interface IWeightGraph<T extends Number & Comparable<T>,W extends Number & Comparable<W>> {

    /**
     * 顶点数
     * @return
     */
    int V();

    /**
     * 边数
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
    boolean hasEdge(T v,T w);

    /**
     * 在图中添加一条边 顶点是v - w
     * @param edge
     */
    void addEdge(Edge<T,W> edge);

    /**
     * 返回 v - w 对应的权值
     * @param v
     * @param w
     * @return
     */
    W getWeight(T v,T w);

    /**
     * 返回 path所指向的权重
     * @param path
     * @return
     */
    W getWeightForPath(T[] path);

    /**
     * 返回v的邻接边
     * @param v
     * @return
     */
    Iterable<Edge<T,W>> adj(T v);

    /**
     * 检查obj 是否在图里面
     * @param obj
     * @return
     */
    boolean assertV(T obj);
}
