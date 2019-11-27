package com.leetcode.linked;

/**
 * @author Created by qiyei2015 on 2018/6/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 237. 删除链表中的节点
 */
public class DeleteNodeInLinkedList {

    /**
     * 删除给定的结点
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        //最后一个结点
        if (node.next == null){
            node = null;
            return;
        }

        //找到node的下一个结点，将其值赋值给node，删除下一个结点
        ListNode next = node.next;
        node.val = next.val;

        //删除next结点
        node.next = next.next;
        next = null;
    }
}
