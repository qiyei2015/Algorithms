package com.qiyei.thread;

import com.qiyei.util.LogUtil;

/**
 * @author Created by qiyei2015 on 2018/4/28.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class DoubleLock {

    int i = 0 ;

    Object lock = new Object();


    public synchronized void print(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                LogUtil.println("DoubleLock print()" + i++);
            }
        }
    }

    public synchronized void print2(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (DoubleLock.class){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                LogUtil.println("DoubleLock print2()" + i++);
            }
        }
    }
    
    public synchronized void print3(){
        LogUtil.println("DoubleLock print3() need lock");
        try {
            Thread.sleep(20);
            synchronized (lock){
                LogUtil.println("DoubleLock print3()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print4(){
        synchronized (lock){
            LogUtil.println("DoubleLock print4() need this");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this){
                LogUtil.println("DoubleLock print4()");
            }
        }
    }

    public void print5(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.println("DoubleLock print5()" + i++);
    }

    public void print6(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.println("DoubleLock print6()" + i++);
    }

}
