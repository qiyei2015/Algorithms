package com.backup.backup.graph;

/**
 * @author Created by qiyei2015 on 2018/4/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public interface IGraph {

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
    void addEdge(int v,int w);

    /**
     * 返回v相邻的顶点
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

}
