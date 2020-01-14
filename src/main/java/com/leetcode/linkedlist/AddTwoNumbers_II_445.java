package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 445
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers_II_445 {

    /**
     * 1 先反转链表，利用2的算法
     * 2 自己实现
     * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     *
     *  
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 进阶:
     *
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * 示例:
     *
     * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出: 7 -> 8 -> 0 -> 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummyHead = new ListNode(0);
        //用于存放第一次的进位
        ListNode prevHead = new ListNode(0);
        dummyHead.next = prevHead;

        ListNode p = prevHead;
        ListNode prev = prevHead;

        int value = 0;

        while (p1 != null && p2 != null){

        }

        return null;
    }

}
