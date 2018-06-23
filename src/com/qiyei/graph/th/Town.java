package com.qiyei.graph.th;

/**
 * @author Created by qiyei2015 on 2018/6/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Town extends Number implements Comparable<Town>{

    /**
     * 名字
     */
    private String name;

    /**
     * 用于记录的key值
     */
    private int key;

    public Town(String name) {
        this.name = name;
        this.key = getValueFromName(name);
    }

    @Override
    public int intValue() {
        return key;
    }

    @Override
    public long longValue() {
        return key;
    }

    @Override
    public float floatValue() {
        return key;
    }

    @Override
    public double doubleValue() {
        return key;
    }

    @Override
    public int compareTo(Town o) {
        if (o == null){
            throw new NullPointerException("compareTo object is null!");
        }
        if (key < o.key){
            return -1;
        }else if (key == o.key){
            return 0;
        }else {
            return 1;
        }
    }

    /**
     * 根据名字获取值 A:0 B:1 C:2 D:3 E:4
     * @param name
     * @return
     */
    private int getValueFromName(String name){
        if (name != null){
            char c = name.charAt(0);
            return c - 65;
        }
        return -1;
    }
}
