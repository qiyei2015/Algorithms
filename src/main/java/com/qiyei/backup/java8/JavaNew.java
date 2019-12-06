package com.qiyei.backup.java8;

import com.qiyei.backup.util.LogUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Created by qiyei2015 on 2018/6/9.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class JavaNew {


    public void testLambda(){

        //lambda表达式
        Comparator<String> comparator = (num1,num2) -> Integer.compare(num1.length(),num2.length());

        OnClickListener listener = (o) -> {String s = "hello";};

    }

    interface OnClickListener{
        void click(Object o);
    }

    public void testStream(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ;i < 10;i++){
            list.add(10 + i);
        }
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};

        Stream<Integer> stream1 = list.stream();
        Stream<Integer> stream2 = Stream.of(array);

        Stream<Integer> stream3 = stream1.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer.intValue() < 12){
                    return true;
                }
                return false;
            }
        });

        stream3.forEach((val) -> LogUtil.println(val+""));

        List<List<Integer>> listList = new ArrayList<>();
        listList.add(list);
        listList.add(Arrays.asList(array));

        Stream<List<Integer>> listStream = listList.stream();
        listStream.flatMap(new Function<List<Integer>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<Integer> integers) {
                return integers.stream();
            }
        });
    }

}
