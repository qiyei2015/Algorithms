package com.qiyei.backup.graph.weight;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by qiyei2015 on 2018/7/7.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SymbolWeightGraphImpl<T extends Number & Comparable<T>> implements ISymbolWeightGraph<T> {

    /**
     * 图
     */
    private IWeightGraph<T> mGraph;
    /**
     * 记录对应的索引
     */
    private HashMap<String,Integer> indexRecord;
    /**
     * 索引数组,保存图中顶点与字符名的关系
     */
    private String[] indexArray;

    public SymbolWeightGraphImpl(String fileName,boolean direct) {
        indexRecord = new HashMap<>();
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream));

            //进行record记录名字与索引关系
            while (scanner.hasNext()){
                String v = scanner.next();
                String w = scanner.next();
                if (!indexRecord.containsKey(v)){
                    indexRecord.put(v,indexRecord.size());
                }
                if (!indexRecord.containsKey(w)){
                    indexRecord.put(w,indexRecord.size());
                }
                double value = scanner.nextDouble();
            }
            //创建数组
            indexArray = new String[indexRecord.size()];
            for (String name : indexRecord.keySet()){
                indexArray[indexRecord.get(name)] = name;
            }

            //顶点数
            int V = indexRecord.size();
            mGraph = new SparseWeightGraph<>(V,direct);

            fileInputStream = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fileInputStream));
            while (scanner.hasNext()){
                String v = scanner.next();
                String w = scanner.next();
                double value = scanner.nextDouble();
                Edge edge = new Edge(indexRecord.get(v),indexRecord.get(w),value);
                mGraph.addEdge(edge);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return indexRecord.size();
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
    public IWeightGraph<T> graph() {
        return mGraph;
    }

    @Override
    public int[] toIndex(String[] str) {
        int[] indexs = new int[str.length];
        for (int i = 0 ;i < str.length ;i++){
            indexs[i] = indexRecord.get(str[i]);
        }
        return indexs;
    }

    @Override
    public String[] toSymbol(int[] array) {
        String[] symbols = new String[array.length];
        for (int i = 0 ;i < array.length ;i++){
            symbols[i] = indexArray[array[i]];
        }
        return symbols;
    }


}
