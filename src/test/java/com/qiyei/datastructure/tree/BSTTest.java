package com.qiyei.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Created by qiyei2015 on 2019/12/4.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class BSTTest {

    BST<Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST<>();
        int[] array = new int[]{5,6,4,2,9,6,7,0,3};
        for (int i = 0 ;i < array.length;i++){
            bst.add(array[i]);
        }
    }

    @Test
    public void size() {
        Assert.assertEquals(bst.size(),10);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(bst.isEmpty(),false);
    }

    @Test
    public void add() {
        bst.add(85);
        Assert.assertEquals(bst.size(),11);
    }

    @Test
    public void preOrder() {
        System.out.println(bst.preOrder());
    }

    @Test
    public void preOrderNR() {
        System.out.println(bst.preOrder());
        System.out.println(bst.preOrderNR());
    }

    @Test
    public void inOrder() {
        System.out.println(bst.inOrder());
    }

    @Test
    public void postOrder() {
        System.out.println(bst.postOrder());
    }

    @Test
    public void levelOrder(){
        System.out.println(bst.levelOrder());
        System.out.println(bst.preOrder());
    }

    @Test
    public void mininum(){
        System.out.println(bst.levelOrder());
        System.out.println(bst.mininum());
    }

    @Test
    public void maxnum(){
        System.out.println(bst.levelOrder());
        System.out.println(bst.maxnum());
    }


    @Test
    public void removeMin() {
        System.out.println(bst.inOrder());
        bst.removeMin();
        System.out.println(bst.inOrder());

    }

    @Test
    public void removeMax() {
        System.out.println(bst.inOrder());
        bst.removeMax();
        System.out.println(bst.inOrder());
    }


    @Test
    public void remove() {
        System.out.println("size=" + bst.size() + " "+ bst.inOrder());
        bst.remove(3);
        System.out.println("size=" + bst.size() + " "+ bst.inOrder());
        bst.remove(7);
        System.out.println("size=" + bst.size() + " "+ bst.inOrder());
    }
}