package com.backup.backup.graph.weight;

import com.backup.backup.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/4/25.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 单元最短路径 BellmanFord最短路径算法
 */
public class BellmanFord<T extends Number & Comparable<T>> {

    /**
     * 图
     */
    private IWeightGraph<T> mGraph;
    /**
     * 最短路径的起始点 源
     */
    private int source;
    /**
     * 最短路径上权值 distTo[i]存储从起始点s到i的最短路径长度 即权值
     */
    private Number[] distTo;
    /**
     * from[i]表示到达i的那条边是那条边 v - W
     */
    private Edge<T>[] from;

    /**
     * 是否有负权环
     */
    private boolean negativeCycle;


    public BellmanFord(IWeightGraph<T> graph, int source) {
        this.mGraph = graph;
        this.source = source;

        distTo = new Number[mGraph.V()];
        from = new Edge[mGraph.V()];

        distTo[source] = new Double(0);
        from[source] = new Edge<T>(source,source,(T)(Number)0.0);

        //对每个点，进行V() - 1 次松弛操作
        for (int i = 0 ; i < mGraph.V() - 1 ; i++){

            for (int j = 0 ; j < mGraph.V() ; j++){
                //遍历每个顶点的临边 进行松弛操作
                for (Edge<T> edge : mGraph.adj(j)){
                    // edge 这条边 v - w
                    //如果该点没有被访问(from[w] == null) 并且，到达 w的权值比从v 这边过来的更大
                    if (from[edge.getV()] != null && (from[edge.getW()] == null
                            || distTo[edge.getV()].doubleValue() + edge.getWeight().doubleValue() < distTo[edge.getW()].doubleValue())){
                        distTo[edge.getW()] = distTo[edge.getV()].doubleValue() + edge.getWeight().doubleValue();
                        from[edge.getW()] = edge;
                    }
                }
            }
        }
        negativeCycle = checkNegativeCycle();
    }

    /**
     * 是否有负权环
     * @return
     */
    public boolean hasNegativeCycle() {
        return negativeCycle;
    }

    /**
     * 到w点的最短路径长度
     * @param w
     * @return
     */
    public Number shortestPathTo(int w){
        if (hasNegativeCycle()){
            return null;
        }
        return distTo[w];
    }

    /**
     * 判断从source 到w点是否有最短路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        return from[w] != null;
    }

    /**
     * 从source到w的最短路径
     * @param w
     * @return
     */
    public List<Edge<T>> shortestPath(int w){
        List<Edge<T>> list = new ArrayList<>();
        if (hasNegativeCycle()){
            return list;
        }

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<T>> stack = new Stack<Edge<T>>();
        Edge<T> edge = from[w];
        // edge v - w
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

    /**
     * 检查是否有负权环
     * @return
     */
    private boolean checkNegativeCycle(){
        for (int j = 0 ; j < mGraph.V() ; j++){
            //遍历每个顶点的临边 进行松弛操作
            for (Edge<T> edge : mGraph.adj(j)){
                // edge 这条边 v - w
                //如果该点没有被访问(from[w] == null) 并且，到达 w的权值比从v 这边过来的更大
                if (from[edge.getV()] != null && (from[edge.getW()] == null
                        || distTo[edge.getV()].doubleValue() + edge.getWeight().doubleValue() < distTo[edge.getW()].doubleValue())){
                    return true;
                }
            }
        }
        return false;
    }

}
