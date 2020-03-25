package com.qiyei.graph;

/**
 * @author Created by qiyei2015 on 2020/3/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有权边
 */
public class WeightedEdge< T extends Comparable> extends Edge implements Comparable<WeightedEdge> {

    /**
     * 权重
     */
    private T weight;

    public WeightedEdge(int v, int w,T weight) {
        super(v, w);
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        if (o == null){
            throw new IllegalArgumentException("cannot compare with null");
        }
        return weight.compareTo(o.weight);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d-%d",v,w))
                .append(":")
                .append(weight.toString());
        return builder.toString();
    }
}
