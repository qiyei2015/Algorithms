package com.qiyei.graph;

import com.qiyei.graph.th.SolutionTrains;
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
    private static String weightGraphFile3 = "src/com/qiyei/graph/testG2.txt";

    private static String directGraph = "src/com/qiyei/graph/tinyDirectGraph.txt";

    private static Random random = new Random();


    public static void main(String[] args){

//        testGraph1();
//        testWeightGraph();

//        testLazyPrimMST();
//        LogUtil.println("\n\n");
//        testPrimMST();
//        LogUtil.println("\n\n");
//        testKruskalMST();
//        LogUtil.println("\n\n");
//        testDijikstra();
//        LogUtil.println("\n\n");
//        testBellmanFord();

        testDijikstra222222();
    }

    /**
     * 测试图
     */
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

    /**
     * 测试有权图
     */
    private static void testWeightGraph(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);

        LogUtil.println("WeightGraph:");
        LogUtil.println("V():" + sparseGraph.V());
        LogUtil.println("E():" + sparseGraph.E());
        for (int i = 0 ; i < sparseGraph.V(); i++){
            for (Edge<Double> edge : sparseGraph.adj(i)){
                LogUtil.println("V:" + i + " v-w:" + edge.getV() + "-" + edge.getW() + " " + edge.getWeight());
            }
        }

    }


    /**
     * 测试LazyPrim算法
     */
    private static void testLazyPrimMST(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<>(sparseGraph);

        LogUtil.println("lazyPrimMST:");
        for (int i = 0 ; i < lazyPrimMST.getMstEdges().size(); i++){
            LogUtil.println(lazyPrimMST.getMstEdges().get(i).toString());
        }
        LogUtil.println("minWeight:" + lazyPrimMST.getMinWeight());

    }

    /**
     * 测试Prim算法
     */
    private static void testPrimMST(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);
        PrimMST<Double> primMST = new PrimMST<>(sparseGraph);

        LogUtil.println("PrimMST:");
        for (int i = 0 ; i < primMST.getMstEdges().size(); i++){
            LogUtil.println(primMST.getMstEdges().get(i).toString());
        }
        LogUtil.println("minWeight:" + primMST.getMinWeight());

    }

    /**
     * 测试Kruskal算法
     */
    private static void testKruskalMST(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);
        KruskalMST<Double> kruskalMST = new KruskalMST<>(sparseGraph);

        LogUtil.println("KruskalMST:");
        for (int i = 0 ; i < kruskalMST.getMstEdges().size(); i++){
            LogUtil.println(kruskalMST.getMstEdges().get(i).toString());
        }
        LogUtil.println("minWeight:" + kruskalMST.getMinWeight());

    }


    /**
     * 测试Dijkstra算法
     */
    private static void testDijikstra(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile2,false,true);
        Dijkstra<Double> dijkstra = new Dijkstra<>(sparseGraph,0);

        int w = 10;

        LogUtil.println("Dijkstra:");
        LogUtil.println("Dijkstra hasPath("  + w +"):"+ dijkstra.hasPath(w));
        LogUtil.println("Dijkstra shortestPathTo("  + w +"):"+ dijkstra.shortestPathTo(w));
        dijkstra.showShortestPath(w);

    }

    /**
     * 测试Dijkstra算法
     */
    private static void testDijikstra222222(){
        IWeightGraph<Integer> sparseGraph = (IWeightGraph<Integer>) GraphReadUtil.readWeightGraph(directGraph,true,true);

        //A:0 B:1 C:2 D:3 E:4

        int[] a1 = new int[]{0,1,2};
        int[] a2 = new int[]{0,3};
        int[] a3 = new int[]{0,3,2};
        int[] a4 = new int[]{0,4,1,2,3};
        int[] a5 = new int[]{0,4,3};

//        LogUtil.println("a1:" + sparseGraph.getWeigthFor(a1));
//        LogUtil.println("a2:" + sparseGraph.getWeigthFor(a2));
//        LogUtil.println("a3:" + sparseGraph.getWeigthFor(a3));
//        LogUtil.println("a4:" + sparseGraph.getWeigthFor(a4));
//        LogUtil.println("a5:" + sparseGraph.getWeigthFor(a5));


        SolutionTrains<Integer> solutionTrains = new SolutionTrains<>(sparseGraph);
//        LogUtil.println("res:" + solutionTrains.getTripsMax(2,2,3).toString());
//        LogUtil.println("res 2 :" + solutionTrains.getTripsMax(0,1,5).toString());
//        LogUtil.println("res exactly :" + solutionTrains.getTripsExactly(0,2,4).toString());

        LogUtil.println("res number :" + solutionTrains.getTrips(2,2,30).toString());


    }

    private static void print(Dijkstra<?> dijkstra,int w){
        LogUtil.println("Dijkstra:");
        LogUtil.println("Dijkstra hasPath("  + w +"):"+ dijkstra.hasPath(w));
        LogUtil.println("Dijkstra shortestPathTo("  + w +"):"+ dijkstra.shortestPathTo(w));
        dijkstra.showShortestPath(w);
        LogUtil.println("\n");
    }


    /**
     * 测试BellmanFord算法
     */
    private static void testBellmanFord(){
        IWeightGraph<Double> sparseGraph = (IWeightGraph<Double>) GraphReadUtil.readWeightGraph(weightGraphFile3,true,true);
        BellmanFord<Double> bellmanFord = new BellmanFord<>(sparseGraph,0);

        int w = 3;

        LogUtil.println("BellmanFord:");
        LogUtil.println("BellmanFord hasPath("  + w +"):"+ bellmanFord.hasPath(w));
        LogUtil.println("BellmanFord shortestPathTo("  + w +"):"+ bellmanFord.shortestPathTo(w));
        bellmanFord.showShortestPath(w);

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
