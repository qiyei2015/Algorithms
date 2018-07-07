package com.qiyei.graph.weight;

import com.qiyei.graph.weight.Edge;
import com.qiyei.graph.weight.IWeightGraph;
import com.qiyei.heap.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/4/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: Prim 最小生成树算法 根据切分定理  事件复杂度 O(ElogV)
 */
public class PrimMST<T extends Number & Comparable<T>> {

    /**
     * 图
     */
    private IWeightGraph mWeightGraph;
    /**
     * 最小堆
     */
    private IndexMinHeap<Edge<T>> indexMinHeap;
    /**
     * 顶点访问的边
     */
    private Edge<T>[] edgeTo;
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
    public PrimMST(IWeightGraph graph) {
        this.mWeightGraph = graph;
        indexMinHeap = new IndexMinHeap<>(mWeightGraph.V());
        edgeTo = new Edge[mWeightGraph.V()];
        mst = new ArrayList<>();
        minWeight = new Double(0);
        marked = new boolean[mWeightGraph.V()];
        for (int i = 0 ; i < mWeightGraph.V() ; i++){
            marked[i] = false;
        }
        //Prim算法
        visit(0);
        while (!indexMinHeap.isEmpty()){
            //取出最小堆堆顶元素的索引 取出最小横切边的索引
            int v = indexMinHeap.extractIndexMin();
            //该边存在
            if (edgeTo[v] == null){
                continue;
            }
            //该横切边就是最小生成树
            mst.add(edgeTo[v]);

            //继续访问该索引结点对应的邻边
            visit(v);
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
            int w = edge.other(v);
            //必须是邻切边
            if (!marked[w]){
                //如果这个顶点的w边没有被访问,就访问该 v - w 边，并且把权值加入到最小索引堆中
                if (edgeTo[w] == null){
                    edgeTo[w] = edge;
                    indexMinHeap.insert(w,edge);
                }else if (edge.getWeight().compareTo(edgeTo[w].getWeight()) < 0){
                    //如果改边已经被访问过，则比较权值,新的边小于之前的权值，更新边，更新索引堆
                    edgeTo[w] = edge;
                    indexMinHeap.replace(w,edge);
                }
            }
        }
    }

}
