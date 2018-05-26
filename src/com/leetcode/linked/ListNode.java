package com.leetcode.linked;

import com.qiyei.util.LogUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    /**
     * 创建随机链表
     * @param N
     * @param n
     * @return
     */
    public static ListNode creatRandomListNode(int N,int n){
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0 ;i < n;i++){
            array[i] = random.nextInt(N);
        }
        return creatListNode(array);
    }

    /**
     * 创建随机有序链表
     * @param N
     * @param n
     * @return
     */
    public static ListNode creatRandomSortListNode(int N,int n){
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0 ;i < n;i++){
            array[i] = random.nextInt(N);
        }
        Arrays.sort(array);
        return creatListNode(array);
    }

    /**
     * 创建链表
     * @param array
     * @return
     */
    public static ListNode creatListNode(int[] array){
        if (array.length == 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for (int i = 1; i < array.length ;i++){
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印结点
     * @param node
     */
    public static void show(ListNode node){
        ListNode p = node;
        StringBuilder builder = new StringBuilder();
        while (p != null){
            builder.append(p.val);
            if (p.next != null){
                builder.append(" -> ");
            }
            p = p.next;
        }
        LogUtil.println(builder.toString());
    }

}
