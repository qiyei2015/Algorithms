package com.qiyei.backup.graph.weight;

import com.qiyei.backup.graph.IPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/7/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 有权图DFS算法
 */
public class PathWeight<T extends Number & Comparable<T>> implements IPath {

    /**
     * 图
     */
    private IWeightGraph<T> mGraph;
    /**
     * 源节点
     */
    private int source;
    /**
     * marked[i]表示顶点i是否被标记
     */
    private boolean[] marked;

    /**
     * from[i] 表示源节点到目标节点经过的节点
     */
    private Edge<T>[] from;

    /**
     * 构造方法
     * @param graph
     * @param source
     */
    public PathWeight(IWeightGraph<T> graph,int source){
        mGraph = graph;
        this.source = source;
        marked = new boolean[mGraph.V()];
        from = new Edge[mGraph.V()];
        for (int i = 0 ;i < mGraph.V() ; i++){
            marked[i] = false;
            from[i] = null;
        }
        from[source] = new Edge<T>(-1,source,(T)((Number)(0)));
        dfs(source);
    }

    /**
     * 源节点source 到目标节点是否有路径
     * @param w
     * @return
     */
    @Override
    public boolean hasPath(int w){
        if (w >= mGraph.V()){
            return false;
        }
        //查看w是否被访问了,如果被访问了就表示肯定有路径到达
        return marked[w];
    }

    /**
     * 到目标节点的path路径
     * @param w
     * @return
     */
    @Override
    public List<Integer> path(int w){
        List<Integer> list = new ArrayList<>();

        if (w >= mGraph.V()){
            return list;
        }

        Stack<Integer> stack = new Stack<>();

        //从w开始到推from数组,最开始的原点是-1,为循环结束条件
        int p = w;
        while (p != -1){
            //最先入栈的是w,接下来是from[w]这个节点
            stack.push(p);
            //from[p]找到上一个节点
            Edge<T> edge = from[p];
            p = edge.other(p);
        }

        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 打印到目标节点的路径
     * @param w
     */
    @Override
    public void showPath(int w){
        List<Integer> list = path(w);
        for (int i = 0 ; i < list.size() ; i++){
            System.out.print(list.get(i));
            if (i != list.size() - 1){
                System.out.print(" -> ");
            }
        }
        System.out.println("");
    }

    /**
     * 深度优先搜索
     * @param v
     */
    private void dfs(int v){
        //标记v被访问
        marked[v] = true;
        //遍历邻边进行访问
        for (Edge<T> edge: mGraph.adj(v)){
            int w = edge.other(v);
            //没有被访问
            if (!marked[w]){
                //标记w是从edge这条边过来的
                from[w] = edge;
                dfs(w);
            }
        }
    }

}
