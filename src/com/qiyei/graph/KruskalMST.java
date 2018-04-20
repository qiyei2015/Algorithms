package com.qiyei.graph;

import com.qiyei.heap.MinPQ;
import com.qiyei.unionfind.UnionFind;
import com.qiyei.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: kruskal 最小生成树算法  时间复杂度 O(ElogE)
 */
public class KruskalMST<T extends Number & Comparable<T>> {

    /**
     * 最小生成树构成的边
     */
    private List<Edge<T>> mst;

    /**
     * 该图的最小权值
     */
    private Number minWeight;

    /**
     * 构造函数，kruskal最小生成树算法
     * @param graph
     */
    public KruskalMST(IWeightGraph<T> graph) {

        mst = new ArrayList<>();
        minWeight = 0;

        //构造一个最小堆，大小为图的边数
        MinPQ<Edge<T>> minPQ = new MinPQ<>(graph.E());
        LogUtil.println("E:" + graph.E());
        //将边插入到最小堆中，进行堆的排序
        for (int i = 0; i < graph.V() ; i++){
            //遍历每个结点的邻接边
            for (Edge<T> edge : graph.adj(i)) {
                //防止重复插入堆中
                if (edge.getV() <= edge.getW()){
                    minPQ.insert(edge);
                }
            }
        }

        //构造一个并查集
        UnionFind unionFind = new UnionFind(graph.V());
        //如果mst的size() == 顶点数 - 1 说明最小生成树已经找完
        while (!minPQ.isEmpty() && mst.size() < graph.V() - 1){
            //取出最小边
            Edge<T> edge = minPQ.delMin();
            //如果这条边的两个顶点已经相连，则再连接，就会形成环
            if (!unionFind.connected(edge.getV(),edge.getW())){
                mst.add(edge);
                unionFind.union(edge.getV(),edge.getW());
            }
        }
        //计算权值
        for (Edge<T> edge : mst){
            minWeight = minWeight.doubleValue() + edge.getWeight().doubleValue();
        }
    }


    /**
     * 获取最小生成树的边
     * @return
     */
    public List<Edge<T>> getMstEdges() {
        return mst;
    }

    /**
     * 获取最小权值
     * @return
     */
    public Number getMinWeight() {
        return minWeight;
    }

}
