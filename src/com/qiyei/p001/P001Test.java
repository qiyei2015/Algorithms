package com.qiyei.p001;

import com.qiyei.queue.Queue;
import com.qiyei.stack.ResizingArrayStack;
import com.qiyei.stack.Stack;
import com.qiyei.util.LogUtil;

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
        LogUtil.println(Queue.TAG,"queue foreach");
        for (String s : stringQueue1){
            LogUtil.print(s + " ");
        }

    }


}
