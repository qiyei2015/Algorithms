package com.qiyei.graph.th;

/**
 * @author Created by qiyei2015 on 2018/6/23.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 小镇的抽象
 */
public interface ITown {

    String getName();

    /**
     * town的key值，便于进行比较处理等
     * @return
     */
    int key();

}
