package com.qiyei.datastructure.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2020/1/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SegmentTreeMapTest {


    SegmentTreeMap<Integer> segmentTreeMap;
    Integer[] array;

    @Before
    public void setUp() throws Exception {
        array = new Integer[]{5,7,2,4,0,1,6,3,5,6,7,8,3,6,7,23,78};
        segmentTreeMap = new SegmentTreeMap<>(array,new SegmentTreeMap.Merger<Integer>(){
            @Override
            public Map<Integer, Integer> merge(Map<Integer, Integer> a, Map<Integer, Integer> b) {
                Map<Integer,Integer> res = new HashMap<>();

                for (Map.Entry<Integer,Integer> entry : a.entrySet()){
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    res.put(key,value);
                }

                for (Map.Entry<Integer,Integer> entry : b.entrySet()){
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    if (res.get(key) == null){
                        res.put(key,value);
                    } else {
                        Integer old = res.get(key);
                        res.put(key,old + value);
                    }
                }
                return res;
            }
        });
    }

    @Test
    public void size() {

    }

    @Test
    public void get() {

    }

    @Test
    public void query() {
        Map<Integer,Integer> res = segmentTreeMap.query(0,array.length -1);

        System.out.println("look 3=" + res.get(3));
        System.out.println("look 6=" + res.get(6));
        System.out.println("look 7=" + res.get(7));
    }

    @Test
    public void set() {


    }
}