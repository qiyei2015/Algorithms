package com.backup.backup.thread;

import com.backup.backup.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class ReentrantLockDemo {

    /**
     * 非公平锁
     */
    private ReentrantLock lock1 = new ReentrantLock();

    /**
     * 公平锁
     */
    private ReentrantLock lock2 = new ReentrantLock(true);


    /**
     * 测试Lock
     */
    public void testLock(){
        for (int i = 0 ;i < 10;i++){
            startTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printLock(lock2);

                }
            }, "Thread " + i);
        }
    }

    /**
     * 测试Lock
     */
    public void testInterruptiblyLock(){
        List<Thread> list = new ArrayList<>();
        for (int i = 0 ;i < 10;i++){
            Thread thread = startTask(new Runnable() {
                @Override
                public void run() {
                    printInterruptiblyLock(lock2);
                }
            }, "Thread " + i);
            list.add(thread);
        }

        //调用线程中断
        list.get(7).interrupt();
    }

    /**
     * 测试tryLock
     */
    public void testTryLock(){
        for (int i = 0 ;i < 10;i++){
            startTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printTryLock1(lock1);

                }
            }, "Thread " + i);
        }
    }

    /**
     * 测试tryLock2
     */
    public void testTryLock2(){
        for (int i = 0 ;i < 10;i++){
            startTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printTryLock2(lock1);
                }
            }, "Thread " + i);
        }
    }

    /**
     * 返回线程
     * @param runnable
     * @param name
     * @return
     */
    private Thread startTask(Runnable runnable,String name){
        Thread thread = new Thread(runnable,name);
        thread.start();
        return thread;
    }


    /**
     * 测试tryLock
     */
    private void printTryLock1(ReentrantLock lock){
        //获取不到立即返回
        boolean flag = lock.tryLock();
        LogUtil.println("" + Thread.currentThread().getName() + " get lock " + flag);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag){
            lock.unlock();
            LogUtil.println("" + Thread.currentThread().getName() + " release lock");
        }
    }

    /**
     * 测试tryLock
     */
    private void printTryLock2(ReentrantLock lock){
        boolean flag = false;
        try {
            //等待2000ms后返回
            flag = lock.tryLock(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogUtil.println("" + Thread.currentThread().getName() + " get lock " + flag);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag){
            lock.unlock();
            LogUtil.println("" + Thread.currentThread().getName() + " release lock");
        }
    }

    private void printLock(ReentrantLock lock){
        //未获取锁会阻塞
        lock.lock();
        LogUtil.println("" + Thread.currentThread().getName() + " get lock now ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        LogUtil.println("" + Thread.currentThread().getName() + " release lock");
    }

    private void printInterruptiblyLock(ReentrantLock lock){
        //未获取锁会阻塞
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            LogUtil.println("" + Thread.currentThread().getName() + " has been interruptibly ");
            e.printStackTrace();
            return;
        }
        LogUtil.println("" + Thread.currentThread().getName() + " get lock now ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        LogUtil.println("" + Thread.currentThread().getName() + " release lock");
    }

    private void tryLock(ReentrantLock lock){
        lock.tryLock();
    }
}
