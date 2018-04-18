package com.qiyei.graph;

import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/4/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class GraphTest {

    private static final int N = 100;

    private static String graphFile1 = "src/com/qiyei/graph/tinyG.txt";
    private static String graphFile2 = "src/com/qiyei/graph/mediumG.txt";
    private static String graphFile3 = "src/com/qiyei/graph/largeG.txt";

    private static String weightGraphFile2 = "src/com/qiyei/graph/mediumEWG.txt";

    private static Random random = new Random();


    public static void main(String[] args){

//        testGraph1();

        testWeightGraph();

    }





    private static void testGraph1(){
        DenseGraph denseGraph = new DenseGraph(N,false);
        SparseGraph sparseGraph = new SparseGraph(N,false);

        for (int i = 0 ;i < N ; i++){
            int v = random.nextInt(N);
            int w = random.nextInt(N);
            denseGraph.addEdge(v,w);
            sparseGraph.addEdge(v,w);

        }
        LogUtil.println("denseGraph ");
        for (int i = 0 ;i < N ; i++){
            LogUtil.println(i + " " + denseGraph.adj(i).toString());
        }
        LogUtil.println("\n sparseGraph ");
        for (int i = 0 ;i < N ; i++){
            LogUtil.println(i + " " + sparseGraph.adj(i).toString());
        }
        LogUtil.println("\n denseGraph1 ");
        DenseGraph denseGraph1 = (DenseGraph) GraphReadUtil.readGraph(graphFile2,false,false);
        if (denseGraph1 == null){
            return;
        }
        for (int i = 0 ; i < denseGraph1.V(); i++){
            LogUtil.println(i + " " + denseGraph1.adj(i).toString());
        }

        DepthFirstSerach depthFirstSerach1 = new DepthFirstSerach(denseGraph);
        LogUtil.println("\n denseGraph1 depthFirstSerach1 :\n" + depthFirstSerach1.dfs().toString());
        LogUtil.println("\n denseGraph1 count :\n" + depthFirstSerach1.count());
        LogUtil.println("\n denseGraph1 2 connect 7 :\n" + depthFirstSerach1.connect(2,7));

        Path graphPath1 = new Path(denseGraph1,0);
        if (graphPath1.hasPath(211)){
            graphPath1.showPath(211);
        }

        ShortPath shortPath1 = new ShortPath(denseGraph1,0);
        if (shortPath1.hasPath(211)){
            shortPath1.showPath(211);
        }

    }



    private static void testWeightGraph(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(sparseGraph);

        LogUtil.println("lazyPrimMST:");
        for (int i = 0 ; i < lazyPrimMST.getMstEdges().size(); i++){
            LogUtil.println(lazyPrimMST.getMstEdges().get(i).toString());
        }
        LogUtil.println("minWeight:" + lazyPrimMST.getMinWeight());

    }









    /**
     * 不使用第三者，交换两个数·
     */
    private static void testExch(){
        int m = 10,n = 20;

        m = m + n;

        // n = m
        n = m - n;

        m = m - n;

        System.out.print( " m = " + m + " n = " + n);
    }




}
