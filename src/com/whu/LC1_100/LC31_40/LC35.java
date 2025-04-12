package com.whu.LC1_100.LC31_40;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}

