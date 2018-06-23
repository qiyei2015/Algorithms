package com.qiyei.graph.th;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Created by qiyei2015 on 2018/4/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 从文件中读取图
 */
public class GraphReadUtil {


    /**
     * 从某个文件中读取有权图
     * @param file
     * @param direct
     * @return
     */
    public static IWeightGraph readWeightGraph(File file , boolean direct){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            //顶点数
            int V = scanner.nextInt();
            //边数
            int E = scanner.nextInt();
            IWeightGraph graph = null;
            graph = new TownWeightGraph(V,direct);
            while (scanner.hasNext()){
                String v = scanner.next();
                String w = scanner.next();
                int value = scanner.nextInt();
//                LogUtil.println("v:" + v + " w:" + w + " value:" + value);
                Edge edge = new Edge(new Town(v),new Town(w),value);
                graph.addEdge(edge);
            }
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
