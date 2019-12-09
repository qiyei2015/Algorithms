package com.qiyei.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/12/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SegmentTreeTest {

    SegmentTree<Integer> segmentTree;

    @Before
    public void setUp() throws Exception {
        Integer[] array = new Integer[]{5,7,2,4,0,1,6,23,78};
        segmentTree = new SegmentTree<>(array, (a,b) -> a + b);
    }

    @Test
    public void size() {
        Assert.assertEquals(segmentTree.size(),9);
    }

    @Test
    public void get() {
        Assert.assertEquals(segmentTree.get(3).intValue(),4);
    }

    @Test
    public void query() {
        System.out.println("result=" + segmentTree.query(0,3));
    }

    @Test
    public void set(){
        System.out.println("original:" + segmentTree);
        segmentTree.set(1,34);
        System.out.println(segmentTree);
    }


    @Test
    public void testToString() {
        System.out.println(segmentTree);
    }


}