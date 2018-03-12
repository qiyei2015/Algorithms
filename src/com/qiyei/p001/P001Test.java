package com.qiyei.p001;

import com.qiyei.queue.Queue;
import com.qiyei.stack.ResizingArrayStack;
import com.qiyei.stack.Stack;
import com.qiyei.util.LogUtil;

import java.util.Random;

/**
 * @author Created by qiyei2015 on 2018/3/3.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class P001Test {

    private static final String TAG = "P001Test";

    public static void main(String[] args){

        //7.3333333
        String express = "( ( ( 2 * 5 ) + ( 4 / 3 ) ) - ( 1 + 3 ) )";
        String[] array = express.split(" ");

        LogUtil.println(Evaluate.TAG,"" + new Evaluate().calculateExpression(array));


        ResizingArrayStack<String> stringStack1 = new ResizingArrayStack<>();
        ResizingArrayStack<Double> numStack1 = new ResizingArrayStack<>();
        LogUtil.println(ResizingArrayStack.TAG,"" + new Evaluate().calculateExpression(array,numStack1,stringStack1));


        Stack<String> stringStack2 = new Stack<>();
        Stack<Double> numStack2 = new Stack<>();
        LogUtil.println(Stack.TAG,"" + new Evaluate().calculateExpression3(array,numStack2,stringStack2));

        Queue<String> stringQueue1 = new Queue<>();

        for (String s : array){
            stringQueue1.enqueue(s);
        }

        //stringQueue1.removeLast();
        LogUtil.println(Queue.TAG,"queue foreach");
        for (String s : stringQueue1){
            LogUtil.print(s + " ");
        }


        LogUtil.print("\n");

        for (String s : array){
            stringStack1.push(s);
        }

        LogUtil.println(Stack.TAG,"stack foreach");
        for (String s : stringStack1){
            LogUtil.print(s + " ");
        }
        LogUtil.print("\n");
        LogUtil.println(Stack.TAG,"" + tableSizeFor(0));

        LogUtil.println(Stack.TAG,"" + tableSizeFor(1));

        LogUtil.println(Stack.TAG,"" + tableSizeFor(3));

        LogUtil.println(Stack.TAG,"" + tableSizeFor(1029));


        Random random = new Random(127);
        int[] a = new int[100];
        for (int i = 0;i< a.length ;i++){
            a[i] = random.nextInt();
        }
        int[] b = new int[]{1,-2,3,-5,6,8,-1,-7,-8,-3,4,10,-12,-15,5,11};
        LogUtil.println("TwoSum","" + TwoSum.count2(b));
        LogUtil.println("ThreeSum","" + ThreeSum.count2(b));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        LogUtil.println(Stack.TAG,"1 " + n);
        n |= n >>> 2;
        LogUtil.println(Stack.TAG,"2 " + n);
        n |= n >>> 4;
        LogUtil.println(Stack.TAG,"3 " + n);
        n |= n >>> 8;
        LogUtil.println(Stack.TAG,"4 " + n);
        n |= n >>> 16;
        LogUtil.println(Stack.TAG,"5 " + n);
        return (n < 0) ? 1 :  n + 1;
    }
}
