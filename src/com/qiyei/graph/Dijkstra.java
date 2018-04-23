package com.qiyei.graph;

import com.qiyei.heap.IndexMinHeap;
import com.qiyei.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/4/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 单源最短路径Dijkstra算法
 */
public class Dijkstra<T extends Number & Comparable<T>> {

    /**
     * 图
     */
    private IWeightGraph<T> mGraph;
    /**
     * 最短路径的起始点 源
     */
    private int source;
    /**
     * 最短路径上权值 distTo[i]存储从起始点s到i的最短路径长度
     */
    private Number[] distTo;
    /**
     * 标记顶点i是否被访问
     */
    private boolean[] marked;
    /**
     * from[i]记录最短路径中, 到达i点的边是哪一条,可以用来恢复整个最短路径
     */
    private Edge<T>[] from;

    /**
     * 构造函数
     * @param graph
     * @param s
     */
    public Dijkstra(IWeightGraph<T> graph, int s) {
        this.mGraph = graph;
        this.source = s;
        distTo = new Number[mGraph.V()];
        marked = new boolean[mGraph.V()];
        from = new Edge[mGraph.V()];

        //最小索引堆，辅助数据结构
        IndexMinHeap<T> indexMinHeap = new IndexMinHeap<>(mGraph.V());

        //Dijkstra 算法
        distTo[source] = 0;
        marked[source] = true;
        from[source] = new Edge<T>(source,source,(T)(Number)0.0);
        indexMinHeap.insert(source,(T)distTo[source]);

        while (!indexMinHeap.isEmpty()){

            //取出权值最小的那条边的结点
            int v = indexMinHeap.extractIndexMin();
            marked[v] = true;

            //访问v的所有邻接边
            for (Edge<T> edge : mGraph.adj(v)){
                int w = edge.other(v);
                //w点没有被标记过
                if (!marked[w]){
                    //没有被访问过，并且通过v来访问，距离更短，则更新
                    if (from[w] == null || distTo[v].doubleValue() + edge.getWeight().doubleValue() < distTo[w].doubleValue()){
                        distTo[w] = distTo[v].doubleValue() + edge.getWeight().doubleValue();
                        from[w] = edge;
                        if (indexMinHeap.contains(w)){
                            indexMinHeap.replace(w,edge.getWeight());
                        }else {
                            indexMinHeap.insert(w,edge.getWeight());
                        }
                    }
                }
            }
        }

    }

    /**
     * 到w点的最短路径长度
     * @param w
     * @return
     */
    public Number shortestPathTo(int w){
        return distTo[w];
    }

    /**
     * 判断从source 到w点是否有最短路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        return marked[w];
    }

    /**
     * 从source到w的最短路径
     * @param w
     * @return
     */
    public List<Edge<T>> shortestPath(int w){
        List<Edge<T>> list = new ArrayList<>();

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<T>> stack = new Stack<Edge<T>>();
        Edge<T> edge = from[w];
        while(edge.getV() != source ){
            stack.push(edge);
            edge = from[edge.getV()];
        }
        stack.push(edge);

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        while(!stack.empty() ){
            edge = stack.pop();
            list.add(edge);
        }
        return list;
    }

    /**
     * 打印从source 到 w点的最短路径
     * @param w
     */
    public void showShortestPath(int w){
        LogUtil.println("shortest weight:" + distTo[w]);
        Number result = new Double(0);
        for (Edge edge : shortestPath(w)){
            result = result.doubleValue() + edge.getWeight().doubleValue();
            LogUtil.println(edge.toString() + " ");
        }

        LogUtil.println("result weight:" + result.doubleValue());

    }
}
