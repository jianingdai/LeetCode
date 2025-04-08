package com.whu.LC211_220;

public class LC215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length-1;i>=nums.length-k+1;--i){
            // 大根堆出堆排序
            swap(nums,0,i);
            --heapSize;
            maxHeapify(nums,0,heapSize);
        }
        // 此时大根堆中最大的就是
        return nums[0];
    }

    private void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if(l<heapSize&&a[l]>a[largest]){
            largest = l;
        }
        if(r<heapSize&&a[r]>a[largest]){
            largest = r;

        }
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
