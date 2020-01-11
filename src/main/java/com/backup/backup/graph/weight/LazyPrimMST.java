package com.backup.backup.graph.weight;

import com.backup.backup.heap.MinPQ;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Created by qiyei2015 on 2018/4/18.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: LazyPrim 最小生成树算法 根据切分定理 时间复杂度O(ElogE)
 */
public class LazyPrimMST<T extends Number & Comparable<T>> {

    /**
     * 图
     */
    private IWeightGraph mWeightGraph;
    /**
     * 最小堆
     */
    private MinPQ<Edge<T>> minPQ;
    /**
     * 标记顶点是否被访问
     */
    private boolean[] marked;
    /**
     * 最小生成树构成的边
     */
    private List<Edge<T>> mst;

    /**
     * 该图的最小权值
     */
    private Number minWeight;

    /**
     * 最小生成树构造函数
     * @param graph
     */
    public LazyPrimMST(IWeightGraph graph) {
        this.mWeightGraph = graph;
        minPQ = new MinPQ<>(mWeightGraph.E());
        mst = new ArrayList<>();
        minWeight = new Double(0);
        marked = new boolean[mWeightGraph.V()];
        for (int i = 0 ; i < mWeightGraph.V() ; i++){
            marked[i] = false;
        }
        //lazy Prim算法
        visit(0);
        while (!minPQ.isEmpty()){
            Edge<T> edge = minPQ.delMin();
            //有可能不是最生成树的边，要抛弃，例如全部已经被访问了，但是权值最小，要抛弃
            if (marked[edge.getW()] == marked[edge.getV()]){
                continue;
            }
            //是最小生成树的边
            mst.add(edge);
            //访问未被访问的结点
            if (marked[edge.getV()]){
                visit(edge.getW());
            }else {
                visit(edge.getV());
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

    /**
     * 访问v结点，并将v结点添加到最小堆中
     * @param v
     */
    private void visit(int v){
        if (marked[v]){
            return;
        }
        marked[v] = true;
        //找到邻切边 如果相邻的边另外一个结点没有被访问就是邻切边
        for (Edge<T> edge : (List<Edge<T>>) mWeightGraph.adj(v)){
            if (!marked[edge.other(v)]){
                //加入到最小堆中
                minPQ.insert(edge);
            }
        }
    }
}
