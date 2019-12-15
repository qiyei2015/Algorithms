package com.qiyei.datastructure.tree;

import java.util.*;

/**
 * @author Created by qiyei2015 on 2019/12/14.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 红黑树
 * 性质1：每个节点要么是黑色，要么是红色。
 * 性质2：根节点是黑色。
 * 性质3：每个叶子节点（NIL）是黑色。(其实就是定义空结点的颜色是黑色)
 * 性质4：每个红色结点的两个子结点一定都是黑色。
 * 性质5：任意一结点到每个叶子结点的路径都包含数量相同的黑结点。
 *
 */
public class RBTree<K extends Comparable<K>,V> {
    /**
     * 等价于2-3树中的3结点
     * 所以红黑树中红色结点的意义就是该结点与其父结点是一个融合结点，即是一个3结点
     * 其本质是代表的该结点与父节点连接的边是红色，为了表示方便，我们将该结点设置为红色
     * 所有红色结点都是左倾斜的
     */
    private static final boolean RED = true;
    /**
     * 等价于2-3树中的2结点
     */
    private static final boolean BLACK = false;

    /**
     * 结点定义
     * @param <K>
     * @param <V>
     */
    private static class Node<K,V>{
        K key;
        V value;
        boolean color;

        Node<K,V> left;
        Node<K,V> right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            //添加结点时，先进行融合，因此颜色为RED
            color = RED;
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

    public RBTree() {
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
     * 红黑树添加结点
     * @param key
     */
    public void add(K key,V value){
        root = add(root,key,value);
        root.color = BLACK;
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

        if (isRed(node.right) && !isRed(node.left)){
            //添加的结点在右子树，左子树为黑结点
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)){
            //添加的结点在左子树的左子树
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)){
            //添加的结点在右子树，并且左子树也是红色
            flipColors(node);
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
    private Node<K,V> getNode(Node<K,V> node, K key){
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
     *  对节点node进行向左旋转操作，返回旋转后新的根节点x
     *      node                            x
     *    /   \                          /   \
     *   T1   x      向左旋转 (y)     node   z
     *      / \   - - - - - - - ->   / \
     *    T2  z                     T1 T2
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node x = node.right;
        Node t2 = x.left;

        //左旋
        node.right = t2;
        x.left = node;

        //更新颜色
        x.color = node.color;
        //表示与父结点融合在一起的
        node.color = RED;

        return x;
    }

    /**
     *  对节点node进行向右旋转操作，返回旋转后新的根节点x
     *          node                             x
     *          / \                           /   \
     *         x   T2     向右旋转 (y)       z    node
     *        / \       - - - - - - - ->         /  \
     *       z   T1                             T1  T2
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node x = node.right;
        Node t1 = x.right;

        //右旋
        x.right = node;
        node.left = t1;

        //更新颜色
        x.color = node.color;
        //表示与父结点融合在一起的
        node.color = RED;

        return x;
    }

    /**
     * 对node及其子节点进行颜色反转
     * @param node
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 判断结点的颜色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if (node == null){
            return BLACK;
        }
        return node.color;
    }
}
