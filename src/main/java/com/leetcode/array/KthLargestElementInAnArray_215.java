package com.leetcode.array;

/**
 * @author Created by qiyei2015 on 2020/1/12.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray_215 {


    public static void main(String[] args) {
        int[] arr1 = new int[]{3,2,1,5,6,4};
        int[] arr2 = new int[]{3,2,3,1,2,4,5,5,6};

        System.out.println("aar1=" + new KthLargestElementInAnArray_215().findKthLargest(arr1,2));
        System.out.println("aar2=" + new KthLargestElementInAnArray_215().findKthLargest(arr2,4));
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //a[0..p -1] < p a[p+1..] > p
        int p = partition(nums,0,nums.length -1);
        //第1大，排名length -1
        int rankN = nums.length -1 - (k-1);

        while (p != rankN){
            if (p < rankN){
                p = partition(nums,p + 1,nums.length -1);
            } else {
                p = partition(nums,0,p - 1);
            }
        }
        return nums[p];
    }

    /**
     * 在数组arrar中找到排序n的数组
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] array,int l,int r){
        int v = array[l];
        //[l+1..j] < v
        int j = l;

        for (int i = l + 1;i <= r;i++){
            if (array[i] < v){
                j++;
                swap(array,i,j);
            }
        }
        swap(array,l,j);
        return j;
    }

    /**
     * 交换数组
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
