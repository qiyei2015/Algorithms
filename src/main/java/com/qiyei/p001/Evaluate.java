package com.qiyei.p001;

import com.qiyei.stack.ResizingArrayStack;
import com.qiyei.stack.Stack;

/**
 * @author Created by qiyei2015 on 2018/3/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class Evaluate {

    public static final String TAG = "Evaluate";

    /**
     * 计算表达式值
     * 建立两个stack,分别将运算符 和 操作数压入栈中，在遇到 ")"时，弹出操作数和运算符，计算，并将结果压入栈中。
     * 最后从栈中弹出的结果就是表达式运算结果
     * @param expression
     * @return
     */
    public Double calculateExpression(String[] expression){
        Stack<Double> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        Double result = 0.0;
        for (String s : expression){

            //开始运算，并计算结果
            if (")".equals(s)){
                Double a2 = numStack.pop();
                Double a1 = numStack.pop();
                String sign = stringStack.pop();
                result = calculate(a1,a2,sign);
                //压入栈中
                numStack.push(result);
            }
            if (isNumber(s)){
                try {
                    numStack.push(Double.parseDouble(s));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }else if (isSign(s)){
                stringStack.push(s);
            }
        }

        return numStack.pop();
    }

    /**
     * 重载方法
     * @param expression
     * @param numStack
     * @param stringStack
     * @return
     */
    public Double calculateExpression(String[] expression, ResizingArrayStack<Double> numStack, ResizingArrayStack<String> stringStack){
        Double result = 0.0;
        for (String s : expression){
            //开始运算，并计算结果
            if (")".equals(s)){
                Double a2 = numStack.pop();
                Double a1 = numStack.pop();
                String sign = stringStack.pop();
                result = calculate(a1,a2,sign);
                //压入栈中
                numStack.push(result);
            }
            if (isNumber(s)){
                try {
                    numStack.push(Double.parseDouble(s));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }else if (isSign(s)){
                stringStack.push(s);
            }
        }

        return numStack.pop();
    }

    /**
     * 重载方法
     * @param expression
     * @param numStack
     * @param stringStack
     * @return
     */
    public Double calculateExpression3(String[] expression,Stack<Double> numStack,Stack<String> stringStack){
        Double result = 0.0;
        for (String s : expression){
            //开始运算，并计算结果
            if (")".equals(s)){
                Double a2 = numStack.pop();
                Double a1 = numStack.pop();
                String sign = stringStack.pop();
                result = calculate(a1,a2,sign);
                //压入栈中
                numStack.push(result);
            }
            if (isNumber(s)){
                try {
                    numStack.push(Double.parseDouble(s));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }else if (isSign(s)){
                stringStack.push(s);
            }
        }

        return numStack.pop();
    }


    /**
     * 判断是否是数字
     * @param s
     * @return
     */
    private boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是运算符号
     * @param s
     * @return
     */
    private boolean isSign(String s){
        if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
            return true;
        }
        return false;
    }

    private Double calculate(Double a1,Double a2,String sign){
        switch (sign){
            case "+":
                return a1 + a2;
            case "-":
                return a1 - a2;
            case "*":
                return a1 * a2;
            case "/":
                return a1 / a2;
            default:
                return null;
        }
    }

}
