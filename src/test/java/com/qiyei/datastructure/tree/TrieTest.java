package com.qiyei.datastructure.tree;

import com.qiyei.FileOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Created by qiyei2015 on 2019/12/11.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class TrieTest {

    Trie trie;

    @Before
    public void setUp() throws Exception {
        trie = new Trie();

    }

    @Test
    public void size() {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for(String word: words){
                trie.add(word);
            }
        }
        System.out.println("size=" + trie.size());
    }

    @Test
    public void isEmpty() {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for(String word: words){
                trie.add(word);
            }
        }
        Assert.assertEquals(trie.isEmpty(),false);
    }

    @Test
    public void add() {
        ArrayList<String> words = new ArrayList<>();
        Trie trie2 = new Trie();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for(String word: words){
                trie.add(word);
                trie2.add(word);
            }
        }
        Assert.assertEquals(trie2.size(),trie.size());
    }

    @Test
    public void contains() {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for(String word: words){
                trie.add(word);
            }
        }
        System.out.println("contains invitation = " + trie.contains("invitation"));
    }


    @Test
    public void isPrefix() {
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)){
            for(String word: words){
                trie.add(word);
            }
        }
        System.out.println("isPrefix cons = " + trie.isPrefix("cons"));
    }
}