package com.backup.backup.util;

/**
 * @author Created by qiyei2015 on 2018/3/16.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public StopWatch(int n) {
        start = System.nanoTime();
    }

    /**
     * 秒
     * @return
     */
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    /**
     * 毫秒
     * @return
     */
    public double elapsedTimeMilli(){
        long now = System.nanoTime();
        return (now - start) / 1000.0;
    }
}
