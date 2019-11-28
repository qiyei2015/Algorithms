package com.qiyei.linkedlist;

import com.qiyei.util.LogUtil;
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

    SingleLinkedList<Integer> listFirst;
    SingleLinkedList<Integer> listLast;

    @Before
    public void init(){
        listFirst = new SingleLinkedList<>();
        for (int i = 0 ; i < 100; i++){
            listFirst.addFirst(i);
        }

        listLast = new SingleLinkedList<>();
        for (int i = 0 ; i < 100; i++){
            listLast.addLast(i);
        }
    }

    @Test
    public void testShow(){
        LogUtil.println(listFirst.toString());
        LogUtil.println(listLast.toString());
    }

    @Test
    public void testSize(){
        Assert.assertEquals(listFirst.size(),100);
        Assert.assertEquals(listLast.size(),100);
    }

    @Test
    public void testReverse(){
        Assert.assertEquals(listFirst.reverse().data,new Integer(99));
    }

    @Test
    public void getTest(){
        Assert.assertEquals(listFirst.get(0).data,new Integer(0));
        Assert.assertEquals(listFirst.get(55).data,new Integer(55));
        Assert.assertEquals(listFirst.get(89).data,new Integer(89));
    }

    @Test
    public void removeTest(){
        SingleLinkedList.Node node = listFirst.get(5);
        Assert.assertEquals(listFirst.remove(node).data,5);
    }
}
