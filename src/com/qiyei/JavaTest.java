package com.qiyei;

import com.qiyei.java8.JavaNew;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Created by qiyei2015 on 2018/4/29.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class JavaTest {

    public static void main(String[] args){
//        testClassLoader();
        new JavaNew().testStream();


        final Son son = new Son();
        son.setName("hello");
        son.setName("hehh ");

    }


    private static void testClassLoader(){
        ClassLoader classLoader = JavaTest.class.getClassLoader();
        //是APPClassLoader
        System.out.println("Main.class ClassLoader:" + classLoader.toString());
        URL[] urls = ((URLClassLoader)classLoader).getURLs();
        printURL(urls);

        ClassLoader parent1 = classLoader.getParent();
        //是ExtClassLoader
        System.out.println("Main.class parent ClassLoader:" + parent1.toString());

        URL[] urls2 = ((URLClassLoader)parent1).getURLs();
        printURL(urls2);

        ClassLoader parent2 = parent1.getParent();
        if (parent2 != null){
            //是BootstrapLoader
            System.out.println("ExtClassLoader parent ClassLoader:" + parent2.toString());
        }



    }



    private static void printURL(URL[] urls){

    }
}
