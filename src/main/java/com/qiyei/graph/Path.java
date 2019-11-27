package com.qiyei.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by qiyei2015 on 2018/4/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 寻找路径
 */
public class Path implements IPath{

    /**
     * 图
     */
    private IGraph mGraph;
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
    private int[] from;

    public Path(IGraph graph, int s) {
        this.mGraph = graph;
        this.source = s;
        marked = new boolean[mGraph.V()];
        from = new int[mGraph.V()];
        for (int i = 0 ;i < mGraph.V() ; i++){
            marked[i] = false;
            from[i] = -1;
        }
        //进行深度优先遍历
        dfs(source);
    }

    /**
     * 源节点source 到目标节点是否有路径
     * @param w
     * @return
     */
    @Override
    public boolean hasPath(int w){
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
     * @param i
     */
    private void dfs(int i) {
        marked[i] = true;
        //遍历i的邻接点，依次进行深度优先遍历
        for (int j : mGraph.adj(i)){
            if (!marked[j]){
                //表示j这个节点是从i遍历过来的
                from[j] = i;
                dfs(j);
            }
        }
    }

}
