package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 82 删除排序链表中的元素 重复元素全部删除
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortList_II_82 {


    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead.next;
        ListNode prev = dummyHead;

        while (p != null && p.next != null){
            //1
            if (p.val != p.next.val){
                prev = p;
                p = p.next;
            } else {
                //相等，需要删除 p及p.next

                //2 更新p到最后一个等于前面值的结点
                while (p != null && p.next != null && p.val == p.next.val){
                    p = p.next;
                }

                //3
                if (p == null){
                    prev.next = null;
                } else {
                    //4 删除p
                    prev.next = p.next;
                    ListNode del = p;

                    p = p.next;
                    del.next = null;
                }
            }
        }

        ListNode retNode = dummyHead.next;
        dummyHead.next = null;
        return retNode;
    }

}
