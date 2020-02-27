package com.qiyei.graph;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/2/23.
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
    default boolean isDirected() {
        return false;
    };

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
    List<Integer> adj(int v);

    /**
     * 返回顶点的度数
     * @param v
     * @return
     */
    int degree(int v);

}
