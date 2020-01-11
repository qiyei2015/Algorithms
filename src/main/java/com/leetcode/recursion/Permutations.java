package com.leetcode.recursion;

import com.backup.backup.util.LogUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2018/6/10.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 46. 全排列
 */
public class Permutations {

    private List<List<Integer>> list = new ArrayList<>();
    private boolean[] visit;

    /**
     * 递归和回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        list.clear();
        LogUtil.println("length:" + nums.length);
        if (nums.length == 0){
            return list;
        }
        visit = new boolean[nums.length];
        LinkedList<Integer> res = new LinkedList<>();
        findPermute(nums,0,res);
        return list;
    }

    /**
     * 在index + 1 中找到排列，并把结果存放到res中
     * @param nums
     * @param index
     * @param res 已经存放了 0 ...index个的排列
     */
    private void findPermute(int[] nums,int index,LinkedList<Integer> res){

        if (index == nums.length){
            //找到一个解，保存结果
            list.add((LinkedList<Integer>)res.clone());
            return;
        }

        //遍历数组，进行递归调用
        for (int i = 0 ;i < nums.length ;i++){
            //确保i没有被访问，如果i被访问了，说明该次递归已经包含了num[i]了
            if (!visit[i]){
                //本质上是一个队列
                visit[i] = true;
                res.addLast(nums[i]);
                //接着递归index + 1
                findPermute(nums,index + 1,res);

                //回溯过程
                visit[i] = false;
                res.removeLast();
            }
        }
    }


}
