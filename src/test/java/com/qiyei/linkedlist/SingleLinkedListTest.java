package com.qiyei.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SingleLinkedListTest {


    SingleLinkedList<Integer> list;
    SingleLinkedList<Integer> list2;

    @Before
    public void setUp() throws Exception {
        list = new SingleLinkedList<>();
        for (int i = 0 ; i < 5; i++){
            list.addFirst(i);
        }
        System.out.println("Original " + list);
        list2 = new SingleLinkedList<Integer>(new Integer[]{4,2,3,4,4,6,7,8,9});
    }

    @Test
    public void addFirst() {
        list.addFirst(100);

        System.out.println(list);
    }

    @Test
    public void addLast() {
        list.addLast(101);
        System.out.println(list);
    }

    @Test
    public void add() {
        list.add(2,88);
        System.out.println(list);
    }

    @Test
    public void removeFirst() {
        list.removeFirst();
        System.out.println(list);
    }

    @Test
    public void removeLast() {
        list.removeLast();
        System.out.println(list);
    }

    @Test
    public void remove() {
        list.remove(3);
        System.out.println(list);
    }

    @Test
    public void set() {
        list.set(1,56);
        System.out.println(list);
    }

    @Test
    public void contains() {
        Assert.assertEquals(list.contains(52),false);
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(list.getFirst().intValue(),4);
    }

    @Test
    public void getLast() {
        Assert.assertEquals(list.getLast().intValue(),0);
    }

    @Test
    public void get() {
        Assert.assertEquals(list.get(2).intValue(),2);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(list.isEmpty(),false);
    }

    @Test
    public void size() {
        Assert.assertEquals(list.size(),5);
    }

    @Test
    public void reverse() {
        //System.out.println(list.reverse());
    }

    @Test
    public void reverse2() {
        //System.out.println(list.reverse2());
    }

    @Test
    public void testToString() {
        System.out.println(list2);
    }

    @Test
    public void removeElement() {
        System.out.println("list2:" + list2);
        list2.removeElement(4);
        System.out.println("result:" + list2);
    }
}