package com.whu.LC1_100.LC31_40;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound2(nums, target);
        int end = lowerBound2(nums, target + 1);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end - 1};

    }

    //    左闭右开写法可以确保找到的target的坐标是数组中值为target的最小的坐标，由于方法内没有直接比较“==”
    private int lowerBound2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
//                ！！！
                right = mid;
            }
        }
        return left;
    }
}
