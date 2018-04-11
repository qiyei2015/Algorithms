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
public class GraphRead {

    /**
     * 从某个文件中读取图
     * @param path
     * @param direct
     * @return
     */
    public static DenseGraph denseGraphRead(String path,boolean direct){
        File file = new File(path);
        return denseGraphRead(file,direct);
    }

    /**
     * 从某个文件中读取图
     * @param file
     * @param direct
     * @return
     */
    public static DenseGraph denseGraphRead(File file , boolean direct){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            //顶点数
            int V = scanner.nextInt();
            //边数
            int E = scanner.nextInt();
            DenseGraph graph = new DenseGraph(V,direct);
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
     * 从某个文件中读取图
     * @param path
     * @param direct
     * @return
     */
    public static SparseGraph sparseGraphRead(String path,boolean direct){
        File file = new File(path);
        return sparseGraphRead(file,direct);
    }


    /**
     * 从某个文件中读取图
     * @param file
     * @param direct
     * @return
     */
    public static SparseGraph sparseGraphRead(File file,boolean direct){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));
            //顶点数
            int V = scanner.nextInt();
            //边数
            int E = scanner.nextInt();
            SparseGraph graph = new SparseGraph(V,direct);
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


}
