package com.backup.backup.graph;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2018/7/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 无权图广度优先搜索
 */
public class BreadthFirstSearch {

    /**
     * 图
     */
    private IGraph mGraph;

    /**
     * marked[i]表示顶点i是否被标记
     */
    private boolean[] marked;
    /**
     * 标记i是从 from[i]遍历过来的
     */
    private int[] from;
    /**
     * 起点
     */
    private int source;

    /**
     * 广度优先搜索
     * @param mGraph
     * @param source
     */
    public BreadthFirstSearch(IGraph mGraph, int source) {
        this.mGraph = mGraph;
        this.source = source;

        marked = new boolean[mGraph.V()];
        from = new int[mGraph.V()];
        for (int i = 0 ;i < mGraph.V() ; i++){
            marked[i] = false;
            from[i] = -1;
        }
        bfs(mGraph,source);
    }

    /**
     * 广度优先搜索
     * @param graph
     * @param source
     */
    private void bfs(IGraph graph,int source){
        Queue<Integer> queue = new ArrayDeque<>();
        //加入起点
        queue.add(source);
        marked[source] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int w:graph.adj(v)){
                if (!marked[w]){
                    marked[w] = true;
                    //标记是从v过来的
                    from[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    /**
     * 源节点source 到目标节点是否有路径
     * @param w
     * @return
     */
    public boolean hasPath(int w){
        //查看w是否被访问了,如果被访问了就表示肯定有路径到达
        return marked[w];
    }

    /**
     * 到目标节点的path路径
     * @param w
     * @return
     */
    public List<Integer> path(int w){
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        //从w开始到推from数组,最开始的原点是-1,为循环结束条件
        int p = w;
        while (p != -1){
            //最先入栈的是w,接下来是from[w]这个节点
            stack.push(p);
            //from[p]找到上一个节点
            p = from[p];
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

}
