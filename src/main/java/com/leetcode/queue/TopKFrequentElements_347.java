package com.leetcode.queue;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2018/6/2.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 347. 前K个高频元素 23 题很有意思
 */
public class TopKFrequentElements_347 {

    static class Node{
        //频率
        int freq;
        //元素
        int key;

        public Node(int freq, int key) {
            this.freq = freq;
            this.key = key;
        }
    }

    /**
     * 使用优先队列的思想
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        if (k <= 0 && k > nums.length){
            return list;
        }
        //按照频率建堆
        Comparator<? super Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.freq - o2.freq;
            }
        };

        //建立一个最小堆
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k,comparator);

        //1 统计数组中个元素出现的频率 key是树，value出现的频率
        HashMap<Integer,Integer> record = new HashMap<>();
        for (int i = 0 ;i < nums.length ;i++){
            Integer value = record.getOrDefault(nums[i],0);
            value++;
            record.put(nums[i],value);
        }

        //遍历map
        for (Map.Entry<Integer,Integer> entry : record.entrySet()){

            //频率 key
            Node node = new Node(entry.getValue(),entry.getKey());

            //存储满了k个大小，再来一个就需要与堆顶元素比较，如果小于堆顶不做处理，大于堆顶，删除堆顶，然后把新元素添加进去
            if (priorityQueue.size() == k){
                if (node.freq > priorityQueue.peek().freq){
                    priorityQueue.poll();
                    priorityQueue.add(node);
                }
            }else {
                priorityQueue.add(node);
            }
        }

        //遍历堆
        while (!priorityQueue.isEmpty()){
            list.add(priorityQueue.poll().key);
        }
//        //排序
//        Collections.sort(list);
        return list;
    }

}
