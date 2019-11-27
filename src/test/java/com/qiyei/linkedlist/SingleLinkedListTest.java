package com.qiyei.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/11/27.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class SingleLinkedListTest {

    SingleLinkedList<Integer> singleLinkedList;

    @Before
    public void init(){
        singleLinkedList = new SingleLinkedList<>();
        for (int i = 0 ; i < 100; i++){
            singleLinkedList.addNode(i);
        }
    }

    @Test
    public void testShow(){
        singleLinkedList.show(singleLinkedList.getNodeList());
    }

    @Test
    public void testSize(){
        Assert.assertEquals(singleLinkedList.size(),100);
    }

    @Test
    public void testReverse(){
        Assert.assertEquals(singleLinkedList.reverse().data,new Integer(99));
    }

    @Test
    public void getTest(){
        Assert.assertEquals(singleLinkedList.get(0).data,new Integer(0));
        Assert.assertEquals(singleLinkedList.get(55).data,new Integer(55));
        Assert.assertEquals(singleLinkedList.get(89).data,new Integer(89));
    }

    @Test
    public void removeTest(){
        SingleLinkedList.Node node = singleLinkedList.get(5);
        Assert.assertEquals(singleLinkedList.remove(node).data,5);
        //Assert.assertEquals(singleLinkedList.remove(node).data,0);
//        Assert.assertEquals(singleLinkedList.get(55).data,new Integer(55));
//        Assert.assertEquals(singleLinkedList.get(89).data,new Integer(89));
    }
}
