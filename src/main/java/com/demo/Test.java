package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/1/17.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Test {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param head
     */
    public static ListNode sort(ListNode head){

        if (head  == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead.next;

        ListNode p1 = head;

        int size = 1;
        //降序
        List<Integer> list1 = new ArrayList<>();

        //升序
        List<Integer> list2 = new ArrayList<>();

        //1 升序 2 降序
        //分别遍历奇数结点和偶数结点
        while (p1 != null){
            //
            if (size % 2 == 0){
                list2.add(p1.val);
            } else {
                list1.add(p1.val);
            }
            p1 = p1.next;
            size++;
        }

        //升序
        Collections.sort(list2);
        //降序
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int j = 0;
        int k = 0;
        for (int i = 1;i < size;i++){
            ListNode node = null;
            if (i % 2 == 0){
                node = new ListNode(list1.get(j));
                j++;
                p.next = node;
                p = p.next;
            } else {
                node = new ListNode(list2.get(k));
                p.next = node;
                p = p.next;
                k++;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        //f();
        //startNewMethod();

        String str1 = new StringBuilder("计算机").append("java").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    private static int f(){
        return f();
    }

    private static void startNewMethod(){
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }
    }
}
