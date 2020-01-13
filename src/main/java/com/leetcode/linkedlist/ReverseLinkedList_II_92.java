package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList_II_92 {


    /**
     * 反转指定区间链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > n){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        //记录上一段链表的末尾
        ListNode prevLast = null;
        //记录当前段链表的末尾
        ListNode curLast = null;

        int k = 1;

        //找到新节点
        while (cur != null && k <= n){
            next = cur.next;
            //找到连接前的结点，反转后的未结点，并且把prev置null
            if (k == m){
                prevLast = prev;
                prev = null;
                curLast = cur;
            }

            //从n开始反转，并且n结束
            if (k >= m){
                cur.next = prev;
            }
            prev = cur;
            cur = next;

            k++;
        }

        //反转之后，prev是反转后的新结点，cur是下一段链表的头结点,curLast是该段链表的未结点
        //将preLast --> prev ,curLast--> cur
        curLast.next = cur;

        if (prevLast != null){
            prevLast.next = prev;
            return head;
        } else {
            return prev;
        }
    }

}
