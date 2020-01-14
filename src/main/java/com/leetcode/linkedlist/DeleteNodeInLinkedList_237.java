package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/6/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInLinkedList_237 {

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
        node.val = node.next.val;

        //删除next结点
        ListNode del = node.next;
        node.next = node.next.next;

        del.next = null;
    }
}
