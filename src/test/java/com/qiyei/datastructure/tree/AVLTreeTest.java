package com.qiyei.datastructure.tree;

import com.qiyei.FileOperation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Created by qiyei2015 on 2019/12/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class AVLTreeTest {

    AVLTree<String,Integer> avlTree;


    @Before
    public void setUp() throws Exception {
        avlTree = new AVLTree<>();
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for (String word:words){
                if (avlTree.contains(word)){
                    avlTree.add(word,avlTree.get(word) + 1);
                } else {
                    avlTree.add(word,1);
                }
            }

        } else {
            System.out.println("read File error");
        }
    }

    @Test
    public void size() {
        System.out.println("size=" + avlTree.size());
    }

    @Test
    public void isEmpty() {
        System.out.println("isEmpty=" + avlTree.isEmpty());
    }

    @Test
    public void add() {

    }

    @Test
    public void contains() {
        System.out.println("contains,desire=" + avlTree.contains("desire"));
    }

    @Test
    public void get() {
        System.out.println("get,desire=" + avlTree.get("desire"));
    }

    @Test
    public void set() {
        System.out.println("get,desire=" + avlTree.get("desire"));
        avlTree.set("desire",45);
        System.out.println("get,desire=" + avlTree.get("desire"));
    }

    @Test
    public void preOrder() {

    }

    @Test
    public void preOrderNR() {

    }

    @Test
    public void inOrder() {

    }

    @Test
    public void postOrder() {

    }

    @Test
    public void levelOrder() {

    }

    @Test
    public void removeMin() {
        System.out.println("removeMin=" + avlTree.removeMin());
        System.out.println("removeMin=" + avlTree.removeMin());
    }

    @Test
    public void removeMax() {
        System.out.println("removeMax=" + avlTree.removeMax());
        System.out.println("removeMax=" + avlTree.removeMax());
    }

    @Test
    public void findMin() {

    }

    @Test
    public void findMax() {

    }

    @Test
    public void remove() {
        System.out.println("contains desire=" + avlTree.contains("desire"));
        avlTree.remove("desire");
        System.out.println("contains desire=" + avlTree.contains("desire"));
    }
}