package com.qiyei.thread;

/**
 * @author Created by qiyei2015 on 2018/4/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ThreadTest {


    public static void main(String[] args){

        DoubleLock lock = new DoubleLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 100; i++){
                    lock.print5();
                }
            }
        }).start();

//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0 ; i < 100; i++){
            lock.print6();
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0 ; i < 100; i++){
//                    lock.print3();
//                }
//            }
//        }).start();
//
//        for (int i = 0 ; i < 100; i++){
//            lock.print4();
//        }
    }

}
