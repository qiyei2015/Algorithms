package com.qiyei.graph.impl;

import com.qiyei.graph.Graph;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/2/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class GraphImpl implements Graph {

    private AdjTreeSet mGraphImpl;

    public GraphImpl(String filename) {
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
    public void removeEdge(int v, int w) {
        mGraphImpl.removeEdge(v,w);
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
    public void validateVertex(int v) {
        mGraphImpl.validateVertex(v);
    }

    @Override
    public Graph clone() {
        return mGraphImpl.clone();
    }

    @Override
    public String toString() {
        return mGraphImpl.toString();
    }


    public static void main(String[] args) {
        Graph graph = new GraphImpl("g.txt");
        System.out.println(graph.toString());
    }
}
