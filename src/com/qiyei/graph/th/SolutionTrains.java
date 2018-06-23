package com.qiyei.graph.th;

import com.qiyei.graph.Edge;
import com.qiyei.graph.IWeightGraph;
import com.qiyei.util.LogUtil;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2018/6/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SolutionTrains<T extends Number & Comparable<T>> {

    /**
     * 图
     */
    private IWeightGraph<T> mGraph;

    List<List<Integer>> res = new ArrayList<>();

    int number = 0;


    public SolutionTrains(IWeightGraph<T> mGraph) {
        this.mGraph = mGraph;
    }

    /**
     *
     * @param start
     * @param end
     * @param max
     * @return
     */
    public List<List<Integer>> getTripsMax(int start,int end,int max){
        res.clear();
        LinkedList<Integer> path = new LinkedList<>();
        findTripsMax(mGraph,path,start,start,end,max);
        return res;
    }

    private void findTripsMax(IWeightGraph<T> graph,LinkedList<Integer> path,int start,int index,int end,int max){
        //递归结束条件 如果步骤超过max
        if (path.size() > max){
            return;
        }

        //找到了
        if (index == end && path.size() > 0 && path.size() <= max){
            //找到了
            path.add(index);
            res.add((LinkedList<Integer>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
            return;
        }

        //进行遍历
        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T> edge : graph.adj(index)){
            //邻边
            int w = edge.other(index);
            path.addLast(index);
            findTripsMax(graph,path,start,w,end,max);
            //回溯
            path.removeLast();
        }

    }

    public List<List<Integer>> getTripsExactly(int start,int end,int max){
        res.clear();
        LinkedList<Integer> path = new LinkedList<>();
        findTripsExactly(mGraph,path,start,start,end,max);
        return res;
    }

    private void findTripsExactly(IWeightGraph<T> graph,LinkedList<Integer> path,int start,int index,int end,int max){
        //递归结束条件 如果步骤超过max
        if (path.size() > max){
            return;
        }

        //找到了
        if (index == end && path.size() == max){
            //找到了
            path.add(index);
            res.add((LinkedList<Integer>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
            return;
        }

        //进行遍历
        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T> edge : graph.adj(index)){
            //邻边
            int w = edge.other(index);
            path.addLast(index);
            findTripsExactly(graph,path,start,w,end,max);
            //回溯
            path.removeLast();
        }

    }


    public List<List<Integer>> getTrips(int start,int end,int maxWeight){
        res.clear();
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> weight = new LinkedList<>();
        findTrips(mGraph,path,weight,start,end,maxWeight);
        LogUtil.println("number:" + number);
        return res;
    }

    private void findTrips(IWeightGraph<T> graph,LinkedList<Integer> path,LinkedList<Integer> weight,int index,int end,int maxWeight){

        //递归结束条件 如果步骤超过max
        if (calWeight(weight) >= maxWeight){
            return;
        }

        //找到了
        if (index == end && path.size() > 0){
            //找到了
            path.add(index);
            res.add((LinkedList<Integer>)path.clone());
            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
            path.removeLast();
            number++;
//            return;
        }

        //进行遍历
        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
        for (Edge<T> edge : graph.adj(index)){
            //邻边
            int w = edge.other(index);
            weight.addLast(edge.getWeight().intValue());
            path.addLast(index);
            findTrips(graph,path,weight,w,end,maxWeight);
            weight.removeLast();
//            LogUtil.println("return back:" + weight + " path:" + path.toString());
            //回溯
            path.removeLast();
        }
    }

    private Integer calWeight(LinkedList<Integer> weight){
        int res = 0;
        for (Integer integer : weight){
            res += integer;
        }
        return res;
    }
}
