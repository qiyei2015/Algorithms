package com.qiyei.datastructure.tree;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2019/12/13.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: AVL树 平衡二叉树
 */
public class AVLTree<K extends Comparable<K>,V> {

    /**
     * 结点定义
     * @param <K>
     * @param <V>
     */
    private static class Node<K,V>{
        K key;
        V value;
        int height;
        Node<K,V> left;
        Node<K,V> right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            height = 1;
        }

    }

    /**
     * 根节点
     */
    private Node<K,V> root;
    /**
     * 结点个数
     */
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加结点
     * @param key
     */
    public void add(K key,V value){
        root = add(root,key,value);
    }

    /**
     * 在以node为根结点的二叉树中添加结点，并返回添加后的根节点
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node<K,V> add(Node<K,V> node, K key, V value){
        if (node == null){
            size++;
            return new Node<>(key,value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        } else {
            node.value = value;
        }

        //更新height
        node.height = Math.max(getHeight(node.left),getHeight(node.right));

        //获取平衡因子
        int balance = getBalanceFactor(node);
        //进行平衡处理
        if (balance > 1 && getBalanceFactor(node.left) >= 0){
            //添加的结点在左子树的左侧 LL 右旋
            node = rightRotate(node);
        }else if (balance > 1 && getBalanceFactor(node.left) < 0){
            //添加的结点在左子树的右侧 LR 先左旋左子树再右旋
            node.left = leftRotate(node.left);
            node = rightRotate(node);

        }else if (balance < -1 && getBalanceFactor(node.right) > 0){
            //添加的结点在右子树的左侧 RL 先右旋右子树再左旋
            node.right = rightRotate(node.right);
            node = leftRotate(node);
        } else if (balance < -1 && getBalanceFactor(node.right) <= 0){
            //添加的结点在右子树的右侧 RR 左旋
            node = leftRotate(node);
        }
        return node;
    }

    /**
     * 查找元素
     * @param key
     * @return
     */
    public boolean contains(K key){
        if (key == null){
            return false;
        }
        return getNode(root,key) != null;
    }

    
    /**
     * 根据k获取对应的结点值
     * @param key
     * @return
     */
    public V get(K key){
        Node<K,V> node = getNode(root,key);
        return node == null ? null : node.value;
    }

    /**
     * 在以node为根结点的树中查找key的结点
     * @param node
     * @param key
     * @return
     */
    private Node<K,V> getNode(Node<K,V> node,K key){
        if (key == null || node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        } else if (key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        } else {
            return node;
        }
    }

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public V set(K key,V value){
        Node<K,V> node = getNode(root,key);
        if (node == null){
            return null;
        }
        V old = node.value;
        node.value = value;
        return old;
    }

    /**
     * 前序遍历 根结点 -> 左子树 -> 右子树
     * @return
     */
    public List<K> preOrder(){
        List<K> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(Node<K,V> node, List<K> list){
        if (node == null){
            return;
        }

        list.add(node.key);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    /**
     * 前序遍历非递归实现
     * @return
     */
    public List<K> preOrderNR(){
        List<K> list = new ArrayList<>();

        //使用栈来记录之后要遍历那些结点
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<K,V> cur = stack.pop();
            //先访问前序结点
            list.add(cur.key);

            //根据栈的特性，先压入右子树
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return list;
    }


    /**
     * 中序遍历 左子树 -> 根结点 -> 右子树
     * @return
     */
    public List<K> inOrder(){
        List<K> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    private void inOrder(Node<K,V> node, List<K> list){
        if (node == null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.key);
        inOrder(node.right,list);
    }

    /**
     * 后序遍历 左子树 -> 右子树 -> 根结点
     * @return
     */
    public List<K> postOrder(){
        List<K> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    private void postOrder(Node<K,V> node, List<K> list){
        if (node == null){
            return;
        }

        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.key);
    }

    /**
     * 层序遍历
     * @return
     */
    public List<K> levelOrder(){
        List<K> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<K,V> cur = queue.remove();
            list.add(cur.key);

            if (cur.left != null){
                queue.add(cur.left);
            }

            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return list;
    }

    /**
     * 删除BST中最小的值
     * @return
     */
    public K removeMin(){
        K key = findMin();
        root = removeMin(root);
        return key;
    }

    /**
     * 删除以node为根节点的最小值
     * @param node
     * @return 返回删除后的根节点
     */
    private Node<K,V> removeMin(Node<K,V> node){
        //找到最小元素了
        if (node.left == null){
            Node right = node.right;
            //方便垃圾回收
            node.right = null;
            size--;
            return right;
        }
        //继续在左子树中找
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除BST中最大的值
     * @return
     */
    public K removeMax(){
        K key = findMax();
        root = removeMax(root);
        return key;
    }

    /**
     * 删除以node为根节点的最大值
     * @param node
     * @return 返回删除后的根节点
     */
    private Node<K,V> removeMax(Node<K,V> node){
        //找到最小元素了
        if (node.right == null){
            Node left = node.left;
            //方便垃圾回收
            node.left = null;
            size--;
            return left;
        }
        //继续在左子树中找
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 返回BST中最小的值
     * @return
     */
    public K findMin(){
        return findMin(root);
    }

    /**
     * 返回以node为根节点的BST的最小值
     * @param node
     * @return
     */
    private K findMin(Node<K,V> node){
        if (node.left == null){
            return node.key;
        }
        return findMin(node.left);
    }

    /**
     * 返回BST中最大的值
     * @return
     */
    public K findMax(){
        return findMax(root);
    }

    /**
     * 返回以node为根节点的BST的最小值
     * @param node
     * @return
     */
    private K findMax(Node<K,V> node){
        if (node.right == null){
            return node.key;
        }
        return findMax(node.right);
    }

    /**
     * 删除元素
     * @param key
     */
    public void remove(K key){
        if (!contains(key)){
            return;
        }
        root = remove(root,key);
    }

    /**
     * 在以node为根的BST中删除e,返回新的树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node<K,V> node, K key){
        if (node == null){
            return null;
        }
        Node retNode = null;

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            retNode = node;
        } else {
            if (node.left == null){
                Node right = node.right;
                //断开指向
                node.right = null;
                size--;
                retNode = right;
            } else if (node.right == null){
                Node left = node.left;
                //断开指向
                node.left = null;
                size--;
                retNode = left;
            } else {
                //找到后继结点
                Node<K,V> newNode = findMinNode(node.right);
                newNode.left = node.left;
                //删除右子树最小的结点
                newNode.right = remove(node.right,newNode.key);
                node.left = null;
                node.right = null;
                retNode = newNode;
            }
        }

        if (retNode == null){
            return retNode;
        }

        //更新height
        retNode.height = Math.max(getHeight(retNode.left),getHeight(retNode.right));

        //获取平衡因子
        int balance = getBalanceFactor(retNode);
        //进行平衡处理
        if (balance > 1 && getBalanceFactor(retNode.left) >= 0){
            //添加的结点在左子树的左侧 LL 右旋
            retNode = rightRotate(retNode);
        }else if (balance > 1 && getBalanceFactor(retNode.left) < 0){
            //添加的结点在左子树的右侧 LR 先左旋左子树再右旋
            retNode.left = leftRotate(retNode.left);
            retNode = rightRotate(retNode);

        }else if (balance < -1 && getBalanceFactor(retNode.right) > 0){
            //添加的结点在右子树的左侧 RL 先右旋右子树再左旋
            retNode.right = rightRotate(retNode.right);
            retNode = leftRotate(retNode);
        } else if (balance < -1 && getBalanceFactor(retNode.right) <= 0){
            //添加的结点在右子树的右侧 RR 左旋
            retNode = leftRotate(retNode);
        }
        return retNode;
    }

    /**
     * 返回以node为根的最小的结点
     * @param node
     * @return
     */
    private Node<K,V> findMinNode(Node<K,V> node){
        if (node == null){
            return null;
        }
        if (node.left == null){
            return node;
        }
        return findMinNode(node.left);
    }

    /**
     * 返回以node为根的最大的结点
     * @return
     */
    private Node<K,V> findMaxNode(Node<K,V> node){
        if (node == null){
            return null;
        }
        if (node.right == null){
            return node;
        }
        return findMaxNode(node.right);
    }

    /**
     * 获取结点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 获取平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     *  对节点node进行向左旋转操作，返回旋转后新的根节点x
     *      node                            x
     *    /   \                          /   \
     *   T1   x      向左旋转 (y)     node   z
     *      / \   - - - - - - - ->   / \   / \
     *    T2  z                     T1 T2 T3 T4
     *      / \
     *     T3 T4
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node x = node.right;
        Node t2 = x.left;

        //左旋
        x.left = node;
        node.right = t2;

        //更新高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;
    }

    /**
     *  对节点node进行向右旋转操作，返回旋转后新的根节点x
     *          node                             x
     *          / \                           /   \
     *         x   T4     向右旋转 (y)       z    node
     *        / \       - - - - - - - ->    / \   / \
     *       z   T3                       T1  T2 T3 T4
     *     / \
     *    T1   T2
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node x = node.right;
        Node t3 = x.right;

        //右旋
        x.right = node;
        node.left = t3;

        //更新高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }

}
