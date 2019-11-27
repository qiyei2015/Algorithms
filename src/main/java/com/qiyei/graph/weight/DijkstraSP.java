package com.qiyei.graph.weight;

import com.qiyei.heap.IndexMinHeap;
import com.qiyei.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/7/9.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 单源最短路径Dijkstra算法 事件复杂度O(E*LogV) 空间复杂度 O(V)
 */
public class DijkstraSP<T extends Number & Comparable<T>> {

    /**
     * 记录最短路径中，到达i是那一条边
     */
    private Edge<T>[] edgeTo;
    /**
     * 到达i的最短路径的权值
     */
    private Number[] distTo;
    /**
     * 辅助数据结构，最小索引堆
     */
    private IndexMinHeap<Edge<T>> pq;
    /**
     * 起点
     */
    private int mSource;
    /**
     * 图
     */
    private IWeightGraph<T> mGraph;
    /**
     * 最大值
     */
    private static final Number MAX = Integer.MAX_VALUE;

    /**
     * 构造方法
     * @param mGraph
     * @param mSource
     */
    public DijkstraSP(IWeightGraph<T> mGraph,int mSource) {
        this.mSource = mSource;
        this.mGraph = mGraph;
        init();

        //进行Dijkstra算法
        dijkstra(mSource);
    }

    /**
     * 到w点的最短路径长度
     * @param w
     * @return
     */
    public T distTo(int w){
        return (T)distTo[w];
    }

    /**
     * 判断从source 到w点是否有最短路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        return distTo[w].doubleValue() < MAX.doubleValue();
    }

    /**
     * 从source到w的最短路径
     * @param w
     * @return
     */
    public List<Edge<T>> pathTo(int w){
        List<Edge<T>> list = new ArrayList<>();

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<T>> stack = new Stack<Edge<T>>();

        for (Edge<T> edge = edgeTo[w] ; edge != null ;edge = edgeTo[edge.getV()]){
            stack.push(edge);
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        while(!stack.empty() ){
            Edge<T> edge = stack.pop();
            list.add(edge);
        }
        return list;
    }

    /**
     * 打印从source 到 w点的最短路径
     * @param w
     */
    public void showPath(int w){
        if (!hasPath(w)){
            return;
        }
        LogUtil.println("shortest weight:" + distTo[w]);
        Number result = new Double(0);
        for (Edge edge : pathTo(w)){
            result = result.doubleValue() + edge.getWeight().doubleValue();
            LogUtil.println(edge.toString() + " ");
        }

        LogUtil.println("result weight:" + result.doubleValue());

    }


    /**
     * 初始化
     */
    private void init(){
        edgeTo = new Edge[mGraph.V()];
        distTo = new Number[mGraph.V()];
        for (int i = 0;i < mGraph.V();i++){
            distTo[i] = MAX;
        }
        distTo[mSource] = 0;
        pq = new IndexMinHeap<>(mGraph.V());
    }

    /**
     * 堆顶点v进行松弛操作
     * @param v
     */
    private void relax(int v){
        for (Edge edge : mGraph.adj(v)){
            int w = edge.other(v);
            //如果发现从v到达w的路径比distTo[w]小，则说明v-w是最短路径。则更新数据结构
            if (distTo[w].doubleValue() > distTo[v].doubleValue() + edge.getWeight().doubleValue()){
                distTo[w] = distTo[v].doubleValue() + edge.getWeight().doubleValue();
                edgeTo[w] = edge;
                //更新索引堆中数据结构
                if (pq.contains(w)){
                    pq.replace(w,edge);
                }else {
                    pq.insert(w,edge);
                }
            }
        }
    }

    /**
     * 单源最短路径Dijkstra算法
     * @param source
     */
    private void dijkstra(int source){
        distTo[source] = 0;
        edgeTo[source] = null;
        pq.insert(source,edgeTo[source]);

        while (!pq.isEmpty()){
            int v = pq.extractIndexMin();
            relax(v);
        }
    }

}
