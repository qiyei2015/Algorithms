package com.backup.backup.tree;

import com.backup.backup.util.LogUtil;
import sun.misc.Queue;

/**
 * @author Created by qiyei2015 on 2018/3/31.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 二分搜索树
 */
public class BST<K extends Comparable<K>,V> {

    /**
     * 根节点
     */
    private Node<K,V> root;

    private int count;

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void insert(K key,V value){
        root = insert(root,key,value);
    }

    /**
     * 是否包含
     * @param key
     * @return
     */
    public boolean contains(K key){
        return contains(root,key);
    }

    /**
     * 搜索key对应的Value
     * @param key
     * @return
     */
    public V search(K key){
        return search(root,key);
    }

    /**
     * 判断是否为NULL
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return count;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 后续遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new Queue<>();
        //入队
        queue.enqueue(root);
        while (!queue.isEmpty()){
            try {
                Node node = queue.dequeue();
                LogUtil.print(getNodeMessage(node));
                if (node!= null && node.left != null){
                    queue.enqueue(node.left);
                }
                if (node!= null && node.right != null){
                    queue.enqueue(node.right);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 找到最小结点
     * @return
     */
    public K minimum(){
        if (root == null){
            return null;
        }
        Node node = minimum(root);
        return (K) node.key;
    }

    public K maximum(){
        if (root == null){
            return null;
        }
        Node node = maximum(root);
        return (K) node.key;
    }

    /**
     * 删除最小结点
     */
    public void removeMin(){
        if (root == null){
            return ;
        }
        Node node = removeMin(root);
    }

    /**
     * 删除最大结点
     * @return
     */
    public void removeMax(){
        if (root == null){
            return ;
        }
        Node node = removeMax(root);
    }

    /**
     * 返回key的排名 实现思路，在每个结点下在增加一个元素来存储该结点下的元素个数
     * @param key
     * @return
     */
    public int rank(K key){
        return 0;
    }

    /**
     * 获取排名k的元素
     * @param k
     * @return
     */
    public K select(int k){
        return null;
    }

    /**
     * 删除结点
     * @param key
     */
    public void remove(K key){
        root = remove(root,key);
    }

    /**
     * 如果该元素存在，则返回该元素，不存在就返回小于该元素中最大的
     * @param key
     * @return
     */
    protected Node floor(K key){
        return null;
    }

    /**
     * 如果该元素存在，则返回该元素，不存在就返回大于该元素中最小的
     * @param key
     * @return
     */
    protected Node ceil(K key){
        return null;
    }

    /**
     * 某个结点的前驱结点
     * @param key 该结点，在二叉树中必须存在
     * @return
     */
    protected Node predecessor(K key){
        return null;
    }

    /**
     * 某个结点的后驱结点
     * @param key
     * @return
     */
    protected Node successor(K key){

        return null;
    }

    /**
     * 内部类
     * @param <K>
     * @param <V>
     */
    static class Node<K extends Comparable<K>,V>{
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Node(Node<K,V> node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    /**
     * 递归方式插入节点
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, K key, V value) {
        if (node == null){
            node = new Node(key,value);
            count++;
            return node;
        }
        if (key.compareTo((K) node.key) == 0){
            //相等直接更新Value
            node.value = value;
        }else if (key.compareTo((K)(node.key)) < 0){
            //在左子树中插入
            node.left = insert(node.left,key,value);
        }else {
            //在右子树中插入
            node.right = insert(node.right,key,value);
        }
        return node;
    }

    /**
     * 插入二叉树，非递归方式，迭代方式
     * @param root
     * @param key
     * @param value
     * @return
     */
    private Node insert2(Node root, K key, V value){
        if (root == null){
            root = new Node(key,value);
            return root;
        }
        Node p = root;
        while (true){

            if (p.key == null){
                p = new Node(key,value);
                count++;
                break;
            }
            if (key.compareTo((K) p.key) == 0){
                //相等直接更新Value
                root.value = value;
                break;
            }else if (key.compareTo((K) p.key) < 0){
                //在左子树中插入
                p = p.left;
            }else {
                //在右子树中插入
                p = p.right;
            }
        }
        return root;
    }

    /**
     * 在root根节点中查找是否包含key
     * @param node
     * @param key
     * @return
     */
    private boolean contains(Node node,K key){
        if (node == null){
            return false;
        }
        if (node.key.compareTo(key) == 0){
            return true;
        }else if (key.compareTo((K)(node.key)) < 0){
            return contains(node.left,key);
        }else {
            return contains(node.right,key);
        }
    }

    /**
     * 在root中搜索key对应的value
     * @param node
     * @param key
     * @return
     */
    private V search(Node<K, V> node, K key) {
        if (node == null){
            return null;
        }
        if (node.key.compareTo(key) == 0){
            return root.value;
        }else if (key.compareTo((K)(node.key)) < 0){
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }

    /**
     * 递归方式前序遍历
     * @param node
     */
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        printNode(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 递归方式中序遍历
     * @param node
     */
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        printNode(node);
        inOrder(node.right);
    }

    /**
     * 递归后序遍历
     * @param node
     */
    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
    }

    /**
     * 返回最小的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        //如果没有左子树，就返回该节点
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 返回最大的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        //没有右子树，返回最大节点
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小结点
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        //没有左子树了，该节点就是最小结点
        if (node.left == null){
            //直接删除该节点
            Node temp = node.right;
            node = null;
            count--;
            return temp;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大结点
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        //没有右子树了，该结点就是最大结点
        if (node.right == null){
            //直接删除该节点
            Node temp = node.left;
            node = null;
            count--;
            return temp;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除以node为根结点的key
     * @param node
     * @param key
     * @return 返回删除后的root结点
     */
    private Node<K,V> remove(Node<K, V> node, K key) {
        if (node == null || key == null){
            return null;
        }

        if (key.compareTo(node.key) < 0){
            //在左子树中删除
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            //在右子树中删除
            node.right = remove(node.right,key);
            return node;
        }else {
            //如果只有右子结点
            if (node.left == null){
                Node tempRight = node.right;
                count--;
                node = null;
                return tempRight;
            }
            //如果只有左子结点
            if (node.right == null){
                Node tempLeft = node.left;
                count--;
                node = null;
                return tempLeft;
            }

            /**
             * 如果左右子节点都有
             * 找到这个结点的后驱结点，然后删除这个结点，并用这个后驱结点替换这个结点，左子树和右子树部分不变
             * 后驱结点 就是该结点的右子树的minimum(node.right)
             */
            Node successor = new Node(minimum(node.right));
            count++;
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node = null;
            count--;
            return successor;

//            /**
//             * 找到前驱结点的删除
//             */
//            Node preNode = new Node(maximum(node.left));
//            count++;
//            successor.left = removeMax(node.left);
//            successor.right = node.right;
//            node = null;
//            count--;
//            return preNode;

        }
    }



    /**
     * 打印node信息
     * @param node
     */
    private void printNode(Node node){
        LogUtil.print(getNodeMessage(node));
        LogUtil.print(" ");
    }

    /**
     * 获取node信息
     * @param node
     * @return
     */
    private String getNodeMessage(Node node){
        if (node == null){
            return null;
        }
        return "[" + node.key + " " + node.value + "]";
    }
}
