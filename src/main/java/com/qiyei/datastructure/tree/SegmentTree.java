package com.qiyei.datastructure.tree;

/**
 * @author Created by qiyei2015 on 2019/12/8.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 线段树
 */
public class SegmentTree<E> {

    /**
     * 融合操作定义
     * 对于不同的业务场景，融合操作定义不一样，例如求和，求最大值，最小值
     * @param <E>
     */
    public interface Merger<E>{
        /**
         * 两个元素的融合操作
         * @param a
         * @param b
         * @return
         */
        E merge(E a,E b);
    }

    /**
     * 线段树元素存储区
     */
    private E[] data;
    /**
     * 线段树
     */
    private E[] tree;
    /**
     * 融合器
     */
    private Merger<E> merger;

    public SegmentTree(E[] array,Merger<E> merger) {
        this.data = (E[]) new Object[array.length];
        System.arraycopy(array,0,data,0,array.length);
        tree = (E[]) new Object[4 * array.length];

        this.merger = merger;
        buildSegmentTree(0,0,data.length - 1);
    }

    /**
     * 在index处创建[l...r]的线段树
     * @param treeIndex
     * @param l 左边界
     * @param r 右边界
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {

        //数据边界检查
        if (treeIndex < 0 || treeIndex >= tree.length){
            return;
        }

        if (l < 0 || l >= data.length){
            return;
        }

        if (r < 0 || r >= data.length){
            return;
        }

        //无法再分割了，已经到了最小区间
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftChildIndex = indexLeftChild(treeIndex);
        int rightChildIndex = indexRightChild(treeIndex);
        int mid = l + ( r - l ) / 2;
        //创建左子树和右子树的线段树
        buildSegmentTree(leftChildIndex,l,mid);
        buildSegmentTree(rightChildIndex,mid + 1,r);
        //根节点是两个子节点的融合值
        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    /**
     * 返回线段树的长度
     * @return
     */
    public int size(){
        return data.length;
    }

    /**
     *
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("IllegalArgument index");
        }
        return data[index];
    }

    /**
     * 查询线段树[l..r]的结果
     * @param l
     * @param r
     * @return
     */
    public E query(int l,int r){
        if (l < 0 || l >= data.length || r < 0 || r >= data.length){
            throw new IllegalArgumentException("illegalArgument for l r");
        }
        return query(0,0,data.length - 1,l,r);
    }

    /**
     * 在treeIndex的线段树中查询[l..r]区间结果
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex,int l,int r,int queryL,int queryR){

        //查询到结果了
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int leftChildIndex = indexLeftChild(treeIndex);
        int rightChildIndex = indexRightChild(treeIndex);
        int mid = l + ( r - l ) / 2;
        //全部在左子树
        if (queryR <= mid){
            return query(leftChildIndex,l,mid,queryL,queryR);
        } else if (queryL > mid + 1){
            //全在右子树
            return query(rightChildIndex,mid + 1,r,queryL,queryR);
        }

        //左右子树都有
        E leftResult = query(leftChildIndex,l,mid,queryL,mid);
        E rightResult = query(rightChildIndex,mid + 1,r,mid + 1,queryR);
        return merger.merge(leftResult,rightResult);
    }

    /**
     * 修改线段树索引为index处的值
     * @param index
     * @param e
     */
    public void set(int index,E e){
        set(0,0,size() - 1,index,e);
    }

    /**
     * 修改treeIndex为根节点的线段树的值
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex,int l,int r,int index,E e){

        if (l == r){
            tree[treeIndex] = e;
            return;
        }

        int leftChildIndex = indexLeftChild(treeIndex);
        int rightChildIndex = indexRightChild(treeIndex);

        int mid = l + ( r - l ) / 2;
        if (index <= mid){
            set(leftChildIndex,l,mid,index,e);
        } else {
            set(rightChildIndex,mid + 1,r,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    /**
     * 返回二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int indexLeftChild(int index){
        return 2 * index + 1;
    }

    /**
     * 返回二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int indexRightChild(int index){
        return 2 * index + 2;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SegmentTree[");

        for (int i = 0 ; i < tree.length ;i++){
            if (tree[i] != null){
                builder.append(tree[i]);
            } else {
                builder.append("NULL");
            }

            if (i != tree.length - 1){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
