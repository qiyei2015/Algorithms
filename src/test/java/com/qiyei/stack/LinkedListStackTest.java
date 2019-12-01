package com.qiyei.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Created by qiyei2015 on 2019/12/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class LinkedListStackTest {

    LinkedListStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new LinkedListStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        System.out.println("Original " + stack);
    }

    @Test
    public void push() {
        stack.push(100);
        System.out.println(stack);
    }

    @Test
    public void pop() {
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void peek() {
        System.out.println(stack.peek());
        System.out.println(stack);
    }

    @Test
    public void size() {
        System.out.println(stack);
        Assert.assertEquals(stack.size(),6);
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(stack.isEmpty(),false);
    }
}