package com.leetcode.tree;

/**
 * @author Created by qiyei2015 on 2020/2/24.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0){
            return null;
        }
        int mid = nums.length / 2;

        TreeNode root = new TreeNode(nums[mid]);
        addNode(nums,root,0,mid - 1);
        addNode(nums,root,mid + 1,nums.length - 1);
        return root;
    }

    private void addNode(int[] nums,TreeNode root,int l,int r){
        if (l > r){
            return ;
        }
        int mid = l + ( r - l ) / 2;
        int val = nums[mid];

        if (val < root.val){
            TreeNode left = new TreeNode(val);
            root.left = left;
            addNode(nums,root.left,l,mid-1);
            addNode(nums,root.left,mid+1,r);
        } else if (val > root.val){
            TreeNode right = new TreeNode(val);
            root.right = right;
            addNode(nums,root.right,l,mid-1);
            addNode(nums,root.right,mid+1,r);
        }
    }
}
