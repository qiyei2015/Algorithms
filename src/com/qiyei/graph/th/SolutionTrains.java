package com.qiyei.graph.th;


import com.qiyei.util.LogUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/6/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SolutionTrains<T extends Number & Comparable<T>,W extends Number & Comparable<W>>{

    /**
     * 图
     */
    private IWeightGraph<T,W> mGraph;
    /**
     * 遍历结果
     */
    private List<List<T>> res = new ArrayList<>();

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
    private Edge<T,W>[] from;


    public SolutionTrains(IWeightGraph mGraph) {
        this.mGraph = mGraph;
    }


    /**
     * 构造函数
     * @param graph
     * @param s
     */
    public SolutionTrains(IWeightGraph<T,W> graph, int s) {
        this.mGraph = graph;
        this.source = s;
        distTo = new Number[mGraph.V()];
        marked = new boolean[mGraph.V()];
        from = new Edge[mGraph.V()];

        //最小索引堆，辅助数据结构
        IndexMinHeap<W> indexMinHeap = new IndexMinHeap<>(mGraph.V());

        //Dijkstra 算法
        distTo[source] = 0;
        marked[source] = true;
        from[source] = new Edge<T,W>((T)new Town(source),(T)new Town(source),(W)(Number)0.0);
        indexMinHeap.insert(source,(W)distTo[source]);

        while (!indexMinHeap.isEmpty()){

            //取出权值最小的那条边的结点
            int v = indexMinHeap.extractIndexMin();
            marked[v] = true;

            //访问v的所有邻接边
            for (Edge<T,W> edge : mGraph.adj((T)new Town(v))){
                Town w = (Town) edge.other((T)new Town(v));
                //w点没有被标记过
                if (!marked[w.key()]){
                    //没有被访问过，并且通过v来访问，距离更短，则更新
                    if (from[w.key()] == null || distTo[v].doubleValue() + edge.getWeight().doubleValue() < distTo[w.key()].doubleValue()){
                        distTo[w.key()] = distTo[v].doubleValue() + edge.getWeight().doubleValue();
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
    public List<Edge<T,W>> shortestPath(int w){
        List<Edge<T,W>> list = new ArrayList<>();

        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        Stack<Edge<T,W>> stack = new Stack<Edge<T,W>>();
        Edge<T,W> edge = from[w];
        Town v = (Town) edge.getV();
        while(v.key() != source ){
            stack.push(edge);
            edge = from[((Town)edge.getV()).key()];
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
     * 获取从 start到end 最大为max stop的路径
     * @param start
     * @param end
     * @param max
     * @return
     */
    public List<List<T>> getTripsMaxStop(T start,T end,int max){
        res.clear();
        //异常处理
        if (!assetTown(start) || !assetTown(end)){
            return res;
        }
        LinkedList<T> path = new LinkedList<>();
        findTripsMaxStop(mGraph,path,start,end,max);
        return res;
    }

    /**
     * 查找从 index到end的最大为max stop的路径
     * @param graph
     * @param path
     * @param index
     * @param end
     * @param max
     */
    private void findTripsMaxStop(IWeightGraph<T,W> graph,LinkedList<T> path,T index,T end,int max){
        //递归结束条件 如果步骤超过max
        if (path.size() > max){
            return;
        }

        if (index.equals(end) && path.size() > 0 && path.size() <= max){
            //找到了
            path.add(index);
            res.add((LinkedList<T>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
            return;
        }

        //进行遍历
        //算法思路 index 的所有邻接边找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T,W> edge : graph.adj(index)){
            //邻边
            T w = edge.other(index);
            path.addLast(index);
            findTripsMaxStop(graph,path,w,end,max);
            //回溯
            path.removeLast();
        }
    }


    /**
     * 查找从 index到end的路径为n stop的路径
     * @param start
     * @param end
     * @param n
     * @return
     */
    public List<List<T>> getTripsExactlyStop(T start,T end,int n){
        res.clear();
        if (!assetTown(start) || !assetTown(end)){
            return res;
        }
        LinkedList<T> path = new LinkedList<>();
        findTripsExactly(mGraph,path,start,end,n);
        return res;
    }

    private void findTripsExactly(IWeightGraph<T,W> graph,LinkedList<T> path,T index,T end,int n){
        //递归结束条件 如果步骤超过max
        if (path.size() > n){
            return;
        }

        //找到了
        if (index.equals(end) && path.size() == n){
            //找到了
            path.add(index);
            res.add((LinkedList<T>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
            return;
        }

        //进行遍历
        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T,W> edge : graph.adj(index)){
            //邻边
            T w = edge.other(index);
            path.addLast(index);
            findTripsExactly(graph,path,w,end,n);
            //回溯
            path.removeLast();
        }
    }

    /**
     * 获取从 start 到end 不超过 maxWeight的路径
     * @param start
     * @param end
     * @param maxWeight
     * @return
     */
    public List<List<T>> getDifferentRoutes(T start,T end,W maxWeight){
        res.clear();
        LinkedList<T> path = new LinkedList<>();
        LinkedList<W> weight = new LinkedList<>();
        findDifferentRoutes(mGraph,path,weight,start,end,maxWeight);
        return res;
    }

    private void findDifferentRoutes(IWeightGraph<T,W> graph,LinkedList<T> path,LinkedList<W> weight,T index,T end,W maxWeight){
        //递归结束条件 如果超过maxWeight
        if (sumWeight(weight).doubleValue() >= maxWeight.doubleValue()){
            return;
        }

        if (index.equals(end) && path.size() > 0){
            //找到了
            path.add(index);
            res.add((LinkedList<T>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
        }

        //进行遍历
        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T,W> edge : graph.adj(index)){
            //邻边
            T w = edge.other(index);
            weight.addLast(edge.getWeight());
            path.addLast(index);
            findDifferentRoutes(graph,path,weight,w,end,maxWeight);
            weight.removeLast();
            //回溯
            path.removeLast();
        }
    }

    private Number sumWeight(LinkedList<W> weight){
        Number res = 0;
        for (W w : weight){
            res = res.doubleValue() + w.doubleValue();
        }
        return res;
    }

    /**
     * 检查 town
     * @param town
     * @return
     */
    private boolean assetTown(T town){
        if (mGraph == null){
            return false;
        }
        return mGraph.assertV(town);
    }

}
