package com.qiyei.graph.th;

/**
 * @author Created by qiyei2015 on 2018/6/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Town extends Number implements Comparable<Town>{
    private String name;
    private int value;

    public Town(String name) {
        this.name = name;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int compareTo(Town o) {
        if (value < o.value){
            return -1;
        }else if (value == o.value){
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
