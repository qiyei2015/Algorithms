package com.qiyei.graph.th;


import com.qiyei.util.LogUtil;

import java.io.File;

/**
 * @author Created by qiyei2015 on 2018/6/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Client {

    private static String directGraph = "src/com/qiyei/graph/th/tinyDirectGraph.txt";

    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";



    public static void main(String[] args){
        testTrains();
    }

    private static void testTrains(){
        IWeightGraph<Town,Integer> townGraph = (TownWeightGraph) GraphReadUtil.readWeightGraph(new File(directGraph),true);

        //A:0 B:1 C:2 D:3 E:4
        Town[] input1 = new Town[]{new Town(A),new Town(B),new Town(C)};
        Town[] input2 = new Town[]{new Town(A),new Town(D)};
        Town[] input3 = new Town[]{new Town(A),new Town(D),new Town(C)};
        Town[] input4 = new Town[]{new Town(A),new Town(E),new Town(B),new Town(C),new Town(D)};
        Town[] input5 = new Town[]{new Town(A),new Town(E),new Town(D)};


        LogUtil.println("Output #1:" + formatResult(townGraph.getWeightForPath(input1)));
        LogUtil.println("Output #2:" + formatResult(townGraph.getWeightForPath(input2)));
        LogUtil.println("Output #3:" + formatResult(townGraph.getWeightForPath(input3)));
        LogUtil.println("Output #4:" + formatResult(townGraph.getWeightForPath(input4)));
        LogUtil.println("Output #5:" + formatResult(townGraph.getWeightForPath(input5)));

        SolutionTrains<Town,Integer> solutionTrains = new SolutionTrains<>(townGraph);

        Dijkstra dijkstra = new Dijkstra(townGraph,new Town(A).key());

        LogUtil.println("Output #6:" + solutionTrains.getTripsMaxStop(new Town(C),new Town(C),3).size());
        LogUtil.println("Output #7:" + solutionTrains.getTripsExactlyStop(new Town(A),new Town(C),4).size());
        LogUtil.println("Output #8:" + dijkstra.shortestPathTo(new Town(C).key()));
        LogUtil.println("Output #9:" + Dijkstra.getshortestPathAsSame(townGraph,new Town(B).key()));
        LogUtil.println("Output #10:" + solutionTrains.getDifferentRoutes(new Town(C),new Town(C),30).size());

    }


    private static String formatResult(Integer res){
        return res != null ? res + "" : NO_SUCH_ROUTE;
    }

}
