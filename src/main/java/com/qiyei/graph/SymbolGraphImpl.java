package com.qiyei.graph;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by qiyei2015 on 2018/7/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SymbolGraphImpl implements ISymbolGraph{

    /**
     * 图
     */
    private IGraph mGraph;
    /**
     * 记录T对应的索引
     */
    private HashMap<String,Integer> indexRecord;
    /**
     * 索引数组
     */
    private String[] indexArray;

    public SymbolGraphImpl(String fileName,boolean direct) {
        indexRecord = new HashMap<>();
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));

            //进行record记录名字与索引关系
            while (scanner.hasNext()){
                String v = scanner.next();
                if (!indexRecord.containsKey(v)){
                    indexRecord.put(v,indexRecord.size());
                }
            }
            //创建数组
            indexArray = new String[indexRecord.size()];
            for (String name : indexRecord.keySet()){
                indexArray[indexRecord.get(name)] = name;
            }

            //顶点数
            int V = indexRecord.size();

            mGraph = new SparseGraph(V,direct);
            scanner = new Scanner(new BufferedInputStream(fileInputStream));
            while (scanner.hasNextLine()){
                String v = scanner.next();
                String w = scanner.next();
                mGraph.addEdge(indexRecord.get(v),indexRecord.get(w));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean contains(String key) {
        return indexRecord.containsKey(key);
    }

    @Override
    public int index(String key) {
        return indexRecord.get(key);
    }

    @Override
    public String name(int index) {
        return indexArray[index];
    }

    @Override
    public IGraph graph() {
        return mGraph;
    }
}
