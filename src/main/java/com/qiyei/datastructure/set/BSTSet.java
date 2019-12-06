package com.qiyei.datastructure.set;

import com.qiyei.datastructure.tree.BST;

/**
 * @author Created by qiyei2015 on 2019/12/6.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
public class BSTSet<E extends Comparable<E>> implements ISet<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int size() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
