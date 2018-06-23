package com.qiyei.graph.th;

/**
 * @author Created by qiyei2015 on 2018/4/15.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 边对于有向图，v -> w
 */
public class Edge<T extends Number & Comparable<T>,W extends Number & Comparable<W>> implements Comparable<Edge<T,W>>{
    /**
     * 顶点v
     */
    private T v;
    /**
     * 顶点w
     */
    private T w;

    /**
     * 权重
     */
    private W weight;

    public Edge(T v, T w, W weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 返回n的另一个顶点
     * @param n
     * @return
     */
    public T other(T n){
        if (n == null){
            return null;
        }

        if (n.equals(v) || n.equals(w)){
            return n.equals(v) ? w : v;
        }
        return null;
    }

    /**
     * 返回v-w的镜像边 即 w-v
     * @return
     */
    public Edge<T,W> mirrorEdge(){
        return new Edge<>(w,v,weight);
    }

    public T getV() {
        return v;
    }

    public T getW() {
        return w;
    }

    public W getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<T,W> o) {
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
