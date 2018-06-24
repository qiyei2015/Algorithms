package com.qiyei.graph.th;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Created by qiyei2015 on 2018/6/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 单源最短路径算法
 */
public class Dijkstra {

    /**
     * 图
     */
    private IWeightGraph<Town,Integer> mGraph;
    /**
     * 最短路径的起始点 源
     */
    private int source;
    /**
     * 最短路径上权值 distTo[i]存储从起始点s到i的最短路径长度
     */
    private Integer[] distTo;
    /**
     * 标记顶点i是否被访问
     */
    private boolean[] marked;
    /**
     * from[i]记录最短路径中, 到达i点的边是哪一条,可以用来恢复整个最短路径
     */
    private Edge<Town,Integer>[] from;

    /**
     * 构造函数
     * @param graph
     * @param s
     */
    public Dijkstra(IWeightGraph graph, int s) {
        this.mGraph = graph;
        this.source = s;
        distTo = new Integer[mGraph.V()];
        marked = new boolean[mGraph.V()];
        from = new Edge[mGraph.V()];

        //最小索引堆，辅助数据结构
        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(mGraph.V());

        //Dijkstra 算法
        distTo[source] = 0;
        marked[source] = true;
        from[source] = new Edge<Town,Integer>(new Town(source),new Town(source),0);
        indexMinHeap.insert(source,distTo[source]);

        while (!indexMinHeap.isEmpty()){

            //取出权值最小的那条边的结点
            int v = indexMinHeap.extractIndexMin();
            marked[v] = true;

            //访问v的所有邻接边
            for (Edge<Town,Integer> edge : mGraph.adj(new Town(v))){
                Town w = edge.other(new Town(v));
                //w点没有被标记过
                if (!marked[w.key()]){
                    //没有被访问过，并且通过v来访问，距离更短，则更新
                    if (from[w.key()] == null || distTo[v] + edge.getWeight() < distTo[w.key()]){
                        distTo[w.key()] = distTo[v] + edge.getWeight();
                        from[w.key()] = edge;
                        if (indexMinHeap.contains(w.key())){
                            indexMinHeap.replace(w.key(),edge.getWeight());
                        }else {
                            indexMinHeap.insert(w.key(),edge.getWeight());
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
    public Integer shortestPathTo(int w){
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
    public List<Edge<Town,Integer>> shortestPath(int w){
        List<Edge<Town,Integer>> list = new ArrayList<>();

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<Town,Integer>> stack = new Stack<Edge<Town,Integer>>();
        Edge<Town,Integer> edge = from[w];
        Town v = edge.getV();
        while(v.key() != source ){
            stack.push(edge);
            edge = from[edge.getV().key()];
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
     * 同源最短路径
     * @param graph
     * @param source
     * @return
     */
    public static int getshortestPathAsSame(IWeightGraph<Town,Integer> graph,int source){

        TreeMap<Integer,Town> record = new TreeMap<>();

        //找到 w 到 v的最短路径
        for (Edge<Town,Integer> edge : graph.adj(new Town(source))){
            Town w = edge.other(new Town(source));

            Dijkstra solution = new Dijkstra(graph,w.key());
            if (solution.shortestPathTo(source) != null){
                Integer weight = solution.shortestPathTo(source) + edge.getWeight();
                record.put(weight,w);
            }
        }

        //取最小值
        Town town = record.get(record.firstKey());
        Dijkstra realSolution = new Dijkstra(graph,town.key());
        return realSolution.shortestPathTo(source) + graph.getWeight(new Town(source),town);
    }

}
