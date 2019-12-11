package com.qiyei.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2019/12/9.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 前缀树，字典树,主要用于处理字符串等
 */
public class Trie {

    private class Node{
        boolean isWord;
        /**
         * 下个结点的引用
         */
        Map<Character,Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
    }

    /**
     * 字典树的根节点
     */
    private Node root;
    /**
     * 单词个数
     */
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 返回单词个数
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加一个单词
     * @param word
     */
    public void add(String word){
        if (checkParamsInvalid(word)) return;
        //addNR(word);
        add(root,word,0);
    }

    /**
     * 非递归添加单词
     * @param word
     */
    private void addNR(String word) {
        Node cur = root;
        for (int i = 0 ; i < word.length();i++){
            char c = word.charAt(i);

            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            //更新cur
            cur = cur.next.get(c);
        }
        //已经到单词的最后了
        if (!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 在以node为根的结点中添加单词中索引为index处的字符
     * @param node 根节点
     * @param word 单词
     * @param index 单词索引
     */
    private void add(Node node,String word,int index){
        //单词末尾,递归结束
        if (index == word.length() - 1){
            char c = word.charAt(index);
            if (node.next.get(c) == null){
                node.next.put(c,new Node());
            }
            //是否是一个单词
            if (!node.next.get(c).isWord){
                node.next.get(c).isWord = true;
                size++;
            }
            return;
        }

        //记录这个单词
        char c = word.charAt(index);
        if (node.next.get(c) == null){
            node.next.put(c,new Node());
        }

        add(node.next.get(c),word,index + 1);
    }

    /**
     * 判断树中是否存在该元素
     * @param word
     * @return
     */
    public boolean contains(String word){
        if (checkParamsInvalid(word)){
            return false;
        }

        Node cur = root;
        for (int i = 0; i < word.length() ;i++){
            char c = word.charAt(i);
            //不存在，没找到
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        //到末尾了
        return cur.isWord;
    }

    /**
     * 查询树中是否包含prefix前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        if (checkParamsInvalid(prefix)){
            return false;
        }

        Node cur = root;
        for (int i = 0; i < prefix.length() ;i++){
            char c = prefix.charAt(i);
            //不存在，没找到
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        //到末尾了
        return true;
    }

    private boolean checkParamsInvalid(String word) {
        if (word == null || word.trim().equals("")) {
            return true;
        }
        return false;
    }
}
