package com.qiyei.graph;

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
     * 5 9
     0 1 5 //AB 5
     1 2 4 //DB 4
     2 3 8 //CD 8
     3 2 8 //DC 8
     3 4 6 //DE 6
     0 3 5 //AD 5
     2 4 2 //CE 2
     4 1 3 // EB 3
     0 4 7 //AE 7
     */


    /**
     * 从某个文件中读取图
     * @param path
     * @param direct
     * @param sparse
     * @return
     */
    public static IGraph readGraph(String path, boolean direct,boolean sparse){
        File file = new File(path);
        return readGraph(file,direct,sparse);
    }

    /**
     * 从某个文件中读取图
     * @param file
     * @param direct
     * @param sparse
     * @return
     */
    public static IGraph readGraph(File file , boolean direct,boolean sparse){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            //顶点数
            int V = scanner.nextInt();
            //边数
            int E = scanner.nextInt();
            IGraph graph = null;
            if (sparse){
                graph = new SparseGraph(V,direct);
            }else {
                graph = new DenseGraph(V,direct);
            }
            while (scanner.hasNext()){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graph.addEdge(v,w);
            }
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从某个文件中读取有权图
     * @param path
     * @param direct
     * @param sparse 是否是稀疏图
     * @return
     */
    public static IWeightGraph readWeightGraph(String path,boolean direct,boolean sparse){
        File file = new File(path);
        return readWeightGraph(file,direct,sparse);
    }

    /**
     * 从某个文件中读取有权图
     * @param file
     * @param direct
     * @param sparse 是否是稀疏图
     * @return
     */
    public static IWeightGraph readWeightGraph(File file , boolean direct,boolean sparse){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            //顶点数
            int V = scanner.nextInt();
            //边数
            int E = scanner.nextInt();
            IWeightGraph graph = null;
            if (sparse){
                graph = new SparseWeightGraph(V,direct);
            }else {
                graph = new DenseWeightGraph(V,direct);
            }
            while (scanner.hasNext()){
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                double value = scanner.nextDouble();
                Edge edge = new Edge(v,w,value);
                graph.addEdge(edge);
            }
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
