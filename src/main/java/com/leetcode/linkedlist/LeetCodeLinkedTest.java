package com.leetcode.linkedlist;

/**
 * @author Created by qiyei2015 on 2018/5/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LeetCodeLinkedTest {

    public static void main(String[] args){

//        testReverseLinkedList();
//        testRemoveDuplicatesFromSortedList();
//        testRemoveLinkedListElement();
//        testSwapNodesInPairs();
        testFindLinkedMedianNode();
    }

    static void testReverseLinkedList(){
        ListNode list = ListNode.creatRandomListNode(100,10);
        ListNode.show(list);
        ListNode list2 = new ReverseLinkedList().reverseList2(list);
        ListNode.show(list2);
    }

    static void testRemoveDuplicatesFromSortedList(){
        ListNode list = ListNode.creatRandomSortListNode(10,20);
        ListNode.show(list);

        ListNode list2 = new RemoveDuplicatesFromList().deleteDuplicates(list);
        ListNode.show(list2);
    }

    static void testRemoveLinkedListElement(){
        ListNode list = ListNode.creatRandomListNode(10,20);
        ListNode.show(list);

        ListNode list2 = new RemoveLinkedListElement().removeElements2(list,1);
        ListNode.show(list2);
        ListNode list3 = new RemoveLinkedListElement().removeElements(list,2);
        ListNode.show(list3);
    }

    static void testSwapNodesInPairs(){
        ListNode list = ListNode.creatRandomListNode(10,10);
        ListNode.show(list);

        ListNode list2 = new SwapNodesInPairs().swapPairs(list);
        ListNode.show(list2);
    }

    private static void testFindLinkedMedianNode(){
        ListNode list = ListNode.creatRandomListNode(10,11);
        ListNode.show(list);

        ListNode list2 = new FindLinkedMedianNode().findMedianNode(list);
        ListNode.show(list2);
    }

}
