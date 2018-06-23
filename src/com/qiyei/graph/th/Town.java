package com.qiyei.graph.th;

/**
 * @author Created by qiyei2015 on 2018/6/20.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Town extends Number implements Comparable<Town> ,ITown{

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
        this.key = getKeyFromName(name);
    }

    public Town(int key){
        this.key = key;
        this.name = getNameFromKey(key);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * town的key值，便于进行比较处理等
     * @return
     */
    @Override
    public int key(){
        return key;
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if( !(obj instanceof Town))
            return false;

        final Town town = (Town) obj;

        if( !getName().equals(town.getName()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * 根据名字获取值 A:0 B:1 C:2 D:3 E:4
     * @param name
     * @return
     */
    private int getKeyFromName(String name){
        if (name != null){
            char c = name.charAt(0);
            return c - 65;
        }
        return -1;
    }

    /**
     * key  -> name
     * @param key
     * @return
     */
    private String getNameFromKey(int key){
        char ch = (char) (65 + key);
        return String.valueOf(ch);
    }
}
