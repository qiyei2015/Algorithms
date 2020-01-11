//package com.qiyei.old.graph.solution;
//
//
//import com.qiyei.thoughtworks.graph.Edge;
//import com.qiyei.thoughtworks.graph.IWeightGraph;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author Created by qiyei2015 on 2018/6/23.
// * @version: 1.0
// * @email: 1273482124@qq.com
// * @description:
// */
//public class SolutionTrains<T extends Number & Comparable<T>,W extends Number & Comparable<W>>{
//
//    /**
//     * 图
//     */
//    private IWeightGraph<T,W> mGraph;
//    /**
//     * 遍历结果
//     */
//    private List<List<T>> res = new ArrayList<>();
//
//    public SolutionTrains(IWeightGraph mGraph) {
//        this.mGraph = mGraph;
//    }
//
//    /**
//     * 获取从 start到end 最大为max stop的路径
//     * @param start
//     * @param end
//     * @param max
//     * @return
//     */
//    public List<List<T>> getTripsMaxStop(T start,T end,int max){
//        res.clear();
//        //异常处理
//        if (!assetTown(start) || !assetTown(end)){
//            return res;
//        }
//        LinkedList<T> path = new LinkedList<>();
//        findTripsMaxStop(path,start,end,max);
//        return res;
//    }
//
//    /**
//     * 查找从 index到end的最大为max stop的路径 dfs
//     * @param path
//     * @param index
//     * @param end
//     * @param max
//     */
//    private void findTripsMaxStop(LinkedList<T> path,T index,T end,int max){
//        //递归结束条件 如果步骤超过max
//        if (path.size() > max){
//            return;
//        }
//
//        if (index.equals(end) && path.size() > 0 && path.size() <= max){
//            //找到了
//            path.add(index);
//            res.add((LinkedList<T>)path.clone());
//            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
//            path.removeLast();
//            return;
//        }
//
//        //进行遍历
//        //算法思路 index 的所有邻接边找，依次递归下去，如果下一个结点就是end，就找到了
//        for (Edge<T,W> edge : mGraph.adj(index)){
//            //邻边
//            T w = edge.other(index);
//            path.addLast(index);
//            findTripsMaxStop(path,w,end,max);
//            //回溯
//            path.removeLast();
//        }
//    }
//
//
//    /**
//     * 查找从 index到end的路径为n stop的路径
//     * @param start
//     * @param end
//     * @param n
//     * @return
//     */
//    public List<List<T>> getTripsExactlyStop(T start,T end,int n){
//        res.clear();
//        if (!assetTown(start) || !assetTown(end)){
//            return res;
//        }
//        LinkedList<T> path = new LinkedList<>();
//        findTripsExactly(mGraph,path,start,end,n);
//        return res;
//    }
//
//    private void findTripsExactly(IWeightGraph<T,W> graph,LinkedList<T> path,T index,T end,int n){
//        //递归结束条件 如果步骤超过max
//        if (path.size() > n){
//            return;
//        }
//
//        //找到了
//        if (index.equals(end) && path.size() == n){
//            //找到了
//            path.add(index);
//            res.add((LinkedList<T>)path.clone());
//            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
//            path.removeLast();
//            return;
//        }
//
//        //进行遍历
//        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
//        for (Edge<T,W> edge : graph.adj(index)){
//            //邻边
//            T w = edge.other(index);
//            path.addLast(index);
//            findTripsExactly(graph,path,w,end,n);
//            //回溯
//            path.removeLast();
//        }
//    }
//
//    /**
//     * 获取从 start 到end 不超过 maxWeight的路径
//     * @param start
//     * @param end
//     * @param maxWeight
//     * @return
//     */
//    public List<List<T>> getDifferentRoutes(T start,T end,W maxWeight){
//        res.clear();
//        LinkedList<T> path = new LinkedList<>();
//        LinkedList<W> weight = new LinkedList<>();
//        findDifferentRoutes(mGraph,path,weight,start,end,maxWeight);
//        return res;
//    }
//
//    private void findDifferentRoutes(IWeightGraph<T,W> graph,LinkedList<T> path,LinkedList<W> weight,T index,T end,W maxWeight){
//        //递归结束条件 如果超过maxWeight
//        if (sumWeight(weight).doubleValue() >= maxWeight.doubleValue()){
//            return;
//        }
//
//        if (index.equals(end) && path.size() > 0){
//            //找到了
//            path.add(index);
//            res.add((LinkedList<T>)path.clone());
//            //需要再次移除，因为多添加了一个，要不然回溯的过程就会移除刚添加的元素
//            path.removeLast();
//        }
//
//        //进行遍历
//        //算法 思路 index 的所有邻接边 找，依次递归下去，如果下一个结点就是end，就找到了
//        for (Edge<T,W> edge : graph.adj(index)){
//            //邻边
//            T w = edge.other(index);
//            weight.addLast(edge.getWeight());
//            path.addLast(index);
//            findDifferentRoutes(graph,path,weight,w,end,maxWeight);
//            weight.removeLast();
//            //回溯
//            path.removeLast();
//        }
//    }
//
//    private Number sumWeight(LinkedList<W> weight){
//        Number res = 0;
//        for (W w : weight){
//            res = res.doubleValue() + w.doubleValue();
//        }
//        return res;
//    }
//
//    /**
//     * 检查 town
//     * @param town
//     * @return
//     */
//    private boolean assetTown(T town){
//        if (mGraph == null){
//            return false;
//        }
//        return mGraph.assertV(town);
//    }
//
//    private List<T> bastPath = new ArrayList<>();
//    private Number bastCost = Integer.MAX_VALUE;
//
//    /**
//     * 获取最短路径
//     * @param start
//     * @param end
//     * @return
//     */
//    public List<T> getShortest(T start,T end){
//        bastPath.clear();
//        bastCost = (Number)Integer.MAX_VALUE;
//
//        LinkedList<T> path = new LinkedList<>();
//        path.addLast(start);
//        LinkedList<W> costList = new LinkedList<>();
//        costList.addLast((W)(Number)0.0);
//
//        dfs(path,end,costList);
//
//        return bastPath;
//    }
//
//    /**
//     * 深度优先搜索
//     * @param path 已经搜索过的路径
//     * @param end 结束点
//     * @param costList 总权重
//     */
//    private void dfs(LinkedList<T> path,T end, LinkedList<W> costList){
//
//        //找到了
//        if (path.getLast().equals(end) && sumWeight(costList).doubleValue() > 0 ){
//            //找寻最短路径 更新最小的的
//            if (sumWeight(costList).doubleValue() < bastCost.doubleValue()){
//                bastPath = ((LinkedList<T>)path.clone());
//                bastCost = sumWeight(costList).doubleValue();
//            }
//            return;
//        }
//
//        //取最后一个元素
//        T t = path.getLast();
//        for (Edge<T,W> edge : mGraph.adj(t)){
//            T w = edge.other(t);
//
//            if (path.indexOf(w) > 0){
//                continue;
//            }
//            costList.addLast(edge.getWeight());
//            path.addLast(w);
//            dfs(path,end,costList);
//            costList.removeLast();
//            //回溯需要删除
//            path.removeLast();
//        }
//
//    }
//
//    public Number getBastCost() {
//        return bastCost;
//    }
//}
