package com.qiyei.datastructure.array;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/11/29.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */

public class ArrayTest {

    Array<Integer> array;


    @Before
    public void setUp() throws Exception {
        array = new Array<>(10);
        for (int i = 0 ;i < 8;i++){
            array.addLast(i);
        }
    }

    @Test
    public void addFirst() {
        array.addFirst(85);
        Assert.assertEquals(array.getFirst().intValue(),85);
    }

    @Test
    public void addLast() {
        array.addLast(88);
        Assert.assertEquals(array.getLast().intValue(),88);
    }

    @Test
    public void add() {

    }

    @Test
    public void removeFirst() {
        Assert.assertEquals(array.removeFirst().intValue(),0);
        Assert.assertEquals(array.removeFirst().intValue(),1);

    }

    @Test
    public void removeLast() {
        Assert.assertEquals(array.removeLast().intValue(),7);
        Assert.assertEquals(array.removeLast().intValue(),6);
    }

    @Test
    public void remove() {

    }

    @Test
    public void getFirst() {
    }

    @Test
    public void getLast() {
        Assert.assertEquals(array.getLast().intValue(),7);
    }

    @Test
    public void get() {

    }

    @Test
    public void set() {
        array.set(2,100);
        Assert.assertEquals(array.get(2).intValue(),100);
    }


    @Test
    public void isEmpty() {
        Assert.assertEquals(array.isEmpty(),false);
    }

    @Test
    public void size() {
        Assert.assertEquals(array.size(),8);
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(array.getCapacity(),10);

        array.addLast(56);
        array.addLast(52);
        array.addLast(86);
        System.out.println(array.toString());

        array.removeFirst();
        System.out.println(array.toString());
        array.removeFirst();
        array.removeFirst();
        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array.toString());
    }

    @Test
    public void testToString() {
        System.out.println(array.toString());
    }
}
