package com.qiyei.graph;

/**
 * @author Created by qiyei2015 on 2020/3/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 图的边
 */
public class Edge {

    protected int v;
    protected int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return String.format("%d-%d",v,w);
    }


}
