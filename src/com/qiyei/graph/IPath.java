package com.qiyei.graph;

import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/7/1.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 深度优先搜索算法
 */
public interface IPath {

    /**
     * 到w是否有路径
     * @param w
     * @return
     */
    boolean hasPath(int w);

    /**
     * 到目标结点的路径
     * @param w
     * @return
     */
    List<Integer> path(int w);

    /**
     * 打印到w的路径
     * @param w
     */
    void showPath(int w);

}
