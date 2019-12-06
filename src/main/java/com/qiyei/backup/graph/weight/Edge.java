package com.qiyei.backup.graph.weight;

/**
 * @author Created by qiyei2015 on 2018/4/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 边对于有向图，v -> w
 */
public class Edge<T extends Number & Comparable> implements Comparable<Edge<T>>{
    /**
     * 顶点v
     */
    private int v;
    /**
     * 顶点w
     */
    private int w;
    /**
     * 权重
     */
    private T weight;

    public Edge(int v, int w, T weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 返回n的另一个顶点
     * @param n
     * @return
     */
    public int other(int n){
        if (n == v || n == w){
            return n == v ? w : v;
        }
        return -1;
    }

    /**
     * 返回v-w的镜像边 即 w-v
     * @return
     */
    public Edge<T> mirrorEdge(){
        return new Edge<>(w,v,weight);
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public T getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<T> o) {
        if (weight.compareTo(o.getWeight()) < 0){
            return -1;
        }else if (weight.compareTo(o.getWeight()) > 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return v + "-"+ w + ": " + weight;
    }

}
