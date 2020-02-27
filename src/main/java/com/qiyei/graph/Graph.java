package com.qiyei.graph;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/2/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Graph implements IGraph {

    private AdjTreeSet mGraphImpl;

    public Graph(String filename) {
        mGraphImpl = new AdjTreeSet(filename);
    }

    @Override
    public int V() {
        return mGraphImpl.V();
    }

    @Override
    public int E() {
        return mGraphImpl.E();
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return mGraphImpl.hasEdge(v,w);
    }

    @Override
    public void addEdge(int v, int w) {
        mGraphImpl.addEdge(v,w);
    }

    @Override
    public List<Integer> adj(int v) {
        return mGraphImpl.adj(v);
    }

    @Override
    public int degree(int v) {
        return mGraphImpl.degree(v);
    }

    @Override
    public String toString() {
        return mGraphImpl.toString();
    }
}
